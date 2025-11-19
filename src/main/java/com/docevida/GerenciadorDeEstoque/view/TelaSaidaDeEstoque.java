package com.docevida.GerenciadorDeEstoque.view;

import com.docevida.GerenciadorDeEstoque.service.ProdutoService;

import javax.swing.*;
import java.awt.*;

public class TelaSaidaDeEstoque extends JFrame {

    private final ProdutoService produtoService;

    public TelaSaidaDeEstoque(ProdutoService produtoService) {

        this.produtoService = produtoService;

        setTitle("Saída de Estoque");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        JLabel lblId = new JLabel("ID do Produto:");
        JTextField txtId = new JTextField();

        JLabel lblQuantidade = new JLabel("Quantidade a retirar:");
        JTextField txtQuantidade = new JTextField();

        JButton btnConfirmar = new JButton("Confirmar Saída");

        add(lblId);
        add(txtId);
        add(lblQuantidade);
        add(txtQuantidade);
        add(new JLabel());
        add(btnConfirmar);

        btnConfirmar.addActionListener(e -> {
            try {
                Long id = Long.parseLong(txtId.getText().trim());
                int quantidade = Integer.parseInt(txtQuantidade.getText().trim());

                var optProduto = produtoService.buscarPorId(id);
                if (optProduto.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Produto não encontrado!");
                    return;
                }

                var produto = optProduto.get();

                if (produto.getQuantidade() < quantidade) {
                    JOptionPane.showMessageDialog(this,
                            "Estoque insuficiente! Estoque atual: " + produto.getQuantidade());
                    return;
                }

                produtoService.removerEstoque(id, quantidade);

                JOptionPane.showMessageDialog(this, "Saída registrada com sucesso!");
                dispose();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
            }
        });

        setVisible(true);
    }
}

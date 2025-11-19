package com.docevida.GerenciadorDeEstoque.view;

import com.docevida.GerenciadorDeEstoque.model.Produto;
import com.docevida.GerenciadorDeEstoque.service.ProdutoService;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaEntradaDeEstoque extends JFrame {

    private final ProdutoService produtoService;

    public TelaEntradaDeEstoque(ProdutoService produtoService) {
        this.produtoService = produtoService;

        setTitle("Entrada de Estoque");
        setSize(350, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 10, 10));

        JLabel lblProduto = new JLabel("Produto:");
        JComboBox<Produto> comboProdutos = new JComboBox<>();

        JLabel lblQuantidade = new JLabel("Quantidade:");
        JTextField txtQuantidade = new JTextField();

        JButton btnAdicionar = new JButton("Adicionar");

        List<Produto> produtos = produtoService.listarTodos();
        for (Produto p : produtos) {
            comboProdutos.addItem(p);
        }

        add(lblProduto);
        add(comboProdutos);
        add(lblQuantidade);
        add(txtQuantidade);
        add(new JLabel());
        add(btnAdicionar);

        btnAdicionar.addActionListener(e -> {
            try {
                Produto selecionado = (Produto) comboProdutos.getSelectedItem();
                int quantidade = Integer.parseInt(txtQuantidade.getText().trim());

                produtoService.adicionarEstoque(selecionado.getId(), quantidade);

                JOptionPane.showMessageDialog(this, "Estoque atualizado com sucesso!");
                dispose();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
            }
        });

        setVisible(true);
    }
}

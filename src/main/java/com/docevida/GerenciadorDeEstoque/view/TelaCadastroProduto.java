package com.docevida.GerenciadorDeEstoque.view;

import com.docevida.GerenciadorDeEstoque.model.Produto;
import com.docevida.GerenciadorDeEstoque.service.ProdutoService;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;

public class TelaCadastroProduto extends JFrame {

    private final ProdutoService produtoService;


    public TelaCadastroProduto(ProdutoService produtoService) {

        this.produtoService = produtoService;

        setTitle("Cadastrar Produto");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10));

        JLabel lblNome = new JLabel("Nome:");
        JTextField txtNome = new JTextField();

        JLabel lblQuantidade = new JLabel("Quantidade:");
        JTextField txtQuantidade = new JTextField();

        JLabel lblPreco = new JLabel("Preço:");
        JTextField txtPreco = new JTextField();

        JButton btnSalvar = new JButton("Salvar");

        add(lblNome);
        add(txtNome);
        add(lblQuantidade);
        add(txtQuantidade);
        add(lblPreco);
        add(txtPreco);
        add(new JLabel()); // espaço vazio
        add(btnSalvar);

        btnSalvar.addActionListener(e -> {
            try {
                String nome = txtNome.getText().trim();
                int quantidade = Integer.parseInt(txtQuantidade.getText().trim());
                BigDecimal preco = new BigDecimal(txtPreco.getText().trim());

                Produto produto = new Produto();
                produto.setNome(nome);
                produto.setQuantidade(quantidade);
                produto.setPrecoVenda(preco); // ou setPrecoCompra, dependendo do seu modelo

                produtoService.salvarProduto(produto);

                JOptionPane.showMessageDialog(this, "Produto cadastrado com sucesso!");
                dispose();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar: " + ex.getMessage());
            }
        });

        setVisible(true);
    }
}

package com.docevida.GerenciadorDeEstoque.view;

import com.docevida.GerenciadorDeEstoque.service.ProdutoService;

import javax.swing.*;
import java.awt.*;

public class TelaPrincipal extends JFrame {

    private final ProdutoService produtoService;

    public TelaPrincipal(ProdutoService produtoService) {
        this.produtoService = produtoService;

        setTitle("Gerenciador de Estoque - Doce Vida");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(4,1,10,10));

        JButton btnCadastrar = new JButton("Cadastrar Produto");
        JButton btnEntrada = new JButton("Entrada de Estoque");
        JButton btnSaida = new JButton("Saída de Estoque");
        JButton btnListar = new JButton("Listar Produtos");

        add(btnCadastrar);
        add(btnEntrada);
        add(btnSaida);
        add(btnListar);

        btnCadastrar.addActionListener(e -> new TelaCadastroProduto(produtoService));
        btnEntrada.addActionListener(e -> new TelaEntradaDeEstoque(produtoService));
        btnSaida.addActionListener(e -> new TelaSaidaDeEstoque(produtoService));
        btnListar.addActionListener(e -> new TelaListarProdutos(produtoService));

        setVisible(true);
    }

    public static void main(String[] args) {
        ProdutoService produtoService = new ProdutoService(null); // exemplo até você integrar o repository

        SwingUtilities.invokeLater(() -> new TelaPrincipal(produtoService));
    }
}

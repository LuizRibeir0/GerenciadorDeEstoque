package com.docevida.GerenciadorDeEstoque.view;

import com.docevida.GerenciadorDeEstoque.model.Produto;
import com.docevida.GerenciadorDeEstoque.service.ProdutoService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TelaListarProdutos extends JFrame {

    private final ProdutoService produtoService;
    private JTable tabela;
    private DefaultTableModel modelo;

    public TelaListarProdutos(ProdutoService produtoService) {

        this.produtoService = produtoService;

        setTitle("Lista de Produtos");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        String[] colunas = {"ID", "Nome", "Quantidade", "Preço"};

        modelo = new DefaultTableModel(colunas, 0);
        tabela = new JTable(modelo);

        JScrollPane scroll = new JScrollPane(tabela);

        JButton btnRecarregar = new JButton("Recarregar Lista");
        btnRecarregar.addActionListener(e -> carregarTabela());

        add(scroll, BorderLayout.CENTER);
        add(btnRecarregar, BorderLayout.SOUTH);

        carregarTabela();
        setVisible(true);
    }

    private void carregarTabela() {
        modelo.setRowCount(0); // limpa a tabela

        List<Produto> produtos = produtoService.listarTodos();

        for (Produto p : produtos) {
            modelo.addRow(new Object[]{
                    p.getId(),
                    p.getNome(),
                    p.getQuantidade(),
                    p.getPrecoVenda()
            });
        }
    }
}

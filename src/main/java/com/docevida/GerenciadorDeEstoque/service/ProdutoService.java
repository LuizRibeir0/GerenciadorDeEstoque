package com.docevida.GerenciadorDeEstoque.service;

import com.docevida.GerenciadorDeEstoque.model.Produto;
import com.docevida.GerenciadorDeEstoque.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto salvarProduto (Produto produto) {
        return produtoRepository.save(produto);
    }

    public void detarProduto(Long id) {
    }

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }

    public void adicionarEstoque(Long id, int quantidade) {
        Produto produto = produtoRepository.findById(id).orElseThrow();
        produto.setQuantidade(produto.getQuantidade() + quantidade);
        produtoRepository.save(produto);
    }

    public void removerEstoque(Long id, int quantidade) {
        Produto produto = produtoRepository.findById(id).orElseThrow();
        produto.setQuantidade(produto.getQuantidade() - quantidade);
        produtoRepository.save(produto);
    }
}

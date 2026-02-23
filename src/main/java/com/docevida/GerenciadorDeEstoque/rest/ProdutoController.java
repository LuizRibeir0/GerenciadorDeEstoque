package com.docevida.GerenciadorDeEstoque.rest;

import com.docevida.GerenciadorDeEstoque.model.Produto;
import com.docevida.GerenciadorDeEstoque.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping("/saveProdutos")
    public Produto salvarProduto(Produto produto) {
        return produtoService.salvarProduto(produto);
    }

    @GetMapping("/getProdutos")
    public List<Produto> listarTodos() {
        return produtoService.listarTodos();
    }

    @DeleteMapping("/deleteProdutos/{id}")
    public void excluirProduto(@PathVariable long id) {
        produtoService.deletarProduto(id);
    }

    @GetMapping("/dockerTeste")
    public String testeDocker() {
        return "Testando docker";
    }
}

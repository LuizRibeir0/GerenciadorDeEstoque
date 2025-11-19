package com.docevida.GerenciadorDeEstoque;

import com.docevida.GerenciadorDeEstoque.service.ProdutoService;
import com.docevida.GerenciadorDeEstoque.view.TelaPrincipal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private final ProdutoService produtoService;

    public Application(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        app.setHeadless(false);
        app.run(args);
    }

    @Override
    public void run(String... args) {
        SwingUtilities.invokeLater(() -> new TelaPrincipal(produtoService));
    }
}

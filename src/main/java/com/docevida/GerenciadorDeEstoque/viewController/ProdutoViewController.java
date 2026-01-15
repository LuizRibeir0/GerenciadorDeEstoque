package com.docevida.GerenciadorDeEstoque.viewController;

import com.docevida.GerenciadorDeEstoque.model.Produto;
import com.docevida.GerenciadorDeEstoque.service.ProdutoService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.stereotype.Component;

@Component
public class ProdutoViewController {

    private ProdutoService produtoService;

    public ProdutoViewController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }


    @FXML
    private TableView<Produto> tabelaProdutos;

    @FXML
    private TableColumn<Produto, Long> colId;

    @FXML
    private TableColumn<Produto, String> colNome;

    @FXML
    private TableColumn<Produto, Integer> colQuantidade;

    @FXML
    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));

        tabelaProdutos.setItems(
                FXCollections.observableArrayList(
                        produtoService.listarTodos()
                )
        );
    }
}

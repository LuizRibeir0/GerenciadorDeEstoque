package com.docevida.GerenciadorDeEstoque.viewController;

import com.docevida.GerenciadorDeEstoque.model.Produto;
import com.docevida.GerenciadorDeEstoque.service.ProdutoService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;


@Component
public class CadastroProdutoController {

    private final ProdutoService produtoService;

    public CadastroProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtQuantidade;

    @FXML
    public void salvar() {
        try {
            Produto produto = new Produto();
            produto.setNome(txtNome.getText());
            produto.setQuantidade(Integer.parseInt(txtQuantidade.getText()));

            produtoService.salvarProduto(produto);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sucesso");
            alert.setHeaderText(null);
            alert.setContentText("Produto cadastrado com sucesso!");
            alert.showAndWait();

            txtNome.clear();
            txtQuantidade.clear();

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("Dados inválidos!");
            alert.showAndWait();
        }
    }

    @FXML
    public void voltar() {
        ((Stage) txtNome.getScene().getWindow()).close();
    }
}

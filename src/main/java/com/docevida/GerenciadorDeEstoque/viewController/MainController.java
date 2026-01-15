package com.docevida.GerenciadorDeEstoque.viewController;

import com.docevida.GerenciadorDeEstoque.config.SpringContext;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

@Component
public class MainController {

    @FXML
    public void abrirProdutos() {
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/fxml/produtos-view.fxml")
            );

            loader.setControllerFactory(SpringContext.getContext()::getBean);

            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            stage.setTitle("Produtos");
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void abrirCadastro(ActionEvent event) {
        System.out.println("Abrir tela de cadastro");
    }

    public void sair(ActionEvent event) {
        System.exit(0);
    }
}

package com.docevida.GerenciadorDeEstoque;

import com.docevida.GerenciadorDeEstoque.config.SpringContext;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import javafx.application.Application;

public class JavaFxApplication extends Application {

    private static ConfigurableApplicationContext context;

    @Override
    public void init() {
        context = new SpringApplicationBuilder(EstoqueApplication.class)
                .web(org.springframework.boot.WebApplicationType.NONE)
                .run();

        SpringContext.setContext(context);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/fxml/view.fxml")
        );

        loader.setControllerFactory(context::getBean);

        Parent root = loader.load();

        stage.setTitle("Gerenciador de Estoque");
        stage.setScene(new Scene(root));
        stage.show();
    }

    @Override
    public void stop() {
        context.close();
        Platform.exit();
    }
}

package ku.cs.bankaccountdemo1;

import ku.cs.services.FXRouter;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXRouter.bind(this, stage, "Hello World");
        configRoute();
        FXRouter.goTo("hello");
        //FXRouter.goTo("customer-list");
    }

    public static void configRoute()
    {
        String viewPath = "ku/cs/views/";
        FXRouter.when("hello", viewPath +"hello-view.fxml");
        FXRouter.when("customer-profile", viewPath + "customer.fxml");
        FXRouter.when("customer-list", viewPath + "customer-list.fxml");
    }

    public static void main(String[] args) {
        launch();
    }
}
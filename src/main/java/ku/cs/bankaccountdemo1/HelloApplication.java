package ku.cs.bankaccountdemo1;

import ku.cs.services.FXRouter;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXRouter.bind(this, stage, "Sonic Bank.com");
        configRoute();
        //FXRouter.goTo("admin");
        FXRouter.goTo("hello");
        //FXRouter.goTo("customer-list");
    }

    public static void configRoute()
    {
        String viewPath = "ku/cs/views/";
        FXRouter.when("hello", viewPath +"hello-view.fxml");
        FXRouter.when("login", viewPath +"login.fxml");
        FXRouter.when("register", viewPath +"admin-register.fxml");
        FXRouter.when("success", viewPath +"success-register.fxml");
        FXRouter.when("admin-list", viewPath +"admin-list.fxml");
        FXRouter.when("admin", viewPath +"admin.fxml");
        FXRouter.when("customer-profile", viewPath + "customer.fxml");
        FXRouter.when("customer-list", viewPath + "customer-list.fxml");
        FXRouter.when("customers-table", viewPath + "customers-table.fxml");
        FXRouter.when("customer-balance", viewPath + "customer-balance.fxml");
    }

    public static void main(String[] args) {
        launch();
    }
}
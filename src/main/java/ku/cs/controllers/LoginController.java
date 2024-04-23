package ku.cs.controllers;

import ku.cs.models.Customer;
import ku.cs.models.CustomerList;
import ku.cs.services.AdminHardCodeDatasource;
import ku.cs.services.CustomerHardCodeDatasource;
import ku.cs.services.FXRouter;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import ku.cs.models.Admin;
import ku.cs.models.AdminList;
import ku.cs.services.AdminHardCodeDatasource;

import java.io.IOException;
public class LoginController {




    @FXML
    public void onBackButtonClick() {
        try {
            FXRouter.goTo("hello");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void onNextButtonClick() {
        try {
            FXRouter.goTo("admin-list");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


//เหลือสร้างหน้าAdmin List Info

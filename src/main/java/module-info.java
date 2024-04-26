module ku.cs {
    requires javafx.controls;
    requires javafx.fxml;


    opens ku.cs.bankaccountdemo1 to javafx.fxml;
    exports ku.cs.bankaccountdemo1;

    exports ku.cs.controllers;
    opens ku.cs.controllers to javafx.fxml;
}
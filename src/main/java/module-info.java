module ku.cs.bankaccountdemo1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ku.cs.bankaccountdemo1 to javafx.fxml;
    exports ku.cs.bankaccountdemo1;
}
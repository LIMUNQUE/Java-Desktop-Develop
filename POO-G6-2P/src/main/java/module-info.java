module com.espol.poo.g6.p {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.espol.poo.g6.p to javafx.fxml;
    exports com.espol.poo.g6.p;
}

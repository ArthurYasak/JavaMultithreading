module com.example.bacteriacolony {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bacteriacolony to javafx.fxml;
    exports com.example.bacteriacolony;
}
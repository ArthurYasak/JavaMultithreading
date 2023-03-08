module com.example.bacteriacolony {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bacteriacolony to javafx.fxml;
    exports com.example.bacteriacolony;
    exports com.example.bacteriacolony.gui;
    opens com.example.bacteriacolony.gui to javafx.fxml;
    exports com.example.bacteriacolony.calculations;
    opens com.example.bacteriacolony.calculations to javafx.fxml;
}
module Offline.test2 {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    opens sample to javafx.graphics, javafx.fxml, javafx.base;
}
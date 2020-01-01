module PaintMain {

    requires javafx.controls;
    requires  javafx.fxml;      // alla moduler får läsa denna kod.
    opens mainMap to javafx.fxml, javafx.graphics; // tillgång till modulerna fx.

}
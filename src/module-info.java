module PaintMain {

    requires javafx.controls;
    requires  javafx.fxml;
    opens mainMap to javafx.fxml, javafx.graphics; //här skall information om var modulen finns läggas in antar jag.

}
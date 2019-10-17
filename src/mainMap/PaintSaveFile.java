package mainMap;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class  PaintSaveFile {

    public PaintSaveFile() {
    }

    public void saveSVGMethod(PaintModel paintmodel) {

        Stage stage  = new Stage();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter(".svg", "*.svg"));
        File path = fileChooser.showSaveDialog(stage);

        try (FileWriter out = new FileWriter(path)){
            out.write("<?xml version=\"1.0\" standalone=\"no\"?>\n" +
                    "<svg width=\"350\" height=\"440\" version=\"1.1\" xmlns=\"http://www.w3.org/2000/svg\">" +"\n");
            paintmodel.getShapes().stream().forEach(s -> {
                try {
                    out.write(s.stringSVGFormat() + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            out.write("</svg>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

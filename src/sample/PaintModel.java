package sample;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PaintModel {






    private StringProperty  textShowChatWindow = new SimpleStringProperty();
    public String getTextShowChatWindow() {
        return textShowChatWindow.get();
    }
    public StringProperty textShowChatWindowProperty() {
        return textShowChatWindow;
    }
    public void setTextShowChatWindow(String textShowChatWindow) {
        this.textShowChatWindow.set(textShowChatWindow);
    }


    private StringProperty textEnterChatInput = new SimpleStringProperty();
    public String getTextEnterChatInput() {
        return textEnterChatInput.get();
    }
    public StringProperty textEnterChatInputProperty() {
        return textEnterChatInput;
    }
    public void setTextEnterChatInput(String textEnterChatInput) {
        this.textEnterChatInput.set(textEnterChatInput);
    }






    private StringProperty text = new SimpleStringProperty();

    public String getText() {
        return text.get();
    }

    public void setText(String text) {
        this.text.setValue(text);
    }

    public StringProperty textProperty() {
        return text;
    }

    private BooleanProperty enabled = new SimpleBooleanProperty(true);

    public boolean isEnabled() {
        return enabled.get();
    }

    public BooleanProperty enabledProperty() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled.set(enabled);
    }

    private ObservableList<String> items = FXCollections.observableArrayList(
            "A", "B", "C", "D", "E");

    public ObservableList<String> getItems() {
        return items;
    }

    private StringProperty selectedItem = new SimpleStringProperty();

    public String getSelectedItem() {
        return selectedItem.get();
    }

    public StringProperty selectedItemProperty() {
        return selectedItem;
    }

    public void setSelectedItem(String selectedItem) {
        this.selectedItem.set(selectedItem);
    }

}

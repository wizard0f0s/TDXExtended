package TeamDynamix.Utils;

import javafx.scene.layout.BorderPane;

public interface TDXTask {

    String getName();
    int getOrder();
    String getButtonLabel();
    String getDescription();
    String getStatus();
    void execute();
    String getStatusDescription();
    void displayOptions(BorderPane mainBorderPane);
}

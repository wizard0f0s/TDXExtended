module com.wizard0f0s.tdxextended {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.wizard0f0s.tdxextended to javafx.fxml;
    exports com.wizard0f0s.tdxextended;
}
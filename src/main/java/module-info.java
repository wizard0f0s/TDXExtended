module com.wizard0f0s.tdxextended {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;
    requires java.net.http;
    requires java.annotation;


    opens com.wizard0f0s.tdxextended to javafx.fxml;
    exports com.wizard0f0s.tdxextended;
    exports TeamDynamix.Api.Apps;
    exports TeamDynamix.Api.Auth;
    exports TeamDynamix.Api.CustomAttributes;
    exports TeamDynamix.Api.Users;
    exports TeamDynamix.Utils;
    opens TeamDynamix.Utils to javafx.fxml;

}
module com.example.javapracticeanimation {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.javapracticeanimation to javafx.fxml;
    exports com.example.javapracticeanimation;
}
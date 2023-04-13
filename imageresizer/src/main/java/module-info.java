module com.ntmt {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires transitive javafx.graphics;


    opens com.ntmt to javafx.fxml;
    exports com.ntmt;
}

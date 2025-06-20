module com.example.sapatatix {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    // Untuk FXML controller dan akses refleksi
    opens com.example.sapatatix.Controller to javafx.fxml;
    opens com.example.sapatatix.dao to javafx.fxml;
    opens com.example.sapatatix.database to javafx.fxml;
    opens com.example.sapatatix.model to javafx.fxml;
}
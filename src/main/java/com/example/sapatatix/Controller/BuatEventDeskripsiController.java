package com.example.sapatatix.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BuatEventDeskripsiController {

    @FXML
    void onSimpanDanLanjutkan(ActionEvent event) {
        try {
            // Muat FXML berikutnya (banner)
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/sapatatix/FXML/BuatEventBanner.fxml"));
            Parent root = loader.load();

            // Ambil stage saat ini, ganti scene
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

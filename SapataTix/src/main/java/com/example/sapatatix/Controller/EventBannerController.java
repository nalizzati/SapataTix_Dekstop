package com.example.sapatatix.Controller;

import com.example.sapatatix.dao.EventBannerDAO;
import com.example.sapatatix.Model.EventBanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class EventBannerController {
    @FXML private Button pilihFileBtn;
    @FXML private TextField filePathField;
    @FXML private Button simpanBtn;
    @FXML private ImageView bannerImageView;
    @FXML private Button kembaliBtn;

    private File selectedFile;

    @FXML
    private void initialize() {

    }

    @FXML
    private void handlePilihFile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png", "*.gif")
        );
        File file = fileChooser.showOpenDialog(null); // 'null' bisa diganti dengan '((Node)event.getSource()).getScene().getWindow()' untuk pop-up yang lebih baik
        if (file != null) {
            selectedFile = file;
            filePathField.setText(file.getAbsolutePath());
            bannerImageView.setImage(new Image(file.toURI().toString()));
        }
    }

    @FXML
    private void handleSimpan(ActionEvent event) {
        if (selectedFile != null) {
            EventBanner banner = new EventBanner(selectedFile.getAbsolutePath());
            boolean success = EventBannerDAO.insertEventBanner(banner);
            if (success) {
                System.out.println("Banner berhasil disimpan!");
                // Navigasi ke halaman BuatEventTiket.fxml
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/sapatatix/FXML/BuatEventTiket.fxml"));
                    Parent root = loader.load();
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.setTitle("Buat Event Tiket");
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Gagal memuat halaman Buat Event Tiket.");
                }
            } else {
                System.out.println("Gagal menyimpan banner");
            }
        } else {
            System.out.println("Pilih file gambar terlebih dahulu!");
        }
    }

    @FXML
    private void handleKembali(ActionEvent event) {
        // Navigasi ke halaman BuatEventEdit.fxml
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/sapatatix/FXML/BuatEventEdit.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Edit Event");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Gagal memuat halaman Buat Event Edit.");
        }
    }
}
package com.example.sapatatix.Controller;

import dao.EventBannerDAO;
import model.EventBanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class EventBannerController {
    @FXML private Button pilihFileBtn;
    @FXML private TextField filePathField;
    @FXML private Button simpanBtn;
    @FXML private ImageView bannerImageView;

    private File selectedFile;

    @FXML
    private void initialize() {
        // Optional: inisialisasi awal
    }

    @FXML
    private void handlePilihFile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png", "*.gif")
        );
        File file = fileChooser.showOpenDialog(null);
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
            } else {
                System.out.println("Gagal menyimpan banner");
            }
        } else {
            System.out.println("Pilih file gambar terlebih dahulu!");
        }
    }
}
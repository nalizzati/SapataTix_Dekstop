package com.example.sapatatix.Controller;

import com.example.sapatatix.dao.TicketDAO;
import com.example.sapatatix.Model.Ticket;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class BuatEventTiketController {

    @FXML private VBox paidEventVBox;
    @FXML private VBox freeEventVBox;
    @FXML private TextField ticketNameField;
    @FXML private TextField ticketPriceField;
    @FXML private Button minusButton;
    @FXML private TextField totalTicketsField;
    @FXML private Button plusButton;
    @FXML private Button kembaliBtn;
    @FXML private Button simpanDanLanjutkanBtn;

    private String selectedTicketType = "berbayar";
    private int ticketQuantity = 1;

    private int currentEventId = 1;

    @FXML
    private void initialize() {
        updateTicketTypeSelection();
        totalTicketsField.setText(String.valueOf(ticketQuantity));

        ticketPriceField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*([\\.,]\\d{0,2})?")) {
                ticketPriceField.setText(oldValue);
            }
        });
    }

    @FXML
    private void handlePaidEventClick(MouseEvent event) {
        selectedTicketType = "berbayar";
        ticketPriceField.setDisable(false);
        updateTicketTypeSelection();
    }

    @FXML
    private void handleFreeEventClick(MouseEvent event) {
        selectedTicketType = "gratis";
        ticketPriceField.setText("0.00");
        ticketPriceField.setDisable(true);
        updateTicketTypeSelection();
    }

    private void updateTicketTypeSelection() {
        if ("berbayar".equals(selectedTicketType)) {
            paidEventVBox.setStyle("-fx-background-color: #F5F5F5; -fx-background-radius: 10; -fx-border-color: #B83D6E; -fx-border-width: 2;");
            freeEventVBox.setStyle("-fx-background-color: #F5F5F5; -fx-background-radius: 10; -fx-border-color: #CCCCCC; -fx-border-width: 1;");
            ((Label)paidEventVBox.getChildren().get(1)).setTextFill(Color.web("#333333"));
            ((ImageView)paidEventVBox.getChildren().get(0)).setImage(new Image("https://placehold.co/60x60/B83D6E/ffffff?text=Ticket"));

            ((Label)freeEventVBox.getChildren().get(1)).setTextFill(Color.web("#333333"));
            ((ImageView)freeEventVBox.getChildren().get(0)).setImage(new Image("https://placehold.co/60x60/CCCCCC/333333?text=FREE"));

        } else {
            paidEventVBox.setStyle("-fx-background-color: #F5F5F5; -fx-background-radius: 10; -fx-border-color: #CCCCCC; -fx-border-width: 1;");
            freeEventVBox.setStyle("-fx-background-color: #F5F5F5; -fx-background-radius: 10; -fx-border-color: #B83D6E; -fx-border-width: 2;");
            ((Label)paidEventVBox.getChildren().get(1)).setTextFill(Color.web("#333333"));
            ((ImageView)paidEventVBox.getChildren().get(0)).setImage(new Image("https://placehold.co/60x60/B83D6E/ffffff?text=Ticket"));

            ((Label)freeEventVBox.getChildren().get(1)).setTextFill(Color.web("#333333"));
            ((ImageView)freeEventVBox.getChildren().get(0)).setImage(new Image("https://placehold.co/60x60/CCCCCC/333333?text=FREE"));
        }
    }


    @FXML
    private void handleMinusButton(ActionEvent event) {
        if (ticketQuantity > 1) {
            ticketQuantity--;
            totalTicketsField.setText(String.valueOf(ticketQuantity));
        }
    }

    @FXML
    private void handlePlusButton(ActionEvent event) {
        ticketQuantity++;
        totalTicketsField.setText(String.valueOf(ticketQuantity));
    }

    @FXML
    private void handleSimpanDanLanjutkan(ActionEvent event) {
        String ticketName = ticketNameField.getText();
        double price = 0.0;
        try {
            price = Double.parseDouble(ticketPriceField.getText().replace(',', '.'));
        } catch (NumberFormatException e) {
            System.err.println("Harga tiket tidak valid: " + ticketPriceField.getText());
            return;
        }

        if (ticketName.isEmpty()) {
            System.out.println("Nama tiket tidak boleh kosong!");
            return;
        }

        Ticket newTicket = new Ticket(currentEventId, ticketName, price, ticketQuantity, selectedTicketType);

        boolean success = TicketDAO.insertTicket(newTicket);

        if (success) {
            System.out.println("Tiket berhasil disimpan!");
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/sapatatix/FXML/BuatEventPratinjau.fxml"));
                Parent root = loader.load();
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("Pratinjau Event");
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Gagal memuat halaman Pratinjau Event.");
            }
        } else {
            System.out.println("Gagal menyimpan tiket!");
        }
    }

    @FXML
    private void handleKembali(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/sapatatix/FXML/BuatEventBanner.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Buat Event Banner");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Gagal memuat halaman Buat Event Banner.");
        }
    }
}
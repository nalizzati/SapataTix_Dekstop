@FXML
void onSimpanDanLanjutkan(ActionEvent event) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/sapatatix/FXML/BuatEventTiket.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

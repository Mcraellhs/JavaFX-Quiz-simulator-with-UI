package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ULAZ implements Initializable {

    @FXML
    private Button UradiTest;

    @FXML
    private Button DodajPitanja;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
UradiTest.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent actionEvent) {
        raditst();
    }
});
DodajPitanja.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent actionEvent) {
        ubacipitanja();
    }
});
    }

    public void raditst(){

        UradiTest.getScene().getWindow().hide();
        Stage info = new Stage();
        try{
            Parent root = FXMLLoader.load(getClass().getResource("raditest.fxml"));
            Scene scene = new Scene(root);
            info.setScene(scene);
            info.show();

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }

    public void ubacipitanja(){

        DodajPitanja.getScene().getWindow().hide();
        Stage info = new Stage();
        try{
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            Scene scene = new Scene(root);
            info.setScene(scene);
            info.show();

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }
}

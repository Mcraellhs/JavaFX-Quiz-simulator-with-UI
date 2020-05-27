package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.sql.*;
import java.util.ArrayList;

public class Controller implements Initializable  {

    @FXML
    private TextArea pitanjeID;

    @FXML
    private TextField odgovorID;

    @FXML
    private Button dodajID;

    //




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {



        dodajID.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String pitanje=pitanjeID.getText().toString();
                String odgovor=odgovorID.getText().toString();
                String query ="INSERT INTO pitanja(pitanje, odgovor) VALUES('"+pitanje+"','"+odgovor+"');";
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kviz","root","admin123");
                    Statement statement = connection.createStatement();
                    statement.executeUpdate(query);
                    System.out.println("Pitanje uspjesno dodano u bazu podataka");
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }






            }
        });
    }
}

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
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.sql.*;

public class radiTest implements Initializable {

    @FXML
    private TextArea Question;

    @FXML
    private Button nextQuestion;

    @FXML
    private TextField Answer;

    @FXML
    private TextField tacniODG;
//DB





    ArrayList<String> Quest = new ArrayList<String>();
    ArrayList<String> Ans = new ArrayList<String>();



static int i = 1;
static int todg=1;
static int j=0;
String odg="";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
baz();
bazAns();


        Question.setText(Quest.get(0));
        nextQuestion.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                Question.setText(Quest.get(i));
                odg=Answer.getText().toString().trim();
                String pom= Integer.toString(todg);
                if(odg.equals(Ans.get(j))){
                    tacniODG.setText(pom);
                    todg++;
                }
                j++;
                i++;


            }
        });
    }

    public void baz(){
        String qry="SELECT pitanje FROM pitanja;";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kviz","root","admin123");
            Statement statement = connection.createStatement();
            ResultSet rs    = statement.executeQuery(qry);
            while (rs.next()) {


                Quest.add(rs.getString("pitanje"));
            }


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
    public void bazAns(){
        String qry="SELECT odgovor FROM pitanja;";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kviz","root","admin123");
            Statement statement = connection.createStatement();
            ResultSet rs    = statement.executeQuery(qry);
            while (rs.next()) {


                Ans.add(rs.getString("odgovor"));
            }


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }




}

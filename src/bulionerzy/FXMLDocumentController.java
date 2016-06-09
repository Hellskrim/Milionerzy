/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bulionerzy;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 *
 * @author Hellskrim
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private void handleButtonAcction(ActionEvent event) throws Exception {      //OTWARCIE OKNA Z BAZĄ PYTAŃ
            System.out.println("You clicked me!");
            Parent BazaPytan = FXMLLoader.load(getClass().getResource("FXMLBazaPytan.fxml"));
            Scene sceneBaza = new Scene(BazaPytan);
            Stage app_Baza = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_Baza.setScene(sceneBaza);
            app_Baza.show();  
    }
    @FXML
    private void Graj(ActionEvent event) throws Exception{
        Parent Menu = FXMLLoader.load(getClass().getResource("FXMLLogin.fxml"));//OTWARCIE OKNA Z WEJŚCIEM DO GRY
        Scene sceneLogin = new Scene(Menu);
        Stage app_Login = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_Login.setScene(sceneLogin);
        app_Login.show();
    }  
    @FXML
    private void Wyjdz(ActionEvent event) throws Exception{                     //WYJŚCIE Z GRY
        Parent Menu = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene sceneLogin = new Scene(Menu);
        Stage app_Login = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_Login.setScene(sceneLogin);
        app_Login.close();
    }
    @FXML
    private void oAutorze(ActionEvent event) throws Exception{                  //OKNO O AUTORZE 
        Parent Autor = FXMLLoader.load(getClass().getResource("FXMLAutor.fxml"));
        Scene sceneLogin = new Scene(Autor);
        Stage app_Autor = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_Autor.setScene(sceneLogin);
        app_Autor.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        BazaD baza = new BazaD();
        baza.Program();
    }    
    
    
}

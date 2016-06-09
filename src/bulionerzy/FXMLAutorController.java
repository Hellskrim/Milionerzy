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
 * FXML Controller class
 *
 * @author Hellskrim
 */
public class FXMLAutorController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private void Menu(ActionEvent event) throws Exception{                      // POWRÓT DO MENU GŁÓWNEGO
        Parent Meni = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene sceneLogin = new Scene(Meni);
        Stage app_Meni = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_Meni.setScene(sceneLogin);
        app_Meni.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

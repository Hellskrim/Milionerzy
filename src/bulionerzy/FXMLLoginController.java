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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hellskrim
 */
public class FXMLLoginController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField poleText;
    @FXML
    private Label label;
    
    @FXML
    public void Start(ActionEvent event) throws Exception{
        if(poleText.getText().equals("")){
            label.setText("Wprowadzono zły nick!");
        }
        else{
            Parent Gra = FXMLLoader.load(getClass().getResource("FXMLGra.fxml"));
            Scene sceneBaza = new Scene(Gra);
            Stage app_Gra = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_Gra.setScene(sceneBaza);
            app_Gra.show();
            
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}



   
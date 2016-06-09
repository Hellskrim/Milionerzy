/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bulionerzy;


import java.net.URL;
import java.sql.DriverManager;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Callback;
/**
 * FXML Controller class
 *
 * @author Hellskrim
 */
public class FXMLBazaPytanController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    private ObservableList<ObservableList> data;
    @FXML
    private TableView tableView;
    @FXML
    private TextField tf_tresc;
    @FXML
    private TextField tf_id;
    @FXML
    private TextField tf_oa;
    @FXML
    private TextField tf_ob;
    @FXML
    private TextField tf_oc;
    @FXML
    private TextField tf_od;
    @FXML
    private TextField tf_pop;
    @FXML
    private void powrot(ActionEvent event) throws Exception{                    //POWRÓT DO MENU
        if(event.getSource() instanceof Button){
            Parent Menu = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene sceneBaza = new Scene(Menu);
            Stage app_Menu = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_Menu.setScene(sceneBaza);
            app_Menu.show();
        }
    }
    @FXML
    private void Dodaj(ActionEvent event){                                      //ZMIANA PYTANIA
        Connection connect = null;
        PreparedStatement stat = null;
        try{
            Class.forName("org.sqlite.JDBC");
            connect = DriverManager.getConnection("jdbc:sqlite:Pytania.db");           
            String zmienSQL = "update Pytania set ID=?, TRESC=?, ODP1=?, ODP2=?, ODP3=?, ODP4=?, POPRAWNA=? WHERE ID='"+tf_id.getText()+"';";
            stat = connect.prepareStatement(zmienSQL);
            stat.setString(1, tf_id.getText());
            stat.setString(2, tf_tresc.getText());
            stat.setString(3, tf_oa.getText());
            stat.setString(4, tf_ob.getText());
            stat.setString(5, tf_oc.getText());
            stat.setString(6, tf_od.getText());
            stat.setString(7, tf_pop.getText());
            if(Integer.parseInt(tf_id.getText())>30 || Integer.parseInt(tf_id.getText())<0 || tf_id.getText().isEmpty() || tf_tresc.getText().isEmpty()
               || tf_oa.getText().isEmpty() || tf_ob.getText().isEmpty() || tf_oc.getText().isEmpty() || tf_od.getText().isEmpty() || tf_pop.getText().isEmpty()
               || tf_id.getText().isEmpty())
                tf_tresc.setText("wprowadzono błędne dane");
            else
                if(tf_oa.getText().equals(tf_pop.getText()) || tf_ob.getText().equals(tf_pop.getText()) || tf_oc.getText().equals(tf_pop.getText()) || tf_od.getText().equals(tf_pop.getText()))
                    stat.execute();
            stat.close();
            connect.close();
            
        }
        catch(Exception e){
            System.err.println("Nie mogę zmienić danych " + e.getMessage());
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb){                         //WYŚWIETLENIE TABELI
        // TODO
        Connection connect = null;
        Statement stat = null;
        data = FXCollections.observableArrayList();
        try{
            Class.forName("org.sqlite.JDBC");
            connect = DriverManager.getConnection("jdbc:sqlite:Pytania.db");
            String SQLwys = "select * from Pytania";
            stat = connect.createStatement();
            ResultSet rs = stat.executeQuery(SQLwys);
            
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                //tworzenie tablicy dynamicznej
                final int j = i;                
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });

                tableView.getColumns().addAll(col); 
                System.out.println("kolumna ["+i+"] ");
            }
            while(rs.next()){
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    row.add(rs.getString(i));
                }
                System.out.println("Wiersz dodany: "+row );
                data.add(row);
            }
            tableView.setItems(null);
            tableView.setItems(data);
        }
        catch(Exception e){
              e.printStackTrace();
              System.out.println("Błąd przy budowie bazy");             
        }
    }
}
    
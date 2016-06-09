/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bulionerzy;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

/**
 * @author Hellskrim
 */
public class FXMLGraController implements Initializable {

    @FXML
    private Button odp1;
    @FXML
    private Button odp2;
    @FXML
    private Button odp3;
    @FXML
    private Button odp4;
    @FXML
    private Label tresc;
    @FXML
    private Button Koniec;
    @FXML
    private Ellipse wygrana;
    @FXML
    private Button polNapol;
    @FXML
    private Button telefon;
    @FXML
    private Button publicznosc;
    @FXML
    private Line linia1;
    @FXML
    private Line linia2;
    @FXML
    private Line linia3;
    @FXML
    private AnchorPane kolo_tel;
    @FXML
    private Button wroc1;
    @FXML
    private AnchorPane kolo_pub;
    @FXML
    private Button wroc2;
    @FXML
    private TextField przyjaciel;
    
    int idPytanie = 0;
    static double labelLevel = 0;
    static int licznik = 0;
    static int pytaniaPom[] = new int[16];
    static int ileWylosowano = 1;
    boolean wylosowane = true;
    static boolean czy_polNapol = true;
    static boolean czy_telefon = true;
    static boolean czy_publicznosc = true;
    final static String odpa = "";
    final static String odpb = "";
    final static String odpc = "";
    final static String odpd = "";
    final CategoryAxis liniaX = new CategoryAxis();
    final NumberAxis liniaY = new NumberAxis();
    
    @FXML
    private BarChart<String, Number> bc = new BarChart<String, Number>(liniaX, liniaY); 
     
    @FXML
    private void Koniec(ActionEvent event){                                     //ZAKOŃCZENIE GRY
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Wygrana!");
        alert.setHeaderText("Gratuluję, właśnie stałeś/aś się bogatszy o 1Mln zł!");
        alert.showAndWait().ifPresent(rs ->{
        if (rs == ButtonType.OK){
            Parent Menu;
            try {
                licznik = 0;
                labelLevel = 0;
                ileWylosowano = 1;
                czy_polNapol = true;
                czy_publicznosc = true;
                czy_telefon = true;
                Menu = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Scene sceneBaza = new Scene(Menu);
                Stage app_Menu = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_Menu.setScene(sceneBaza);
                app_Menu.show();
            } 
            catch (IOException ex) {
                System.out.print("To błąd: "+ex.getMessage());
            }
        }
        });
    }
    
    @FXML
    private void Wroc(ActionEvent event){                                       //REZYGNACJA Z GRY
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Rezygnacja");
        alert.setHeaderText("Czy chcesz zapisać stan gry?");
        alert.showAndWait().ifPresent(rs ->{
            if (rs == ButtonType.OK){
                Parent Menu;
                try {
                    Menu = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                    Scene sceneBaza = new Scene(Menu);
                    Stage app_Menu = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    app_Menu.setScene(sceneBaza);
                    app_Menu.show();
                } catch (IOException ex) {
                    Logger.getLogger(FXMLGraController.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
            if(rs == ButtonType.CANCEL) {
                Parent Menu;
                licznik = 0;
                labelLevel = 0;
                ileWylosowano = 1;
                czy_polNapol = true;
                czy_publicznosc = true;
                czy_telefon = true;
                try {
                    Menu = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                    Scene sceneBaza = new Scene(Menu);
                    Stage app_Menu = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    app_Menu.setScene(sceneBaza);
                    app_Menu.show();
                } catch (IOException ex) {
                    Logger.getLogger(FXMLGraController.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
        });
    }
    
    @FXML
    private void OdpowiedzA(ActionEvent event) throws Exception{                //USTAWIENIE PRZYCISKU ODPOWIEDZI A
        Connection connect = null;
        Statement stat = null;
        try{
            Class.forName("org.sqlite.JDBC");
            connect = DriverManager.getConnection("jdbc:sqlite:Pytania.db");
            String SQLpoprawna = "select * from Pytania where ID == '"+idPytanie+"';";
            stat = connect.createStatement();
            
            ResultSet rs = stat.executeQuery(SQLpoprawna);
            if(odp1.getText().equals(rs.getString("POPRAWNA")))
            {
                labelLevel+=20.5;
                System.out.print("udało się!\n");
                
                Parent Menu = FXMLLoader.load(getClass().getResource("FXMLGra.fxml"));
                Scene sceneBaza = new Scene(Menu);
                Stage app_Menu = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_Menu.setScene(sceneBaza);
                app_Menu.show();
                
            }
            else{
                System.out.print("nie udało się!\n");
                licznik = 0;
                labelLevel = 0;
                ileWylosowano = 1;
                czy_polNapol = true;
                czy_publicznosc = true;
                czy_telefon = true;
                Parent Menu = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Scene sceneBaza = new Scene(Menu);
                Stage app_Menu = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_Menu.setScene(sceneBaza);
                app_Menu.show();
            }
            rs.close();
            stat.close();
            connect.close();
        }
        catch(Exception e){
            if(licznik==15)
                 Koniec.setVisible(true);
            System.out.print(licznik);
            System.out.print("Przycisk A: "+e.getMessage());
        }
    }
    @FXML
    private void OdpowiedzB(ActionEvent event) throws Exception{                //USTAWIENIE PRZYCISKU ODPOWIEDZI B
        Connection connect = null;
        Statement stat = null;
        try{
            Class.forName("org.sqlite.JDBC");
            connect = DriverManager.getConnection("jdbc:sqlite:Pytania.db");
            String SQLpoprawna = "select * from Pytania where ID == '"+idPytanie+"';";
            stat = connect.createStatement();
            ResultSet rs = stat.executeQuery(SQLpoprawna);
            if(odp2.getText().equals(rs.getString("POPRAWNA")))
            {
                labelLevel+=20.5;
                System.out.print("udało się!\n");
                
                Parent Menu = FXMLLoader.load(getClass().getResource("FXMLGra.fxml"));
                Scene sceneBaza = new Scene(Menu);
                Stage app_Menu = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_Menu.setScene(sceneBaza);
                app_Menu.show();
            }
            else{
                System.out.print("nie udało się!\n");
                licznik = 0;
                labelLevel = 0;
                ileWylosowano = 1;
                czy_polNapol = true;
                czy_publicznosc = true;
                czy_telefon = true;
                Parent Menu = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Scene sceneBaza = new Scene(Menu);
                Stage app_Menu = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_Menu.setScene(sceneBaza);
                app_Menu.show();
            }
            rs.close();
            stat.close();
            connect.close();
        }
        catch(Exception e){
            if(licznik==15)
                 Koniec.setVisible(true);
            System.out.print(licznik);
            System.out.print("Przycisk B: "+e.getMessage());
        }
    }
    @FXML
    private void OdpowiedzC(ActionEvent event) throws Exception{                //USTAWIENIE PRZYCISKU ODPOWIEDZI C
        Connection connect = null;
        Statement stat = null;
        try{
            Class.forName("org.sqlite.JDBC");
            connect = DriverManager.getConnection("jdbc:sqlite:Pytania.db");
            String SQLpoprawna = "select * from Pytania where ID == '"+idPytanie+"';";
            stat = connect.createStatement();
            ResultSet rs = stat.executeQuery(SQLpoprawna);
            if(odp3.getText().equals(rs.getString("POPRAWNA")))
            {
                labelLevel+=20.5;
                System.out.print("udało się!\n");
                
                Parent Menu = FXMLLoader.load(getClass().getResource("FXMLGra.fxml"));
                Scene sceneBaza = new Scene(Menu);
                Stage app_Menu = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_Menu.setScene(sceneBaza);
                app_Menu.show();
            }
            else{
                System.out.print("nie udało się!\n");
                licznik = 0;
                labelLevel = 0;
                ileWylosowano = 1;
                czy_polNapol = true;
                czy_publicznosc = true;
                czy_telefon = true;
                Parent Menu = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Scene sceneBaza = new Scene(Menu);
                Stage app_Menu = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_Menu.setScene(sceneBaza);
                app_Menu.show();
            }
            rs.close();
            stat.close();
            connect.close();
        }
        catch(Exception e){
            if(licznik==15)
                 Koniec.setVisible(true);
            System.out.print(licznik);
            System.out.print("Przycisk C: "+e.getMessage());
        }
    }
    @FXML
    private void OdpowiedzD(ActionEvent event) throws Exception{                //USTAWIENIE PRZYCISKU ODPOWIEDZI D
        Connection connect = null;
        Statement stat = null;     
        try{
            Class.forName("org.sqlite.JDBC");
            connect = DriverManager.getConnection("jdbc:sqlite:Pytania.db");
            String SQLpoprawna = "select * from Pytania where ID == '"+idPytanie+"';";
            stat = connect.createStatement();
            ResultSet rs = stat.executeQuery(SQLpoprawna);
            if(odp4.getText().equals(rs.getString("POPRAWNA")))
            {
                labelLevel+=20.5;
                System.out.print("udało się!\n");
                
                Parent Menu = FXMLLoader.load(getClass().getResource("FXMLGra.fxml"));
                Scene sceneBaza = new Scene(Menu);
                Stage app_Menu = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_Menu.setScene(sceneBaza);
                app_Menu.show();
            }
            else{
                System.out.print("nie udało się!\n");
                licznik = 0;
                labelLevel = 0;
                ileWylosowano = 1;
                czy_polNapol = true;
                czy_publicznosc = true;
                czy_telefon = true;
                Parent Menu = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Scene sceneBaza = new Scene(Menu);
                Stage app_Menu = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_Menu.setScene(sceneBaza);
                app_Menu.show();
            }
            rs.close();
            stat.close();
            connect.close();
        }
        catch(Exception e){
            if(licznik==15)
                 Koniec.setVisible(true);
            System.out.print(licznik);
            System.out.print("Przycisk D: "+e.getMessage());
        }
        
    }

    private void Losowanie(){                                                   //LOSOWANIE PYTANIA
        Random rand = new Random();
        do{
            if(licznik<5) idPytanie = rand.nextInt(10)+1;
            if(licznik>4 && licznik<10) idPytanie = rand.nextInt(10)+11;
            if(licznik>9 && licznik<16) idPytanie = rand.nextInt(10)+21;
            
            wylosowane=true;
            for(int j=1;j<=ileWylosowano;j++){ 
                if(pytaniaPom[j]==idPytanie) 
                    wylosowane = false;
                }
            if(wylosowane){
                pytaniaPom[ileWylosowano]=idPytanie;
                for(int i = 0;i<ileWylosowano;i++)
                    System.out.print(pytaniaPom[ileWylosowano]+" ");
                ileWylosowano++;
            }
        }while(!wylosowane);
        if(wylosowane)
        Pytanko();
    }
    
    private void Pytanko(){                                                     //WYSWIETLENIE PYTANIA I ODPOWIEDZI
        Connection connect = null;
        Statement stat = null;

        try{
            Class.forName("org.sqlite.JDBC");
            connect = DriverManager.getConnection("jdbc:sqlite:Pytania.db");
            String SQLpyt = "select * from Pytania where ID == '"+idPytanie+"';";
            stat = connect.createStatement();
            ResultSet rs = stat.executeQuery(SQLpyt);
            odp1.setText(rs.getString("ODP1"));
            odp2.setText(rs.getString("ODP2"));
            odp3.setText(rs.getString("ODP3"));
            odp4.setText(rs.getString("ODP4"));
            tresc.setText(rs.getString("TRESC"));
            rs.close();
            stat.close();
            connect.close();
            wygrana.setTranslateY(-labelLevel);

        }
        catch(Exception e){
              System.out.println("coś nie tak" + e.getMessage());             
        }
    }
    
    @FXML
    private void chowajKolo1(){                                                 //KOŁO RATUNKOWE 50:50
        if(!czy_polNapol){
            polNapol.setVisible(false);
            linia1.setVisible(true);
        }
        if(czy_polNapol){
            czy_polNapol = false;
                Connection connect = null;
                Statement stat = null;
                polNapol.setVisible(false);
                linia1.setVisible(true);
                try{
                    Class.forName("org.sqlite.JDBC");
                    connect = DriverManager.getConnection("jdbc:sqlite:Pytania.db");
                    String SQLpoprawna = "select * from Pytania where ID == '"+idPytanie+"';";
                    stat = connect.createStatement();
                    ResultSet rs = stat.executeQuery(SQLpoprawna);
                    if(!odp1.getText().equals(rs.getString("POPRAWNA")) && !odp2.getText().equals(rs.getString("POPRAWNA")) && 
                       !odp3.getText().equals(rs.getString("POPRAWNA")) && odp4.getText().equals(rs.getString("POPRAWNA"))){
                            odp1.setText("");
                            odp2.setText("");
                    }
                    else if(!odp4.getText().equals(rs.getString("POPRAWNA")) && !odp2.getText().equals(rs.getString("POPRAWNA")) && 
                       !odp3.getText().equals(rs.getString("POPRAWNA")) && odp1.getText().equals(rs.getString("POPRAWNA"))){
                            odp2.setText("");
                            odp3.setText("");
                    }
                    else if(!odp4.getText().equals(rs.getString("POPRAWNA")) && !odp1.getText().equals(rs.getString("POPRAWNA")) && 
                       !odp3.getText().equals(rs.getString("POPRAWNA")) && odp2.getText().equals(rs.getString("POPRAWNA"))){
                            odp4.setText("");
                            odp3.setText("");
                    }
                    else if(!odp4.getText().equals(rs.getString("POPRAWNA")) && !odp2.getText().equals(rs.getString("POPRAWNA")) && 
                       !odp1.getText().equals(rs.getString("POPRAWNA")) && odp3.getText().equals(rs.getString("POPRAWNA"))){
                            odp4.setText("");
                            odp1.setText("");
                    }
                }
                catch(Exception e){
                    
                }
            }
    }
    @FXML
    private void chowajKolo2(){                                                 //KOŁO RATUNKOWE TELEFON DO PRZYJACIELA
        if(!czy_telefon){
            telefon.setVisible(false);
            linia2.setVisible(true);
            kolo_tel.setVisible(false);
        }
        if(czy_telefon){
            czy_telefon = false;
                telefon.setVisible(false);
                linia2.setVisible(true);
                kolo_tel.setVisible(true);
                Connection connect = null;
                Statement stat = null;
                try{
                    Class.forName("org.sqlite.JDBC");
                    connect = DriverManager.getConnection("jdbc:sqlite:Pytania.db");
                    String SQLpoprawna = "select * from Pytania where ID == '"+idPytanie+"';";
                    stat = connect.createStatement();
                    ResultSet rs = stat.executeQuery(SQLpoprawna);
                
                    int szansa;
                    double szansaA = 0;
                    double szansaB = 0;
                    double szansaC = 0;
                    double szansaD = 0;
                    Random rand = new Random();
                    for(int i = 0; i<100; i++){
                        szansa = rand.nextInt(4)+1;
                        if(szansa==1 && odp1.getText().equals(rs.getString("POPRAWNA"))) szansaA+=1.75;
                        else if(szansa==1 && !odp1.getText().equals(rs.getString("POPRAWNA"))) szansaA++;
                    
                        else if(szansa==2 && odp2.getText().equals(rs.getString("POPRAWNA"))) szansaB+=1.75;
                        else if(szansa==2 && !odp2.getText().equals(rs.getString("POPRAWNA"))) szansaB++;
                    
                        else if(szansa==3 && odp3.getText().equals(rs.getString("POPRAWNA"))) szansaC+=1.75;
                        else if(szansa==3 && !odp3.getText().equals(rs.getString("POPRAWNA"))) szansaC++;
                    
                        else if(szansa==4 && odp4.getText().equals(rs.getString("POPRAWNA"))) szansaD+=1.75;
                        else if(szansa==4 && !odp4.getText().equals(rs.getString("POPRAWNA"))) szansaD++;
                    }
                    if(szansaA>szansaB && szansaA>szansaC && szansaA>szansaD)
                        przyjaciel.setText("Myślę, żę poprawna odpowiedź to: A");
                    if(szansaB>szansaA && szansaB>szansaC && szansaB>szansaD)
                        przyjaciel.setText("Myślę, żę poprawna odpowiedź to: B");
                    if(szansaC>szansaB && szansaC>szansaA && szansaC>szansaD)
                        przyjaciel.setText("Myślę, żę poprawna odpowiedź to: C");
                    if(szansaD>szansaB && szansaD>szansaC && szansaD>szansaA)
                        przyjaciel.setText("Myślę, żę poprawna odpowiedź to: D");
                    if(wroc1.isPressed())
                        kolo_tel.setVisible(false);
                }
                catch(Exception e){
                    System.out.print("HM "+e.getMessage());
                }
            }
    }
    @FXML
    private void chowajKolo3(){                                                 //KOŁO RATUNKOWE PUBLICZNOŚĆ
        if(!czy_publicznosc){
            publicznosc.setVisible(false);
            linia3.setVisible(true);
            kolo_pub.setVisible(false);
        }
        if(czy_publicznosc){
            czy_publicznosc = false;
                publicznosc.setVisible(false);
                linia3.setVisible(true);
                kolo_pub.setVisible(true);
                Connection connect = null;
                Statement stat = null;
                try{
                    Class.forName("org.sqlite.JDBC");
                    connect = DriverManager.getConnection("jdbc:sqlite:Pytania.db");
                    String SQLpoprawna = "select * from Pytania where ID == '"+idPytanie+"';";
                    stat = connect.createStatement();
                    ResultSet rs = stat.executeQuery(SQLpoprawna);
                
                    int szansa;
                    double szansaA = 0;
                    double szansaB = 0;
                    double szansaC = 0;
                    double szansaD = 0;
                    Random rand = new Random();
                    for(int i = 0; i<100; i++){
                        szansa = rand.nextInt(4)+1;
                        if(szansa==1 && odp1.getText().equals(rs.getString("POPRAWNA"))) szansaA+=1.25;
                        else if(szansa==1 && !odp1.getText().equals(rs.getString("POPRAWNA"))) szansaA++;
                    
                        else if(szansa==2 && odp2.getText().equals(rs.getString("POPRAWNA"))) szansaB+=1.25;
                        else if(szansa==2 && !odp2.getText().equals(rs.getString("POPRAWNA"))) szansaB++;
                    
                        else if(szansa==3 && odp3.getText().equals(rs.getString("POPRAWNA"))) szansaC+=1.25;
                        else if(szansa==3 && !odp3.getText().equals(rs.getString("POPRAWNA"))) szansaC++;
                    
                        else if(szansa==4 && odp4.getText().equals(rs.getString("POPRAWNA"))) szansaD+=1.25;
                        else if(szansa==4 && !odp4.getText().equals(rs.getString("POPRAWNA"))) szansaD++;
                    }
                    XYChart.Series series1 = new XYChart.Series();
                    series1.setName("Odpowiedź A");       
                    series1.getData().add(new XYChart.Data(odpa, szansaA));
        
                    XYChart.Series series2 = new XYChart.Series();
                    series2.setName("Odpowiedź B");
                    series2.getData().add(new XYChart.Data(odpb, szansaB));
        
                    XYChart.Series series3 = new XYChart.Series();
                    series3.getData().add(new XYChart.Data(odpc, szansaC));
                    series3.setName("Odpowiedź C");
        
                    XYChart.Series series4 = new XYChart.Series();
                    series4.getData().add(new XYChart.Data(odpd, szansaD));
                    series4.setName("Odpowiedź D");
                    bc.getData().addAll(series1,series2,series3,series4);
                
                    if(wroc2.isPressed())
                        kolo_pub.setVisible(false);
                }
                catch(Exception e){
                    System.out.print("HM "+e.getMessage());
                }
            }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Losowanie();
        licznik++;        
        System.out.print(licznik);
        
    }    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bulionerzy;
import java.sql.*;


 /*
 * @author Hellskrim
 */

public class BazaD{
    
    public void Program()                                                       //TWORZENIE PYTAŃ DO BAZY DANYCH
    {
        String BazaPytan = "Pytania";
        Connection connect = polacz(BazaPytan);
        stworzTablice(connect, BazaPytan);
        Pytania pytanie = new Pytania(1,"Jaka część mowy odpowiada na pytania: kto, co?", "Czasownik", "Przymiotnik","Rzeczownik", "Zaimek", "Rzeczownik", 1);
        dodajDane(pytanie, BazaPytan);
        pytanie = new Pytania(2,"Jaka legenda jest związana z Warszawą?", "O smoku wawelskim", "O Syrence","O Popielu", "Żabie", "O Syrence", 1);
        dodajDane(pytanie, BazaPytan);
        pytanie = new Pytania(3,"Ile wynosi 23+2?", "3", "4","5", "25", "25", 1);
        dodajDane(pytanie, BazaPytan);
        pytanie = new Pytania(4,"Co powstanie z wody, gdy ją zamrozimy?", "Nic się nie stanie", "Lód","Para", "Ciecz", "Lód", 1);
        dodajDane(pytanie, BazaPytan);
        pytanie = new Pytania(5,"Ile wynosi 116-16?", "64", "84","100", "106", "100", 1);
        dodajDane(pytanie, BazaPytan);
        pytanie = new Pytania(6,"Ile wynosi 16-6?", "10", "84","0", "106", "10", 1);
        dodajDane(pytanie, BazaPytan);
        pytanie = new Pytania(7,"Ile wynosi 16-10?", "64", "84","0", "6", "6", 1);
        dodajDane(pytanie, BazaPytan);
        pytanie = new Pytania(8,"Ile wynosi liczba pi w przybliżeniu?", "3.14", "4","co to jest?", "6", "3.14", 1);
        dodajDane(pytanie, BazaPytan);
        pytanie = new Pytania(9,"Ile jest cyfr nieparzystych?", "5", "3","7", "0", "5", 1);
        dodajDane(pytanie, BazaPytan);
        pytanie = new Pytania(10,"Ile wynosi 160-16?", "64", "84","144", "106", "144", 1);
        dodajDane(pytanie, BazaPytan);
        pytanie = new Pytania(11,"Ile metrów n.p.m ma Mount Everest?", "8892", "9882","7982", "10000", "8892", 2);
        dodajDane(pytanie, BazaPytan);
        pytanie = new Pytania(12,"Kiedy Polska przyjęła chrzest?", "966", "996","800", "1918", "966", 2);
        dodajDane(pytanie, BazaPytan);
        pytanie = new Pytania(13,"Najmocniejsza umiejętność Kealtasa w Heroes of the Storm to...", "Pirowybuch", "Płomienie","Zakrzywienie", "Tornado", "Pirowybuch", 2);
        dodajDane(pytanie, BazaPytan);
        pytanie = new Pytania(14,"Kto był pierwszym królem Polski?", "Mieszko I", "Józef Piłsudzki","Lama", "Bolesław Chrobry", "Bolesław Chrobry", 2);
        dodajDane(pytanie, BazaPytan);
        pytanie = new Pytania(15,"Gdzie mieszkasz?", "Tam", "Londyn","Most", "Warszaffa", "Tam", 2);
        dodajDane(pytanie, BazaPytan);
        pytanie = new Pytania(16,"Największe jezioro w Polsce to...", "Śniardwy", "Hańcza","Dunajec", "Sosina", "Śniardwy", 2);
        dodajDane(pytanie, BazaPytan);
        pytanie = new Pytania(17,"Kto zniszczył pierścień na Górze Przeznaczenia?", "Golum", "Frodo","Sam", "Aragorn", "Frodo", 2);
        dodajDane(pytanie, BazaPytan);
        pytanie = new Pytania(18,"Co lubi Kubuś Puchatek?", "Mięso", "Coca-Colę","Miód", "Sałatę", "Miód", 2);
        dodajDane(pytanie, BazaPytan);
        pytanie = new Pytania(19,"Najdłuższa rzeka w Polsce to...", "Dunajec", "Kozibród","Odra", "Wisła", "Wisła", 2);
        dodajDane(pytanie, BazaPytan);
        pytanie = new Pytania(20,"Czy jesteś gotów grać dalej?", "Nie wiem", "Tak","Nie", "Co?", "Tak", 2);
        dodajDane(pytanie, BazaPytan);
        pytanie = new Pytania(21,"Która z tych małp jest największa?", "Orangutan", "Kapucynka","Goryl", "Szympans", "Goryl", 3);
        dodajDane(pytanie, BazaPytan);
        pytanie = new Pytania(22,"Jakie są najwyższe góry na świecie?", "Tatry", "Himalaje","Alpy", "Andy", "Himalaje", 3);
        dodajDane(pytanie, BazaPytan);
        pytanie = new Pytania(23,"Ciut to nie..", "W bród", "Zdziebko","Ociupina", "Krztyna", "W bród", 3);
        dodajDane(pytanie, BazaPytan);
        pytanie = new Pytania(24,"Z komponowania jakiej muzyki słynął Jan Sebastian Bach?", "Rap", "Rock","Klasyczna", "Pop", "Klasyczna", 3);
        dodajDane(pytanie, BazaPytan);
        pytanie = new Pytania(25,"Która planeta Układu Słonecznego słynie z dłuższego dnia niż roku?", "Merkury", "Ziemia","Wenus", "Saturn", "Wenus", 3);
        dodajDane(pytanie, BazaPytan);
        pytanie = new Pytania(26,"Najbliższa znana nam gwiazda poza Układem to...", "Betelgeza", "Canis Majoris","Słońce", "Alpha Centauri", "Alpha Centauri", 3);
        dodajDane(pytanie, BazaPytan);
        pytanie = new Pytania(27,"Jak przystało nam nazywać naszą galaktykę?", "Andromeda", "Droga Mleczna","Snikers", "NC1001", "Droga Mleczna", 3);
        dodajDane(pytanie, BazaPytan);
        pytanie = new Pytania(28,"Grupę sąsiadujących ze sobą galaktyk nazywamy...", "Bąblem Lokalnym", "Układem Lokalnym","Mgławicą Lokalną", "Poduszką", "Bąblem Lokalnym", 3);
        dodajDane(pytanie, BazaPytan);
        pytanie = new Pytania(29,"Do jakiej grupy zaliczamy Jowisz", "Superziemia", "Gazowy gigant","Czerwony karzeł", "Nadolbrzym", "Gazowy gigant", 3);
        dodajDane(pytanie, BazaPytan);
        pytanie = new Pytania(30,"Kto odkrył morską drogę do Indii?", "Krzystof Kolumb", "Ferdynand Magellan","Nikolas Tesla", "Vasco da Gamma", "Vasco da Gamma", 3);
        dodajDane(pytanie, BazaPytan);
        
    }
    public static final String DRIVER = "org.sqlite.JDBC";
    
    
    public static Connection polacz(String baza)                                //ŁĄCZENIE Z BAZĄ
    {
        Connection connect = null;
        try{
            Class.forName(DRIVER);
            connect = DriverManager.getConnection("jdbc:sqlite:"+baza+".db");
            System.out.println("Połączone z baza: "+baza);            
        }
        catch(Exception e){
            System.err.println("Błąd w połączniu z bazą"+e.getMessage());
            return null;
        }
        return connect;//polaczenie;
    }

    public static void stworzTablice(Connection connect, String tablica){       //TWORZENIE TABELI POD DANE
        Statement stat = null;
        try{
            stat = connect.createStatement();
            String tablicaSQL = "CREATE TABLE " + tablica
                    + " (ID INT PRIMARY KEY      NOT NULL, "
                    + " TRESC          TEXT         NOT NULL, "
                    + " ODP1           CHAR(50)     NOT NULL, "
                    + " ODP2           CHAR(50)     NOT NULL, "
                    + " ODP3           CHAR(50)     NOT NULL, "
                    + " ODP4           CHAR(50)     NOT NULL, "
                    + " POPRAWNA           CHAR(50)     NOT NULL, "
                    + " POZIOM          INT)";
        
            stat.executeUpdate(tablicaSQL);
            System.out.println("Stworzno tabele: " + tablica);
            stat.close();
            connect.close();

        }
        catch(SQLException e){
            System.out.println("Nie moge stworzyc tablicy: " + e.getMessage());
        }
    }
    
    public static void dodajDane(Pytania pytania, String baza){                 //DODAWANIE DANYCH
        Connection connect = null;
        Statement stat = null;
        try{
            Class.forName(DRIVER);
            connect = DriverManager.getConnection("jdbc:sqlite:"+baza+".db");
            stat = connect.createStatement();
            String dodajSQL = "INSERT INTO " + baza + " (ID, TRESC, ODP1, ODP2, ODP3, ODP4, POPRAWNA, POZIOM) "
                    + "VALUES ("
                    + pytania.getID() + ","
                    + "'" + pytania.getTresc() + "',"
                    + "'" + pytania.getOdp1() + "',"
                    + "'" + pytania.getOdp2() + "',"
                    + "'" + pytania.getOdp3() + "',"
                    + "'" + pytania.getOdp4() + "',"
                    + "'" + pytania.getPoprawna()+ "',"
                    + pytania.getPoziom()
                    + "  );";
            stat.executeUpdate(dodajSQL);
            stat.close();
            connect.close();
            System.out.println("Dodano wartosc: \n"+dodajSQL+"\nWykonane!");
        }
        catch(Exception e){
            System.err.println("Nie mogę dodać danych " + e.getMessage());
        }
    }
      
    public static void usun(String baza, String pole, String wartosc){          //USUWANIE DANYCH
        Connection connect = null;
        Statement stat = null;
        try{
            Class.forName(DRIVER);
            connect = DriverManager.getConnection("jdbc:sqlite:" + baza + ".db");
            stat = connect.createStatement();
            
            String usunSQL = "DELETE FROM " + baza + " WHERE " + pole + " ='" + wartosc + "';";
            System.out.println("Usunieto!: " + usunSQL);
            ResultSet wynik = stat.executeQuery(usunSQL);
            
            wynik.close();
            stat.close();
            connect.close();
        }
        catch(Exception e){
            System.err.println("Nie mozna usunac: " + e.getMessage());
        }
    }
    
   
}
    


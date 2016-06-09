/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bulionerzy;
/**
 *
 * @author Hellskrim
 */
public class Pytania {
    private int ID;
    private String Tresc;
    private String Odp1;
    private String Odp2;
    private String Odp3;
    private String Odp4;
    private String Poprawna;
    private int Poziom;
    
    public Pytania(int id, String tresc, String odp1, String odp2, String odp3, String odp4, String poprawna, int poziom)
    {
        this.ID = id;
        this.Tresc = tresc;
        this.Odp1 = odp1;
        this.Odp2 = odp2;
        this.Odp3 = odp3;
        this.Odp4 = odp4;
        this.Poprawna = poprawna;
        this.Poziom = poziom;
    }
    
    public int getID(){
        return ID;
    }
    public void setID(int ID){
        this.ID = ID;
    }
    
    public String getTresc(){
        return Tresc;
    }
    public void setTresc(String Tresc){
        this.Tresc = Tresc;
    }
    public String getOdp1(){
        return Odp1;
    }
    public void setOdp1(String Odp1){
        this.Odp1 = Odp1;
    }
    
    public String getOdp2(){
        return Odp2;
    }
    public void setOdp2(String Odp2){
        this.Odp2 = Odp2;
    }
    
    public String getOdp3(){
        return Odp3;
    }
    public void setOdp3(String Odp3){
        this.Odp3 = Odp3;
    }
    
    public String getOdp4(){
        return Odp4;
    }
    public void setOdp4(String Odp4){
        this.Odp4 = Odp4;
    }
    
    public String getPoprawna(){
        return Poprawna;
    }
    public void setPoprawna(String Poprawna){
        this.Poprawna = Poprawna;
    }
    
    public int getPoziom(){
        return Poziom;
    }
    public void setPoziom(int Poziom){
        this.Poziom = Poziom;
    }
    
   
}
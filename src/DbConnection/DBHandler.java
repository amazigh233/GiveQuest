/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import login.scherm.session;

/**
 *
 * @author jugraj
 */
public class DBHandler {
    
    public String email;
    public String password;
    
    // <editor-fold defaultstate="collapsed" desc="SQL Connectie Functies">  
    //Creeert connectie
    public static Connection setConnection(){
        Connection con = null;
        
        try{
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db","test","Jugraj123");
        }
        
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return con;
    }

    //Functie voor het executen van een SQL Query
    public static ResultSet executeQuery(String Query) {
        ResultSet myQr = null;
        Connection con = setConnection();
        
        try{
            Statement stm = con.createStatement();
            myQr = stm.executeQuery(Query);
        }
        
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return myQr;
    }
    
    // </editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Functies voor login">
    //Functie waarmee login wordt gecheckt
    public static boolean verifyLogin(String email, char[] password){
        boolean correct = false;
        String correcteWachtwoord = null;
        
        try{
            //Alle informatie van ingevoerde email selecteren
            ResultSet myQr = executeQuery("SELECT * FROM account WHERE email ='" + email + "'");
            
            //Informatie verwerken zodat we bij alle schermen weten wie er ingelogd is
            while (myQr.next()){
                session.account_id = myQr.getInt("id");
                correcteWachtwoord = myQr.getString("password");
                session.email = myQr.getString("email");
            }
            
            //Ingevoerde wachtwoord ophalen
            String invoer = String.valueOf(password);
            
            //Checken of invoer gelijkstaat met wachtwoord in DB
            if(invoer.equals(correcteWachtwoord)){
                correct = true;
            }
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return correct;
        
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Functies voor menu">
    //Functie waarmee de geschiedenis van de gebruiker wordt opgehaald
    public static ArrayList<String> donatieLijstOphalen(){
        ArrayList<String> array = new ArrayList<String>();
        
        ResultSet myQr = executeQuery("SELECT product_id FROM Donatie WHERE id = " + session.account_id);
        try{
            while(myQr.next()){
                ResultSet getNaam = executeQuery("SELECT naam FROM Product WHERE product_id = " + myQr.getString("product_id"));
                while(getNaam.next()){
                    array.add(getNaam.getString("naam"));
                }
            }
            for(int i = 0; i < array.size(); i++){
                //Nr
                login.scherm.menuScherm.donatieTable.getModel().setValueAt(i + 1, i, 0);
                
                //Product
                login.scherm.menuScherm.donatieTable.getModel().setValueAt(array.get(i), i, 1);
                
                }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return array;
    }
    //</editor-fold>
    
    
}

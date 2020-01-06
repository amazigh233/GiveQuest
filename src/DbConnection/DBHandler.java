/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
        }
        
        return con;
    }
    
    public static String[] toArray(String string){
        String[] s = {string};
        return s;
    }
    
    public static ResultSet resultSet(String type, String query, String[] arr){
        Connection con = setConnection();
        ResultSet myQr = null;
        PreparedStatement ps;
        
        try{
            ps = con.prepareStatement(query);
            
            for (int i = 0; i < arr.length; i++) {
                ps.setString(i + 1, arr[i]);
            }

            query = String.valueOf(ps);
            String remove = "com.mysql.cj.jdbc.ClientPreparedStatement: ";
            query = query.substring(remove.length(), query.length());
            System.out.println(query);

            if (type.equalsIgnoreCase("update")) {
                ps.executeUpdate(query);
            } else if (type.equalsIgnoreCase("execute")) {
                System.out.println("EXECUTING QUERY " + query);
                myQr = ps.executeQuery(query);
            } else {
                System.out.println("Invalid query type");
                System.exit(0);
            }
            
        }
        catch(SQLException e){
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
            ResultSet myQr = resultSet("execute", "SELECT * FROM account WHERE email LIKE ?", toArray(email));
            
            //Informatie verwerken zodat we bij alle schermen weten wie er ingelogd is
            while (myQr.next()){
                correcteWachtwoord = myQr.getString("password");
                session.account_id = myQr.getInt("id");
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
    
    
    public static String[] search(String naam){
        ArrayList<String> tempArr = new ArrayList<>();
        naam = "%" + naam + "%";
        ResultSet myQr = resultSet("execute", "SELECT naam FROM Product WHERE naam LIKE ?", toArray(naam)); 
        
        
        try{
            while(myQr.next()){
                tempArr.add(myQr.getString("naam"));
            }
        }
        catch(SQLException e){
            
        }
        
        //ArrayList omzetten in Array
        String[] results = new String[tempArr.size() + 1];
        
        for(int i = 0; i < tempArr.size(); i++){
            results[i] = tempArr.get(i);
        }
        
        return(results);
        
    }
    //</editor-fold>
    
    public static boolean productToevoegen(String[] info){
        boolean newEntry = true;
        int product_id = 0;
        String insert = "insert into Product(merk, naam, soort, gewicht) values (?, ?, ?, ?)";
        
        try{
            ResultSet myQr = resultSet("execute", "SELECT * FROM Product WHERE merk = ? AND naam = ? AND soort = ? AND gewicht = ?", info);
            
            if(myQr.next()){
                newEntry = false;
            }
            else{
                resultSet("update", "INSERT INTO Product(merk, naam, soort, gewicht) VALUES (?, ?, ?, ?)", info);
            
                /* Dit hoort in donatie scherm
                myQr = executeQuery(preparedStm(setConnection(), "select product_id from Product where naam = ?", toArray(info[1])), "select product_id from Product where naam = '" + naamField.getText() + "'");
                while(myQr.next()){
                    product_id = myQr.getInt("product_id");
                    
                } */
                
                //executeUpdate(preparedStm(setConnection(), "insert into Donatie(product_id, id) " + "values (?, ?)", donatie ), "insert into Donatie(product_id, id) " + "values (?, ?)" );
                
                
            }
        }
        catch(SQLException e){
        }
        
        return newEntry;

    }
    
    
}

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
import login.scherm.session;

/**
 *
 * @author jugraj
 */
public class DBHandler {
    
    String url = "\"jdbc:mysql://localhost:3306/test_db\",\"test\",\"Jugraj123\"";
    
    public String email;
    public String password;

    public DBHandler(String url) {
        this.url = url;
    }
    
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
    
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public static boolean getInfo(String email, char[] password){
        boolean correct = false;
        String correcteWachtwoord = null;
        
        try{
            ResultSet myQr = executeQuery("SELECT * FROM account WHERE email ='" + email + "'");
            
            while (myQr.next()){
                session.account_id = myQr.getInt("id");
                correcteWachtwoord = myQr.getString("password");
                session.email = myQr.getString("email");
            }
            
            String i = String.valueOf(password);
            
            if(i.equals(correcteWachtwoord)){
                correct = true;
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return correct;
        
    }
    
    public static String[] donatieLijstOphalen(){
        String[] array = {};
        ArrayList<String> tempArray = new ArrayList<String>();
        AbstractListModel donaties;
        
        ResultSet myQr = executeQuery("SELECT product_id FROM Donatie WHERE id = " + session.account_id);
        try{
            while(myQr.next()){
                ResultSet getNaam = executeQuery("SELECT naam FROM Product WHERE product_id = " + myQr.getString("product_id"));
                while(getNaam.next()){
                    tempArray.add(getNaam.getString("naam"));
                }
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        donaties = new AbstractListModel<String>() {
            String[] strings = { "test", "Item 2", "Item 3", "Item 4", "Item 5" };
            
            @Override
            public int getSize() { return strings.length; }
            
            @Override
            public String getElementAt(int i) { return strings[i]; }
        };
        
        return array;
    }
    
    
}

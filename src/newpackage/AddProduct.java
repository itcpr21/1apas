/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import static conn.connector.conUrl;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */

public class AddProduct {
    
    public void addProduct(String product, int quantity, Object price){ 
        

try {
Class.forName("com.mysql.jdbc.Driver"); 
Connection con = DriverManager.getConnection(conUrl);

PreparedStatement pstmt = con.prepareStatement ("INSERT INTO product (`name`,`quantity`,`price`) "
        + "VALUES (?, ?, ?);");

float nprice = Float.parseFloat(price.toString());

pstmt.setString(1, product);
pstmt.setInt(2, quantity);
pstmt.setFloat(3, nprice);

pstmt.executeUpdate();

JOptionPane.showMessageDialog(null, "Added");


} catch (ClassNotFoundException | SQLException ex) {
Logger.getLogger(AddFrame.class.getName()).log(Level.SEVERE, null, ex);
}
   
    }
    
     public int DeleteProduct(Object product_id){
      int selRow = 0;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(conUrl);
            
            PreparedStatement pstmt = con.prepareStatement("Delete from product where product_id = ?;");
            
            int prod_id = Integer.parseInt(product_id.toString());
            
            pstmt.setInt(1, prod_id);
            
            selRow = pstmt.executeUpdate();
            //System.out.println(pstmt);
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AddProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return selRow;
    }
     
     
     
    
}



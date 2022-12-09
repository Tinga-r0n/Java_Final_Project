
package inventory_casheringsystem;


import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class Connections {
    
  
   java.sql.Connection con = null;
    public static java.sql.Connection getConnection(){
       
        try {
           
            Class.forName("com.mysql.jdbc.Driver");
           
            java.sql.Connection  con = DriverManager.getConnection("jdbc:mysql://localhost/inventorycashiering", "root", "");
            
            return con;
           
            
        }catch(Exception e) {
            
           JOptionPane.showMessageDialog(null, "Not Connected!");
            return null;
        }

    }
}


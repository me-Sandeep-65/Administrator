
package administrator;

import java.sql.DriverManager;
import java.sql.Statement;

public class Connection {
    java.sql.Connection c;
    Statement s;
    public Connection(){  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            c =DriverManager.getConnection("jdbc:mysql:///Administration","root","lelebhai"); 
            
            s =c.createStatement();  
            
           
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }    
}

package Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectionFactory {
    
    public Connection getConnection() throws ClassNotFoundException{
        try{
        	Class.forName("com.mysql.jdbc.Driver");
            
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda","rootart", "root1234");
        
        }catch (SQLException e){
            
            throw new RuntimeException(e);
            
        }
            
            
    }
    
}

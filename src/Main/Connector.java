
package Main;

import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;

public class Connector {
    public Connection  getConnection(){
            try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://Localhost:3306/hotelmanagement",
             "root","root");
          } catch (Exception e) {
//                Logger.getLogger( JDBCconnector.class.getName()).log(Level.SEVER,null,e);
        }
            
            return null;
    }
    public void closeConnection (Connection connection) {
        try {
            if (connection != null && !connection.isClosed()){
                connection.close();
            }
        }catch (Exception e){
    }
    }
}

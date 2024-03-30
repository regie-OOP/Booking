
package Services;

import Main.Connector;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.UserDao;


public class addCustomer {
  private Connection connection;
    private Connector jdbcon;
    private PreparedStatement ps;
    private String sql;
    private ResultSet rs;
    private ResultSetMetaData rsmd;
   
    public addCustomer(){
        this.jdbcon = new Connector();
        this.connection = new Connector().getConnection();
    }
    
    public void BookingFrame(UserDao userdao){
        try {
            sql = "INSERT into bookings (Room, Customer, Date, Days, Cost) values(?,?,?,?,?)";
            ps = connection.prepareStatement(sql);
            ps.setObject(1, userdao.getRoom());
            ps.setInt(2, userdao.getCustomer());
            ps.setDate(3, (Date) userdao.getDate());
            ps.setObject(4, userdao.getDays());
            ps.setInt(5, userdao.getCost());
            
            
           
            
            int result = ps.executeUpdate();
            if (result > 0){
                JOptionPane.showMessageDialog(null, "Customer succesfully added");
                
            } else {
              JOptionPane.showMessageDialog(null, "Failed to add Customer");
            } 
            
            
        }catch (Exception e){  
             Logger.getLogger( addCustomer.class.getName()).log(Level.SEVERE,null,e);
        }
    }
    
 public void updateCustomer(UserDao userdao){
     try {
         sql = "UPDATE bookings SET Room=?, Customer=?, Date=?, Days=?, Cost=? WHERE idbookings";
         ps = connection.prepareStatement(sql);
            ps.setObject(1, userdao.getRoom());
            ps.setInt(2, userdao.getCustomer());
            ps.setDate(3, (Date) userdao.getDate());
            ps.setObject(4, userdao.getDays());
            ps.setInt(5, userdao.getCost());
            ps.setInt(6, userdao.getCustomer_id());
            
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Customer successfully Updated");
            
     } catch (Exception e) {
         Logger.getLogger(addCustomer.class.getName()).log(Level.SEVERE,null,e);
         JOptionPane.showMessageDialog(null, "Failed to Update Customer");
     }
 }
 
 
    
      public void populateTable(DefaultTableModel model){
          try {
              model.setRowCount(0);
              sql = "SELECT * FROM bookings";
              ps = connection.prepareStatement(sql);
              rs = ps.executeQuery();
              rsmd = rs.getMetaData();
              int columnCount = rsmd.getColumnCount();
            
            while(rs.next()){
                Object[] row = new Object[columnCount];
                for(int i = 1; i <= columnCount; i++){
                    row[i-1] = rs.getObject(i);
                }
                model.addRow(row);
            }
              
          } catch (Exception e){
              e.printStackTrace();
          }
      }
    }
    

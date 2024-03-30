
package Main;

import  java.sql.Connection;
import Main.Connector;
import controler.BookingFrame;

public class HM {

   public  static void Connector(){
 Connector connect = new Connector(); 

        try{
            Connection regie = connect.getConnection();
            if (regie != null){
                System.out.println("GWAPA KA");
        }
 
           else {
            System.out.println("EH PANGIT");
      }
    }catch (Exception e){
    
}
    
         
             
         }
   
    public static void main(String[] args) {
        Connector();
        BookingFrame booking = new BookingFrame();
        
        booking.setVisible(true);
                
    }
       
       
    
    
}

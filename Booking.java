import java.text.ParseException;
import java.text.SimpleDateFormat;        //Yeah, we even needed these 2 here - back and forth formatting of the Dates
import java.util.*;
   //When we create a booking, we choose the dates and the program will display the rooms available 
   //based on the roomID parameter from this class (which will be stored with the help of the room class
public class Booking {

   //Attributes
   private int guestID;
   private int roomID;
   private Date startDate;
   private Date endDate;
   
   
   //Constructors
   
   public Booking() {}
   
   public Booking(int guestID, int roomID, Date startDate, Date endDate)   {
       this.startDate = startDate;
       this.endDate = endDate;
       this.guestID = guestID;
       this.roomID = roomID;
   }

   //Getters and Setters
   
   public Date getStartDate() {
       return startDate;
   }
   
   public void setStartDate(Date startDate)  {
       this.startDate = startDate;
   }
   
   public Date getEndDate()   {
      return endDate;
   }
   
   public void setEndDate(Date endDate)   {
       this.endDate = endDate;
   }
   
   public int getGuestID()   {
      return guestID;
   }
   
   public void setGuestID(int guestID)   {
       this.guestID = guestID;
   }
   
   public int getRoomID() {
       return roomID;
   }
   
   public void setRoomID(int roomID)  {
       this.roomID = roomID;
   }
   
   //Printers
   
   public String toString()   {     //Only used when we print to file
      SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
      String start = formatter.format(startDate);
      String end = formatter.format(endDate);
      return guestID + "     " + roomID + "     " + start + "     " + end;
   } 
   
   public void displayAlligned() {     //Only used when we print to console
      SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
      String start = formatter.format(startDate);
      String end = formatter.format(endDate);
      System.out.printf("%-5d%-15d%-15s%-15s%n",guestID,roomID,start,end);
   }   
}


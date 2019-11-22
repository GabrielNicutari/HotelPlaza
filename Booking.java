import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Booking {

   //Attributes
   private int guestID;
   private int roomID;
   private Date startDate;
   private Date endDate;
   
    public Booking(int guestID, int roomID, Date startDate, Date endDate)
   {
       this.startDate = startDate;
       this.endDate = endDate;
       this.guestID = guestID;
       this.roomID = roomID;
   }

   public Booking() {}
   
   //Getters and setters
   public Date getStartDate()
   {
       return startDate;
   }
   public void setStartDate(Date startDate)
   {
       this.startDate = startDate;
   }
   
   public Date getEndDate()
   {
      return endDate;
   }
   public void setEndDate(Date endDate)
   {
       this.endDate = endDate;
   }
   
      public int getGuestID ()
   {
       return guestID;
   }
   public void setGuestID (int guestID)
   {
       this.guestID = guestID;
   }
   
     public int getRoomID ()
   {
       return roomID;
   }
   public void setRoomID (int roomID)
   {
       this.roomID = roomID;
   }
   
   //To String
   public String toString()
   {
      SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
      String start = formatter.format(startDate);
      String end = formatter.format(endDate);
      return guestID + "     " + roomID + "     " + start + "     " + end;
   } 
   
   public void displayAlligned() {
      SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
      String start = formatter.format(startDate);
      String end = formatter.format(endDate);
      System.out.printf("%-5d%-15d%-15s%-15s%n",guestID,roomID,start,end);
   }   
}


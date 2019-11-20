import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Booking {

   //Attributes
   private Date startDate;
   private Date endDate;
   private int RoomID;
   private int GuestID;
   
    public Booking(Date startDate, Date endDate, int RoomID,int GuestID)
   {
       this.startDate = startDate;
       this.endDate = endDate;
       this.GuestID = GuestID;
       this.RoomID = RoomID;
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
       return GuestID;
   }
   public void setGuestID (int GuestID)
   {
       this. GuestID = GuestID;
   }
   
     public int getRoomID ()
   {
       return RoomID;
   }
   public void setRoomID (int RoomID)
   {
       this.RoomID = RoomID;
   }
   
   //To String
   public String toString()
   {
      return startDate + " " + endDate + " " + GuestID+ " " + RoomID;
   } 
   
      



}


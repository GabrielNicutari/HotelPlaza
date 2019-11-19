public class Booking {

   //Attributes
   private int GuestID;    //BookingID actually
   private int RoomID;
   
   public Booking(int GuestID, int RoomID)  {
       this.GuestID = GuestID;
       this.RoomID = RoomID;
   }

   public Booking() {}

   //Getters and Setters
   public int getGuestID ()   {  
       return GuestID;
   }
   
   public void setGuestID (int GuestID)   {
       this.GuestID = GuestID;
   }
   
   public int getRoomID () {
       return RoomID;
   }
   
   public void setRoomID (int RoomID)  {
       this.RoomID = RoomID;
   }
   
   //To String
   
   public String toString()   {
      return "GuestID: " + GuestID + " " + 
             "RoomID:" + RoomID;
   } 
}


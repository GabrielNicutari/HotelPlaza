public class Booking {

   //Attributes
   private String firstName;
   private String phonenumber;
   private int RoomID;
   private int GuestID;
   
    public Booking(String firstName, String phonenumber, int RoomID,int GuestID)
   {
       this.firstName = firstName;
       this.phonenumber = phonenumber;
       this.GuestID = GuestID;
       this.RoomID = RoomID;
   }

       public Booking() {}

   
   //Getters and setters
   public String getFirstName()
   {
       return firstName;
   }
   public void setFirstName(String firstName)
   {
       this.firstName = firstName;
   }
      public int getGuestID ()
   {
       return GuestID;
   }
   public void setGuestID (int GuestID)
   {
       this. GuestID = GuestID;
   }
      public String getPhoneNumber()
   {
       return phonenumber;
   }

   public void setPhoneNumber(String phonenumber)
   {
       this.phonenumber = phonenumber;
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
      return "Name: " + firstName + "Phonenumber:" + phonenumber + "GuestID:" + GuestID + "RoomID:" + RoomID;
   } 
   
      



}


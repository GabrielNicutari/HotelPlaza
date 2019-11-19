public class Room {

   //Atributes
   private int RoomID;
   private int numofbeds;
   private boolean internet;
   private int floor;
   private int price;
   private boolean availability;
   
   public Room(int RoomID, int numofbeds, boolean internet, int floor, int price, boolean avaiability){
       this.RoomID = RoomID;
       this.numofbeds = numofbeds;
       this.internet = internet;
       this.phonenumber = phonenumber;
       this.GuestID = GuestID;
   }

   public Guest() {}
   
   //Getters and setters
   public int getRoomID()  {
       return RoomID;
   }
   
   public void setRoomID(int RoomID)
   {
       this.RoomID = RoomID;
   }
   public int getNumofBeds()  {
       return numofbeds;
   }
   
   public void setNumofBeds(int numofbeds)
   {
       this.numofbeds = numofbeds;
   }

}
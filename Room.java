public class Room {

   //Atributes
   private int RoomID;
   private int numOfBeds;
   private boolean internet;
   private int floor;
   private int price;
   private boolean availability;
   
   public Room(int RoomID, int numOfBeds, boolean internet, int floor, int price, boolean avaiability){
       this.RoomID = RoomID;
       this.numOfBeds = numOfBeds;
       this.internet = internet;
       this.phonenumber = phonenumber;
       this.GuestID = GuestID;
   }

   public Guest() {}
   
   //Getters and setters
   public int getRoomID()  {
       return RoomID;
   }
   
   public void setRoomID(int RoomID)   {
       this.RoomID = RoomID;
   }
   
   public int getNumOfBeds()  {
       return numOfBeds;
   }
   
   public void setNumOfBeds(int numOfBeds)   {
       this.numOfBeds = numOfBeds;
   }

}
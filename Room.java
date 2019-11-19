public class Room {
   private int RoomID;
   private int numOfBeds;
   private boolean internet;
   private int floor;
   private int price;
   private boolean availability;
   
   public Room(int RoomID, int numOfBeds, boolean internet, int floor, int price, boolean availability){
       this.RoomID = RoomID;
       this.numOfBeds = numOfBeds;
       this.internet = internet;
       this.floor = floor;
       this.price = price;
       this.availability = availability;
   }

   public Room() {}
   
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
   public boolean getInternet(){
       return internet;
   }
   public void setInternet(boolean internet){
       this.internet = internet;
   }
   public int getFloor()  {
       return floor;
   }
   
   public void setFloor(int floor)   {
       this.floor = floor;
   }
   public int getPrice()  {
       return price;
   }
   
   public void setPrice(int price)   {
       this.price = price;
   }
   public boolean getAvailability()  {
       return availability;
   }
   
   public void setAvailability(boolean availability)   {
       this.availability = availability;
   }
   
   //To string
   public String toString()   {
      return RoomID + " " + numOfBeds + " " + internet + " " + floor + " " + price + " " + availability;
   }
}
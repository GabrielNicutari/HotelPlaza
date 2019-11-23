public class Room {

   //Attributes
   
   private int ID;
   private int numOfBeds;
   private boolean internet;
   private int floor;
   private int price;
   
   //Constructors
   
   public Room() {}
   
   public Room(int ID, int numOfBeds, boolean internet, int floor, int price){
       this.ID = ID;
       this.numOfBeds = numOfBeds;
       this.internet = internet;
       this.floor = floor;
       this.price = price;
   }
   
   //Getters and Setters
   public int getID()  {
       return ID;
   }
   
   public void setID(int ID)   {
       this.ID = ID;
   }
   
   public int getNumOfBeds()  {
       return numOfBeds;
   }
   
   public void setNumOfBeds(int numOfBeds)   {
       this.numOfBeds = numOfBeds;
   }
   
   public boolean getInternet()  {
       return internet;
   }
   
   public void setInternet(boolean internet) {
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

   //Printers
   
   public String toString()   {     //Only used when we print to file
      return ID + "     " + numOfBeds + "     " + internet + "     " + floor + "     " + price;
   }
   
   public void displayAlligned() {     //Only used when we print to console
      System.out.printf("%-15d%-15d%-15b%-15d%-15d%n",ID,
                        numOfBeds,internet,floor,price);
   }

}
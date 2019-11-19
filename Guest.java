public class Guest implements personalinfo {
  
   //Atrributes
   private String lastName;
   private String firstName;
   private String address;
   private String phonenumber;
   private int GuestID;

   public Guest(String firstName, String lastName, String address, String phonenumber, int GuestID)   {
       this.lastName = lastName;
       this.firstName = firstName;
       this.address = address;
       this.phonenumber = phonenumber;
       this.GuestID = GuestID;
   }

   public Guest() {}
 
   //Getters and setters
   public String getFirstName()  {
       return firstName;
   }
   
   public void setFirstName(String firstName)
   {
       this.firstName = firstName;
   }

   public String getLastName()   {
       return lastName;
   }

   public void setLastName(String lastName)  {
       this.lastName = lastName;
   }

   public  String getAddress()   {
       return address;
   }

   public void setAddress(String address) {
       this.address = address;
   }

   public String getPhoneNumber()   {
       return phonenumber;
   }

   public void setPhoneNumber(String phonenumber)  {
       this.phonenumber = phonenumber;
   }
   
   public int getGuestID ()   {
       return GuestID;
   }
   
   public void setGuestID (int GuestID)   {
       this.GuestID = GuestID;
   }
   
   //To String
   public String toString()   {
      return "Name: " + firstName + " " + lastName + " " + "Address: " + address + "  " + "Telephone no.: " + phonenumber + "GuestID:" + GuestID;
   }
}
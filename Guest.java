public class Guest {
  
   //Atrributes
   private String firstName;
   private String lastName;
   private String phoneNumber;
   private String address;
   private int GuestID;

   public Guest(String firstName, String lastName, String address, String phoneNumber, int GuestID)   {
       this.firstName = firstName;
       this.lastName = lastName;
       this.phoneNumber = phoneNumber;
       this.address = address;
       this.GuestID = GuestID;
   }

   public Guest() {}
 
   //Getters and setters
   public String getFirstName()  {
       return firstName;
   }
   
   public void setFirstName(String firstName)   {
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
       return phoneNumber;
   }

   public void setPhoneNumber(String phoneNumber)  {
       this.phoneNumber = phoneNumber;
   }
   
   public int getGuestID ()   {
       return GuestID;
   }
   
   public void setGuestID (int GuestID)   {
       this.GuestID = GuestID;
   }
   
   //To String
   public String toString()   {
      return "Name: " + firstName + " " + lastName + " " +  "Telephone no.: " + phoneNumber + "Address: " + address + "  " + "GuestID:" + GuestID;
   }
}
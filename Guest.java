public class Guest {
  
   //Atrributes
   
   private String firstName;
   private String lastName;
   private String address;
   private String phonenumber;
   private int guestID;
   
   //Constructors
   
   public Guest() {}
   
   public Guest(String firstName, String lastName, String address, String phonenumber, int guestID)
   {
       this.lastName = lastName;
       this.firstName = firstName;
       this.address = address;
       this.phonenumber = phonenumber;
       this.guestID = guestID;
   }

   //Getters and Setters
   
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
       return phonenumber;
   }

   public void setPhoneNumber(String phonenumber)  {
       this.phonenumber = phonenumber;
   }
   
   public int getGuestID ()   {
       return guestID;
   }
   
   public void setGuestID (int guestID)   {
       this. guestID = guestID;
   }
   
   //Printers
   
   public String toString()   {     //Only used when we print to file
      return firstName + "     " + lastName + "     " + address + "     " + phonenumber + 
      "     " + guestID;
   }  
   
   public void displayAlligned() {     //Only used when we print to console
      System.out.printf("%-15s%-15s%-15s%-15s%-15d%n",firstName,
                        lastName,address,phonenumber,guestID);
   }
}
public class Guest {
  
   //Atrributes
   private String lastName;
   private String firstName;
   private String address;
   private String phonenumber;
   private int guestID;

   public Guest(String firstName, String lastName, String address, String phonenumber, int guestID)
   {
       this.lastName = lastName;
       this.firstName = firstName;
       this.address = address;
       this.phonenumber = phonenumber;
       this.guestID = guestID;
   }

       public Guest() {}
 
   //Getters and setters
   public String getFirstName()
   {
       return firstName;
   }
   public void setFirstName(String firstName)
   {
       this.firstName = firstName;
   }

   public String getLastName()
   {
       return lastName;
   }

   public void setLastName(String lastName)
   {
       this.lastName = lastName;
   }

   public  String getAddress()
   {
       return address;
   }

   public void setAddress(String address)
   {
       this.address = address;
   }

   public String getPhoneNumber()
   {
       return phonenumber;
   }

   public void setPhoneNumber(String phonenumber)
   {
       this.phonenumber = phonenumber;
   }
   
   public int getGuestID ()
   {
       return guestID;
   }
   public void setGuestID (int guestID)
   {
       this. guestID = guestID;
   }
   
   //To String
   public String toString()
   {
      return firstName + "     " + lastName + "     " + address + "     " + phonenumber + 
      "     " + guestID;
   }  
   
   public void displayAlligenedGuest() {
      System.out.printf("%-15s%-15s%-15s%-15s%-15d%n",firstName,
                        lastName,address,phonenumber,guestID);
   }
}
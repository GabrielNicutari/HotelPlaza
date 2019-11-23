public class Guest {
  
   //Atrributes
   
   private int ID;
   private String firstName;
   private String lastName;
   private String address;
   private String phoneNumber;

   //Constructors
   
   public Guest() {}
   
   public Guest(int ID, String firstName, String lastName, String address, String phoneNumber)
   {
       this.ID = ID;
       this.lastName = lastName;
       this.firstName = firstName;
       this.address = address;
       this.phoneNumber = phoneNumber;
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
       return phoneNumber;
   }

   public void setPhoneNumber(String phoneNumber)  {
       this.phoneNumber = phoneNumber;
   }
   
   public int getID ()   {
       return ID;
   }
   
   public void setID (int ID)   {
       this.ID = ID;
   }
   
   //Printers
   
   public String toString()   {     //Only used when we print to file
      return ID + "     " + firstName + "     " + lastName + "     " + address + "     " + phoneNumber;
   }  
   
   public void displayAlligned() {     //Only used when we print to console
      System.out.printf("%-5d%-15s%-15s%-15s%-15s%n",ID,firstName,
                        lastName,address,phoneNumber);
   }
}
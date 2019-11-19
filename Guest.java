public class Guest {
   private String lastName;
   private String firstName;
   private  String address;
   private String telephoneNr;

   public Guest(String firstName, String lastName, String address, String telephoneNr)
   {
       this.lastName = lastName;
       this.firstName = firstName;
       this.address = address;
       this.telephoneNr = telephoneNr;
   }

   public Guest() {}

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

   public String getTelephoneNr()
   {
       return telephoneNr;
   }

   public void setTelephoneNr(String telephoneNr)
   {
       this.telephoneNr = telephoneNr;
   }
   
   public String toString()
   {
      return "Name: " + firstName + " " + lastName + " " + "Address: " + address + "  " + "Telephone no.: " + telephoneNr;
   }
}
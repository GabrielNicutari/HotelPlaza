public class Staff {
   
   //Attributes
   
   private int ID;
   private String firstName;
   private String lastName;
   private String job;
   private String address;
   private String phoneNumber;
   private String cpr;
   private int hours;
   private int salary;
   
   
   //Constructors
   
   public Staff() {}
   
   public Staff(int ID, String firstName, String lastName, String job, String address, String phoneNumber, String cpr, int hours, int salary) {
      this.ID = ID;
      this.firstName = firstName;
      this.lastName = lastName;
      this.job = job;
      this.address = address;
      this.phoneNumber = phoneNumber;
      this.cpr = cpr;
      this.hours = hours;
      this.salary = salary;    
   }
   
   //Getters and Setters
   
   public void setID(int ID)  {
      this.ID = ID;
   }
   
   public void setFirstName(String name) {
      firstName = name;
   }
   
   public void setLastName(String name) {
      lastName = name;
   }
   
   public void setJob(String job) {
      this.job = job;
   }
   
   public void setAddress(String address) {
      this.address = address;
   } 
   
   public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
   }
   
   public void setCpr(String cpr) {
      this.cpr = cpr;
   }
   
   public void setHours(int hours) {
      this.hours = hours;
   }
   
   public void setSalary(int salary) {
      this.salary = salary;
   }
   
   public int getID()   {
      return ID;
   }
   
   public String getFirstName() {
      return firstName;
   }
   
   public String getLastName() {
      return lastName;
   }
   
   public String getJob() {
      return job;
   }
   
   public String getAddress() {
      return address;
   }
   
   public String getPhoneNumber() {
      return phoneNumber;
   }
   
   public String getCpr() {
      return cpr;
   }
   
   public int getHours() {
      return hours;
   }
   
   public int getSalary() {
      return salary;
   }
   
   
   //Printers
   
   public String toString() {    //Only used when we print to file
      return ID + "     " + firstName + "     " + lastName + "     " + job + "     " + address + "     " 
      + phoneNumber + "     " + cpr + "     " + hours + "     " + salary;
   }
   
   public void displayAlligned() {     //Only used when we print to console
      System.out.printf("%-5d%-21s%-21s%-20s%-20s%-15s%-12s%-16d%-15d%n",ID,firstName,
                        lastName,job,address,phoneNumber,cpr,hours,salary);
   }
}
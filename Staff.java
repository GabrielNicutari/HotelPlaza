public class Staff {
   //attributes
   private String firstName;
   private String lastName;
   private String title;
   private String address;
   private String phoneNumber;
   private String cpr;
   private int hours;
   private int salary;
   
   
   //constructors
   public Staff() {}
   
    Staff(String firstName, String lastName, String role, String address, String phoneNumber, String cpr, int hours, int salary) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.role = role;
      this.address = address;
      this.phoneNumber;
      this.cpr = cpr;
      this.hours = hours;
      this.salary = salary;    
   }
   
   
   //setters
   public void setFirstName(String name) {
      firstName = name;
   }
   
   public void setLastName(String name) {
      lastName = name;
   }
   
   public void setTitle(String title) {
      this.title = title;
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
   
   
   //getters
   public String getFirstName() {
      return firstName;
   }
   
   public String getLastName() {
      return lastName;
   }
   
   public String getTitle() {
      return title;
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
   
   
   //methods
   
   public String toString() {
      return "First Name: " + firstName + ", Last Name: " + lastName + ", Title: " + title + ", Address: " + address + 
             ", Phone Number: " + phoneNumber + "CPR: " + cpr + "\nHours: " + hours + ", Salary: " + salary;
   }
}
public class Transit {

public void displayStaff() throws IOException {
      System.out.println("Staff members");
      System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%n","First Name",
                        "Last Name","Job","Address","Phone number","CPR","Working hours","Salary");
      System.out.println("------------------------------------------------------------------------------------------------------------------------------");
      for (int i=0; i < staffList.size(); i++) {
        staffList.get(i).displayAlligenedStaff();
        }
      }


   public String toString() {
      return firstName + "     " + lastName + "     " + job + "     " + address + "     " 
      + phoneNumber + "     " + cpr + "     " + hours + "     " + salary;
   }
      public void displayAlligenedStaff() {
      System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15d%-15d%n",firstName,
                        lastName,job,address,phoneNumber,cpr,hours,salary);
   }
}
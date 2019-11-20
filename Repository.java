import java.util.*;
import java.io.*;

public class Repository {

   //Staff
   
   ArrayList<Staff> staffList = new ArrayList<>();
   
   //Create  
   
   public void createStaff() throws IOException {
      Scanner console = new Scanner(System.in);
      Staff staff = new Staff();
      
      System.out.println("In order to create a new member staff, please enter the following:");
      System.out.println("First Name: ");
      staff.setFirstName(console.nextLine());
      
      System.out.println("Last Name: ");
      staff.setLastName(console.nextLine());
      
      System.out.println("Job: ");
      staff.setJob(console.nextLine());
      
      System.out.println("Address: ");
      staff.setAddress(console.nextLine());
      
      System.out.println("Phone number: ");
      staff.setPhoneNumber(console.nextLine());
      
      System.out.println("CPR: ");
      staff.setCpr(console.nextLine());
      
      System.out.println("Working Hours: ");
      staff.setHours(validateInput());
      
      System.out.println("Monthly Salary: ");
      staff.setSalary(validateInput());
      staffList.add(staff);
            
      BufferedWriter output = new BufferedWriter(new FileWriter("Staff.txt", true));
      
      output.newLine();
      output.write(staffList.get(staffList.size() - 1).toString());
      output.close();
      
     //Search
     
      public void searchStaff() throws IOException {
      Scanner console = new Scanner(System.in);
      
           
     
     
   }
   
   public int validateInput()  {
      Scanner console = new Scanner(System.in);
      
      while(!console.hasNextInt())  {
         System.out.println("Wrong input. It has to be a number.");
         String test = console.next();
      }
      int choice = console.nextInt();
      return choice;
   }


}



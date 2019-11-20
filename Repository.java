import java.util.*;
import java.io.*;

public class Repository {

   //Arraylists
   
   ArrayList<Staff> staffList = new ArrayList<>();
   ArrayList<Room> roomList = new ArrayList<>();
   
   //Staff
    
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
      
   }
     //Search
     
   public void searchStaff() throws IOException {
      Scanner console = new Scanner(System.in);
      
   } 
   
   //Rooms
    
   //Create
   public void createRoom() throws IOException {
      Scanner console = new Scanner(System.in);
      Room room = new Room();
      
      System.out.println("In order to create a new room, please enter the following:");
      
      System.out.println("Number of beds in the room: ");
      room.setNumOfBeds(validateInput());
      
      System.out.println("Does the room have internet?");
      System.out.println("If no type false, if yes type true");
      room.setInternet(console.nextBoolean());
      
      System.out.println("Floor:");
      room.setFloor(validateInput());
      
      System.out.println("Price per. night");
      room.setPrice(validateInput());
      
      room.setAvailability(true);
      
      //Adding the room object to the arraylist.
      roomList.add(room);
      
      BufferedWriter output = new BufferedWriter(new FileWriter("Room.txt", true));
      
      output.newLine();
      output.write(roomList.get(roomList.size() - 1).toString());
      output.close();
      
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



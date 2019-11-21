import java.util.*;
import java.io.*;
import java.text.*;
import java.time.format.DateTimeFormatter;

public class Repository {

   Scanner console = new Scanner(System.in);
   
   //Arraylists
   
   ArrayList<Staff> staffList = new ArrayList<>();
   ArrayList<Room> roomList = new ArrayList<>();
   ArrayList<Guest> guestList = new ArrayList<>();
   ArrayList<Booking> bookingList = new ArrayList<>();
   
            //Staff\\
   
   //Input
   
   public void inputStaff() throws FileNotFoundException, IOException   {
                                          
      BufferedReader input = new BufferedReader(new FileReader("Staff.txt"));
      
      String line ="";
      
      while((line = input.readLine()) != null)  {
         String[] split = line.split("     ");
         
         staffList.add(new Staff(split[0],split[1],split[2],split[3],split[4],split[5],Integer.valueOf(split[6]),
                                 Integer.valueOf(split[7])));
      }
      input.close();
   }
   
   //Create  
   
   public void createStaff() throws IOException {
      Staff staff = new Staff();
      
      System.out.println("In order to create a new staff member, please enter the following:");
      
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
   
      String input = console.nextLine();
      boolean ok = false;
      
      for(Staff s : staffList) {
         if (s.getJob().contains(input) || s.getFirstName().contains(input) || s.getCpr().equals(input))  {
            ok = true;
            System.out.print(s.toString());
         }
      }
      if(!ok)  {
         System.out.println("The staff member hasn't been found.");
      }
   } 
   
   //Display
   
   public void displayStaff() throws IOException {
      System.out.println("Staff members");
      
      System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%-15s%-15s%n","First Name",
                        "Last Name","Job","Address","Phone number","CPR","Working hours","Salary");
      System.out.println("------------------------------------------------------------------------------------------------------------------------------");
      
      for (int i=0; i < staffList.size(); i++) {
         staffList.get(i).displayAlligenedStaff();
      }
   }
            //Rooms\\
             
    //Display
   
   public void displayRoom() throws IOException {
     for (Room r : roomList) {
      System.out.println(r.toString());
      }
   }
    
   //Create
   public void createRoom() throws IOException {
      Room room = new Room();
      
      System.out.println("In order to create a new room, please enter the following:");
      
      System.out.println("Number of beds: ");
      room.setNumOfBeds(validateInput());
      
      System.out.println("Internet:");
      System.out.println("Type yes or no:");
      String word = console.next();
      if (word.equals("yes")){
         room.setInternet(true);
         }
      if (word.equals("no")){
         room.setInternet(false);
         }   
      
      System.out.println("Floor:");
      room.setFloor(validateInput());
      
      System.out.println("Price per night:");
      room.setPrice(validateInput());
      
      room.setAvailability(true);
      
      //Adding the room object to the arraylist.
      roomList.add(room);
      
      BufferedWriter output = new BufferedWriter(new FileWriter("Room.txt", true));
      
      output.newLine();
      output.write(roomList.get(roomList.size() - 1).toString());
      output.close();
      
      }
      
            //Guest\\
            
   //Display
   
   public void displayGuest() throws IOException {
    for (Guest g : guestList) {
     System.out.println(g.toString());
    }
   }
    
   //Create
   
   public void createGuest() throws IOException{
   
      Guest guest = new Guest();
      
      System.out.println("In order to create a new booking, please enter the following:");
      System.out.println("First Name:");
      guest.setFirstName(console.nextLine());
         
      System.out.println("Last Name: ");
      guest.setLastName(console.nextLine());
               
      System.out.println("Address: ");
      guest.setAddress(console.nextLine());
         
      System.out.println("Phone number: ");
      guest.setPhoneNumber(console.nextLine());
         
      guestList.add(guest);  
      
      BufferedWriter output = new BufferedWriter(new FileWriter("Guest.txt", true));
         
      output.newLine();
      output.write(guestList.get(guestList.size() - 1).toString());
      output.close(); 
   }
   
   
   
   //Booking
   
   //Display
   
   public void displayBooking() throws IOException {
    for (Booking b : bookingList) {
     System.out.println(b.toString());
    }
   }
    
   //Create
   
   public void createBooking() throws IOException, ParseException{
   
      SimpleDateFormat start = new SimpleDateFormat ("yyyy-MM-dd");
      
      Booking booking = new Booking();
      
      System.out.println("StartDate:");
      Date startDate = new SimpleDateFormat("dd/MM/yyyy").parse(console.next());
      booking.setStartDate(startDate);
      
      System.out.println("EndDate:");
      Date endDate = new SimpleDateFormat("dd/MM/yyyy").parse(console.next());
      endDate = validateDate(startDate, endDate);
      
      booking.setEndDate(endDate);
      
      System.out.println("RoomID:");
      booking.setRoomID(validateInput());              
         
      bookingList.add(booking);  
      
      BufferedWriter output = new BufferedWriter(new FileWriter("Booking.txt", true));
         
      output.newLine();
      output.write(bookingList.get(bookingList.size() - 1).toString());
      output.close(); 
   }

   //Validation for integers
   
   public int validateInput()  {
      Scanner console = new Scanner(System.in);
      
      while(!console.hasNextInt())  {
         System.out.println("Wrong input. It has to be a number.");
         String test = console.next();
      }
      int choice = console.nextInt();
      return choice;
   }
      
   public Date validateDate(Date startDate, Date endDate) throws ParseException {
      
      while(endDate.before(startDate))  {
         System.out.println("Wrong input, the EndDate has to be after the StartDate.");
         endDate = new SimpleDateFormat("dd/MM/yyyy").parse(console.next());
      }
      return endDate;
   }
}



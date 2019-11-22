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
   
   public int inputStaff(int maxID) throws FileNotFoundException, IOException   {
                                          
      BufferedReader input = new BufferedReader(new FileReader("Staff.txt"));
      
      String line ="";
      
      while((line = input.readLine()) != null)  {
         String[] split = line.split("     ");
         
         staffList.add(new Staff(Integer.valueOf(split[0]),split[1],split[2],split[3],split[4],split[5],split[6],Integer.valueOf(split[7]),
                                 Integer.valueOf(split[8])));
         maxID++;
      }
      input.close();
      return maxID;
   }
   
   //Create  
   
   public int createStaff(int maxID) throws IOException {
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
      
      staff.setId(maxID + 1);
      maxID++;
      
      staffList.add(staff);
            
      BufferedWriter output = new BufferedWriter(new FileWriter("Staff.txt", true));
      
      output.newLine();
      output.write(staffList.get(staffList.size() - 1).toString());
      output.close();
      
      return maxID;
   }
  
   
   //Search  
   public void searchStaff() throws IOException {
      
      String input = console.nextLine();
      
      System.out.println();
                        
      boolean ok_object = false, ok_headline = false;
      
      for(Staff s : staffList) {
         if (s.getJob().toLowerCase().contains(input.toLowerCase()) || 
            s.getFirstName().toLowerCase().contains(input.toLowerCase()) ||
            s.getCpr().toLowerCase().equals(input.toLowerCase()))  {
               ok_object = true;
               if(!ok_headline)  {
                  System.out.printf("%-5s%-21s%-20s%-20s%-15s%-12s%-16s%-15s%n","ID","First Name",
                        "Last Name","Job","Address","Phone number","CPR","Working hours","Salary");
                  System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
                  ok_headline = true;
               }
               s.displayAlligned();
         }
      }
      
      System.out.println();
      
      if(!ok_object)  {
         System.out.println("The staff member hasn't been found.");
         System.out.println();
      }
   } 
   
   //Display
   
   public void displayStaff() throws IOException {
      System.out.println("Staff members");
      
      System.out.printf("%-5s%-21s%-20s%-20s%-15s%-12s%-16s%-15s%n","ID","First Name",
                        "Last Name","Job","Address","Phone number","CPR","Working hours","Salary");
      System.out.println("------------------------------------------------------------------------------------------------------------------------------");
      
      
      
      for (int i=0; i < staffList.size(); i++) {
         staffList.get(i).displayAlligned();
      }
   }
   
   //Update
   
   public void updateStaff(int toUpdate, String task)  {
      switch(task)   {
         case "choose":
            for(Staff s : staffList)   {
               
            }
            break;
         case "firstName":
            break;
         case "lastName":
            break;
         case "job":
            break;
         case "address":
            break;
         case "phoneNumber":
            break;
         case "CPR":
            break;
         case "hours":
            break;
         case "salary":
            break; 
         default:
            System.out.println("Wrong task");
      }
   }
     
            //Rooms\\
    //Input
    
    public void inputRoom() throws FileNotFoundException, IOException   {
                                          
      BufferedReader input = new BufferedReader(new FileReader("Room.txt"));
      
      String line ="";
      
      while((line = input.readLine()) != null)  {
         String[] split = line.split("     ");
         
         roomList.add(new Room(Integer.valueOf(split[0]),Integer.valueOf(split[1]),
                               Boolean.valueOf(split[2]),Integer.valueOf(split[3]),Integer.valueOf(split[4]),Boolean.valueOf(split[5])));
      }
      input.close();
   }
            
   //Display
   
   public void displayRoom() throws IOException {
      System.out.println("Room overveiw");
      
      System.out.printf("%-15s%-15s%-15s%-15s%-15s%n","RoomID",
                        "Beds","Wifi","Floor","Price per night");
      System.out.println("------------------------------------------------------------------------------------------------------------------------------");
      
      for (int i=0; i < roomList.size(); i++) {
         roomList.get(i).displayAlligenedRoom();
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
   //Input
   
   public int inputGuest(int maxID) throws FileNotFoundException, IOException   {
                                          
      BufferedReader input = new BufferedReader(new FileReader("Guest.txt"));
      
      String line ="";
      
      while((line = input.readLine()) != null)  {
         String[] split = line.split("     ");
         guestList.add(new Guest(split[0],split[1],split[2],split[3],Integer.valueOf(split[4])));
         maxID++;
      }
      input.close();
      return maxID;
   }
            
   //Display
   
   public void displayGuest() throws IOException {
      System.out.println("Guest overveiw");
      
      System.out.printf("%-15s%-15s%-15s%-15s%-15s%n","First Name",
                        "Last Name","Adress","Phone number","Guest ID");
      System.out.println("------------------------------------------------------------------------------------------------------------------------------");
      
      for (int i=0; i < guestList.size(); i++) {
         guestList.get(i).displayAlligenedGuest();
      }
   }
    
   //Create
   
   public int createGuest(int maxID) throws IOException{
   
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
      
      guest.setGuestID(maxID + 1);
      maxID++; //Increments the ID whenever a guest is created.
         
      guestList.add(guest);  
      
      BufferedWriter output = new BufferedWriter(new FileWriter("Guest.txt", true));
         
      output.newLine();
      output.write(guestList.get(guestList.size() - 1).toString());
      output.close(); 
      
      return maxID;
   }
   
   
   
         //Booking\\
   
   //Input
   
   public void inputBooking() throws FileNotFoundException, IOException, ParseException   {
                                          
      BufferedReader input = new BufferedReader(new FileReader("Booking.txt"));
      
      SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
      
      String line ="";
      
      while((line = input.readLine()) != null)  {
         String[] split = line.split("     ");
         bookingList.add(new Booking(Integer.valueOf(split[0]),Integer.valueOf(split[1]),format.parse(split[2]),format.parse(split[3])));
      }
      input.close();
   }
   
   //Display
   
   public void displayBooking() throws IOException {
      
      System.out.printf("%-5s%-15s%-15s%-15s%n","ID",
                        "Room Number","Start Date","End Date");
      System.out.println("------------------------------------------------");
      
      for (int i = 0; i < bookingList.size(); i++) {
         bookingList.get(i).displayAlligned();
      }    
   }
    
   //Create
   
   public void createBooking() throws IOException, ParseException{
   
      DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
      
      Booking booking = new Booking();
      
      System.out.println("StartDate:");
 
      Date startDate = new SimpleDateFormat("dd/MM/yyyy").parse(console.nextLine());
      booking.setStartDate(startDate);
      
      System.out.println("EndDate:");
      Date endDate = new SimpleDateFormat("dd/MM/yyyy").parse(console.nextLine());
      
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



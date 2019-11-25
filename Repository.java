import java.util.*;
import java.io.*;
import java.text.*;
import java.time.format.DateTimeFormatter;
import java.util.regex.*;
import java.time.*;
import java.util.Calendar;
import java.util.Date;

public class Repository {

   //Current time
   LocalDateTime localDateTime = LocalDateTime.now();
   Date current = Date.from( localDateTime.atZone(ZoneId.systemDefault()).toInstant());
   
   //Console inputs
   
   Scanner console = new Scanner(System.in);
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  //Used to avoid scanner skip issue
   boolean test = true;
   //Arraylists
   
   ArrayList<Staff> staffList = new ArrayList<>();
   ArrayList<Room> roomList = new ArrayList<>();
   ArrayList<Guest> guestList = new ArrayList<>();
   ArrayList<Booking> bookingList = new ArrayList<>();
   
   //Temporary ArrayLists
   ArrayList <Staff> staffList_temp = new ArrayList<>();
   ArrayList<Room> roomList_temp = new ArrayList<>();
   ArrayList<Booking> bookingList_temp = new ArrayList<>();
   ArrayList<Booking> bookingList_tempCreate = new ArrayList<>();
   ArrayList<Room> roomList_tempCreate = new ArrayList<>();
   
   //Patterns
   String decimalPattern = "\\d+";     //One or more digits
   String datePattern = "([0-9]{1,2})-([0-9]{1,2})-([0-9]{2}) [0-9]{2}:[0-9]{2}";
   String CPR_Pattern = "\\d{6}-\\d{4}";
            
            //STAFF FUNCTIONALITY\\
   
   //Input
   
   public int inputStaff(int maxID) throws FileNotFoundException, IOException   {
                                          
      BufferedReader input = new BufferedReader(new FileReader("Staff.txt"));
      
      String line = "";
      
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
      
      System.out.println("First Name:");
      staff.setFirstName(console.nextLine());
      
      System.out.println("Last Name:");
      staff.setLastName(console.nextLine());
      
      System.out.println("Job:");
      staff.setJob(console.nextLine());
      
      System.out.println("Address:");
      staff.setAddress(console.nextLine());
      
      System.out.println("Phone number:");
      staff.setPhoneNumber(console.nextLine());
      
      System.out.println("CPR:");
      staff.setCpr(validateCPR());
      
      System.out.println("Working Hours:");
      staff.setHours(validateInput());
      
      System.out.println("Monthly Salary:");
      staff.setSalary(validateInput());
      
      staff.setID(maxID + 1);
      maxID++;
      
      staffList.add(staff);
            
      BufferedWriter output = new BufferedWriter(new FileWriter("Staff.txt", true));   //Append
      
      if(staffList.size() != 0) {
         output.newLine();
      }
      output.write(staffList.get(staffList.size() - 1).toString());
      output.close();
      
      return maxID;
   }
  
   
   //Search  
   
   public boolean searchStaff() throws IOException, InterruptedException {    
      
      staffList_temp.clear(); //We reset the temporary ArrayList whenever we search
      
      String input = br.readLine();
      
      System.out.println();
                        
      boolean ok_object = false, ok_headline = false;
      
      for(Staff s : staffList) {
      
         if (s.getJob().toLowerCase().contains(input.toLowerCase()) ||        //checkJob
            s.getFirstName().toLowerCase().contains(input.toLowerCase()) ||   //checkFirstName
            s.getCpr().toLowerCase().equals(input.toLowerCase()))  {          //checkCPR
            
            ok_object = true;
            
            if(!ok_headline)  {
               System.out.printf("%-5s%-21s%-21s%-20s%-20s%-15s%-12s%-16s%-15s%n","ID","First Name",
                        "Last Name","Job","Address","Phone number","CPR","Working hours","Salary");
               System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
               ok_headline = true;
            }
                                       
            staffList_temp.add(s);        //Every found object is stored in a temporary ArrayList
            s.displayAlligned();
         }
      }
    
      System.out.println();
      
      if(!ok_object)  {
         System.out.println("The staff member hasn't been found");
         Thread.sleep(1000);
         return false;
      }
      return true;
   } 
   
   //Display
   
   public void displayStaff() throws IOException {
      System.out.println("Staff members");
      
      System.out.printf("%-5s%-21s%-21s%-20s%-20s%-15s%-12s%-16s%-15s%n","ID","First Name",
                        "Last Name","Job","Address","Phone number","CPR","Working hours","Salary");
      System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");

      for (int i=0; i < staffList.size(); i++) {
         staffList.get(i).displayAlligned();
      }
   }
   
   //Update
   
   public void updateStaff(int toUpdate, String task)  throws IOException  {
      int remember = chooseStaff(toUpdate);

      String oldLine = staffList.get(remember).toString();
      
      switch(task)   {
         case "firstName":
         
            System.out.println("Type the new <First Name> of the staff member");
            staffList.get(remember).setFirstName(br.readLine());
            break;
            
         case "lastName":
         
            System.out.println("Type the new <Last Name> of the staff member");
            staffList.get(remember).setLastName(br.readLine());
            break;
            
         case "job":
         
            System.out.println("Type the new <Job> of the staff member");
            staffList.get(remember).setJob(br.readLine());
            break;
            
         case "address":
         
            System.out.println("Type the new <Address> of the staff member");
            staffList.get(remember).setAddress(br.readLine());
            break;
            
         case "phoneNumber":
         
            System.out.println("Type the new <Phone Number> of the staff member");
            staffList.get(remember).setPhoneNumber(br.readLine());
            break;
            
         case "CPR":
         
            System.out.println("Type the new <CPR> of the staff member");
            staffList.get(remember).setCpr(validateCPR());
            break;
            
         case "hours":
         
            System.out.println("Type the new <Hours Per Week> of the staff member");
            staffList.get(remember).setHours(Integer.valueOf(br.readLine()));
            break;
            
         case "salary":
         
            System.out.println("Type the new <Salary> of the staff member");
            staffList.get(remember).setSalary(Integer.valueOf(br.readLine()));
            break; 
            
         case "everything":
           
            System.out.println("Type the new <First Name> of the staff member");
            staffList.get(remember).setFirstName(br.readLine());
            
            System.out.println("Type the new <Last Name> of the staff member");
            staffList.get(remember).setLastName(br.readLine());
            
            System.out.println("Type the new <Job> of the staff member");
            staffList.get(remember).setJob(br.readLine());
            
            System.out.println("Type the new <Address> of the staff member");
            staffList.get(remember).setAddress(br.readLine());
            
            System.out.println("Type the new <Phone Number> of the staff member");
            staffList.get(remember).setPhoneNumber(br.readLine());
            
            System.out.println("Type the new <CPR> of the staff member");
            staffList.get(remember).setCpr(validateCPR());
            
            System.out.println("Type the new <Hours Per Week> of the staff member");
            staffList.get(remember).setHours(Integer.valueOf(br.readLine()));
            
            System.out.println("Type the new <Salary> of the staff member");
            staffList.get(remember).setSalary(Integer.valueOf(br.readLine()));
            break;
            
            
         default:
            System.out.println("Wrong task");
      }
      
      String newLine = staffList.get(remember).toString();
      
      modifyFile(oldLine,newLine,"Staff.txt",staffList);
   }
   
   //Delete
   
   public boolean deleteStaff()  throws FileNotFoundException, IOException, InterruptedException {
      System.out.println("Type the ID of the staff member you want to delete ");
      
      int toDelete = whereInsideStaffTempArray();
      int remember = chooseStaff(toDelete);  
      
      String firstName = staffList.get(remember).getFirstName();
      String lastName = staffList.get(remember).getLastName();
      
      System.out.println();
      System.out.println("Are you sure you want to delete the staff member <" + firstName + " " + lastName + 
                        ">? (Type \"Y/YES\" or \"N/NO\")");
      
      String answer = isYesOrNo();
      
      if(answer.equalsIgnoreCase("YES") || answer.equalsIgnoreCase("Y"))   {
         deleteFromFile(staffList.get(remember).toString(),"Staff.txt",staffList);   //Delete from file                  
         staffList.remove(remember);   //Delete from array  
         System.out.println("The staff member has been deleted");
         Thread.sleep(1000);
         
         return false;
      }  else  {
         return true;
      }
   }
   
   //Choose Who To Update/Delete
   
   public int chooseStaff(int toUpdate)  {
      for(int j = 0; j < staffList_temp.size(); j++)   {
         if(staffList_temp.get(j).getID() == toUpdate) {
            for(int i = 0; i < staffList.size(); i++) {
               if(staffList.get(i).getID() == staffList_temp.get(j).getID()) {
                  return i;      //returns the index in the main ArrayList
               }
            }   
         }
      }
      return -1;
   }
   
   //Find CPR
   
   public int findCPR(String toBeSearched)   {
      for(int i = 0; i < staffList.size(); i++) {
         if(staffList.get(i).getCpr().equals(toBeSearched))   {
            return i;   
         }
      }
      return -1;
   }
   
   public String getStaffFirstName(int i)  {
      return staffList.get(i).getFirstName();
   }
   
   public String getStaffJob(int i)  {
      return staffList.get(i).getJob();
   }
     
            //ROOM FUNCTIONALITY\\
   
   //Input
    
   public void inputRoom() throws FileNotFoundException, IOException   {
                                          
      BufferedReader input = new BufferedReader(new FileReader("Room.txt"));
      
      String line ="";
      
      while((line = input.readLine()) != null)  {
         String[] split = line.split("     ");
         
         roomList.add(new Room(Integer.valueOf(split[0]),Integer.valueOf(split[1]),
                               Boolean.valueOf(split[2]),Integer.valueOf(split[3]),Integer.valueOf(split[4])));
      }
      input.close();
   }
            
   //Display (based on filters)
   
   public void displayRoom(String task) throws IOException {
      
      switch(task)   {
         case "beds":
            
            System.out.println("Choose the amount of beds");
            int beds = console.nextInt();
            
            roomHeadLine();
            
            for(int i = 0; i < roomList.size(); i++)   {
               if(beds == roomList.get(i).getNumOfBeds())   {
                  roomList.get(i).displayAlligned();
               }
            }
            break;
         
         case "internet":
            
            System.out.println("Do you want to display the ones with wi-fi connection? (Type \"Y/YES\" or \"N/NO\")");
            
            String answer = isYesOrNo();
            
            if(answer.equalsIgnoreCase("YES") || answer.equalsIgnoreCase("Y"))   {
               
               roomHeadLine();
               
               for(int i = 0; i < roomList.size(); i++)   {
                  if(roomList.get(i).getInternet())   {     
                     roomList.get(i).displayAlligned();        //Display the ones with wi-fi
                  }
               }
            }  else {      //It's gonna be a "NO/N" anyway, because of the isYesOrNO() method
               
               roomHeadLine();
               
               for(int i = 0; i < roomList.size(); i++)   {
                  if(!roomList.get(i).getInternet())   {    
                     roomList.get(i).displayAlligned();       //Display the ones without wi-fi
                  }
               }
               
            }
            break;
         
         case "floor":
            
            System.out.println("Choose the floor number");
            int floor = console.nextInt();
            
            roomHeadLine();
            
            for(int i = 0; i < roomList.size(); i++)   {
               if(floor == roomList.get(i).getFloor())   {
                  roomList.get(i).displayAlligned();
               }
            }
            break;
            
         case "price":
            
            System.out.println("Choose the price"); //Maybe we can go for ranges here, but usually, rooms have fixed prices)
            
            int price = console.nextInt();
            
            roomHeadLine();
            
            for(int i = 0; i < roomList.size(); i++)   {
               if(price == roomList.get(i).getPrice())   {
                  roomList.get(i).displayAlligned();
               }
            }
            
            break;
            
         default:    //Display All
            System.out.printf("%-15s%-15s%-15s%-15s%-15s%n","RoomID",
                              "Beds","Wifi","Floor","Price per night");
            System.out.println("-------------------------------------------------------------------------------------------");
            
            for (int i=0; i < roomList.size(); i++) {
               roomList.get(i).displayAlligned();
            }
      }
   }
   
   //Prints the headline of room attributes
   
   public void roomHeadLine()   {
      System.out.println();
            
      System.out.printf("%-15s%-15s%-15s%-15s%-15s%n","RoomID",
                              "Beds","Wifi","Floor","Price per night");
      System.out.println("-------------------------------------------------------------------------------------------");
   }
    
   //Create
   
   public void createRoom() throws IOException {
      Room room = new Room();
      
      System.out.println("In order to create a new room, please enter the following:");
      
      System.out.println("Number of beds: ");
      room.setNumOfBeds(validateInput());
      
      System.out.println("Internet: (Type \"Y/YES\" or \"N/NO\")");
      
      String answer = isYesOrNo();
      
      if (answer.equalsIgnoreCase("YES") || answer.equalsIgnoreCase("Y"))  {
         room.setInternet(true);
      }  else  {     //It's "NO" or "N" anyway
         room.setInternet(false);
      }   
      
      System.out.println("Floor:");
      room.setFloor(validateInput());
      
      System.out.println("Price per night:");
      room.setPrice(validateInput());
      
      //Adding the ID, which is based on the index in the array
      room.setID(roomList.size() + 1);
      
      //Adding the room object to the arraylist.
      roomList.add(room);
      
      BufferedWriter output = new BufferedWriter(new FileWriter("Room.txt", true));    //Append
      
      if(roomList.size() != 0) {
         output.newLine();
      }
      output.write(roomList.get(roomList.size() - 1).toString());
      output.close();
      
   }
   
   //Update
   
   public void updateRoom(int toUpdate, String task)  throws IOException  {
      
      int remember = chooseRoom(toUpdate);
      
      String oldLine = roomList.get(remember).toString();
      
      switch(task)   {
         case "numOfBeds":
            
            System.out.println("Type the new <Number Of Beds> of the room");
            roomList.get(remember).setNumOfBeds(Integer.valueOf(br.readLine()));
            break;
            
         case "internet":
            
            System.out.println("Type whether you want the room to have <Internet Connection> or not (Type \"Y/YES\" or \"N/NO\")");
            
            String answer = isYesOrNo();
            
            if(answer.equalsIgnoreCase("YES") || answer.equalsIgnoreCase("Y")) {
               roomList.get(remember).setInternet(true);
            }  else  {
               roomList.get(remember).setInternet(false);
            }
           
            break;
            
         case "price":
            
            System.out.println("Type the new <Job> of the staff member");
            roomList.get(remember).setPrice(Integer.valueOf(br.readLine()));
            break;
                   
         case "everything":
            
            System.out.println("Type the new <Number Of Beds> of the room");
            roomList.get(remember).setNumOfBeds(console.nextInt());
            
            System.out.println("Type whether the room has <Internet Connection> or not");
            roomList.get(remember).setInternet(Boolean.valueOf(br.readLine()));
            
            System.out.println("Type the new <Price> of the room");
            roomList.get(remember).setPrice(console.nextInt());
               
            break;
            
         default:
            System.out.println("Wrong task");
      }
      
      String newLine = roomList.get(remember).toString();
      
      modifyFile(oldLine,newLine,"Room.txt",roomList);   
   }
   
   //Choose Which Room To Update
   
   public int chooseRoom(int toUpdate)  {
      int i;
      for(i = 0 ; i < roomList.size(); i++)   {
         if(roomList.get(i).getID() == toUpdate) {
            return i;
         }
      }
      return -1;
   }
      
            //GUEST FUNCTIONALITY\\
            
   //Input
   
   public int inputGuest(int maxID) throws FileNotFoundException, IOException   {
                                          
      BufferedReader input = new BufferedReader(new FileReader("Guest.txt"));
      
      String line ="";
      
      while((line = input.readLine()) != null)  {
         String[] split = line.split("     ");
         guestList.add(new Guest(Integer.valueOf(split[0]),split[1],split[2],split[3],split[4]));
         maxID++;
      }
      input.close();
      return maxID;
   }
            
   //Display
   
   public void displayGuest() throws IOException {
      System.out.println("Guest overview");
      
      System.out.printf("%-5s%-15s%-15s%-15s%-15s%n","ID","First Name",
                        "Last Name","Adress","Phone number");
      System.out.println("------------------------------------------------------------------------------------------------------------------------------");
      
      for (int i=0; i < guestList.size(); i++) {
         guestList.get(i).displayAlligned();
      }
   }
    
   //Create
   
   public int createGuest(int maxID) throws IOException{
   
      Guest guest = new Guest();

      System.out.println("First Name:");
      guest.setFirstName(console.nextLine());
         
      System.out.println("Last Name:");
      guest.setLastName(console.nextLine());
               
      System.out.println("Address:");
      guest.setAddress(console.nextLine());
         
      System.out.println("Phone number:");
      guest.setPhoneNumber(console.nextLine());
      
      guest.setID(maxID + 1);
      maxID++; //Increments the ID whenever a guest is created.
         
      guestList.add(guest);  
      
      BufferedWriter output = new BufferedWriter(new FileWriter("Guest.txt", true));
         
      if(guestList.size() != 0) {
         output.newLine();
      }
      output.write(guestList.get(guestList.size() - 1).toString());
      output.close(); 
      
      return maxID;
   }
   
   //Search
   
   public void searchGuest()  throws IOException {
      String input = br.readLine();
      
      System.out.println();
                        
      boolean ok_object = false, ok_headline = false;
      
      for(Guest g : guestList) {
      
         if (g.getFirstName().toLowerCase().contains(input.toLowerCase()) ||
            g.getPhoneNumber().toLowerCase().equals(input.toLowerCase()))  {
            
            ok_object = true;
            
            if(!ok_headline)  {
               System.out.printf("%-5s%-15s%-15s%-15s%-15s%n","ID","First Name",
                        "Last Name","Address","Phone number");
               System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
               ok_headline = true;
            }
            
            g.displayAlligned();
         }
      }
      
      System.out.println();
      
      if(!ok_object)  {
         System.out.println("The guest hasn't been found.");
         System.out.println();
      }
   }
   
   //Update
   
   public void updateGuest(int toUpdate, String task)  throws IOException  {
      int remember = chooseGuest(toUpdate);

      String oldLine = guestList.get(remember).toString();
      
      switch(task)   {
         case "firstName":
         
            System.out.println("Type the new <First Name> of the guest");
            guestList.get(remember).setFirstName(br.readLine());
            break;
            
         case "lastName":
         
            System.out.println("Type the new <Last Name> of the guest");
            guestList.get(remember).setLastName(br.readLine());
            break;
            
         case "address":
         
            System.out.println("Type the new <Address> of the guest");
            guestList.get(remember).setAddress(br.readLine());
            break;
            
         case "phoneNumber":
         
            System.out.println("Type the new <Phone Number> of the guest");
            guestList.get(remember).setPhoneNumber(br.readLine());
            break;
                        
         case "everything":
           
            System.out.println("Type the new <First Name> of the guest");
            guestList.get(remember).setFirstName(br.readLine());
            
            System.out.println("Type the new <Last Name> of the guest");
            guestList.get(remember).setLastName(br.readLine());
            
            System.out.println("Type the new <Address> of the guest");
            guestList.get(remember).setAddress(br.readLine());
            
            System.out.println("Type the new <Phone Number> of the guest");
            guestList.get(remember).setPhoneNumber(br.readLine());
            
            break;
            
         default:
            System.out.println("Wrong task");
      }
      
      String newLine = guestList.get(remember).toString();
      
      modifyFile(oldLine,newLine,"Guest.txt",guestList);
   }
   
   //Choose Who To Update
   
   public int chooseGuest(int toUpdate)  {
      int i;
      for(i = 0 ; i < guestList.size(); i++)   {
         if(guestList.get(i).getID() == toUpdate) {
            return i;
         }
      }
      return -1;
   }
   
   
   
   
            //BOOKING FUNCTIONALITY\\
   
   //Input
   
   public void inputBooking() throws FileNotFoundException, IOException, ParseException   {
                                          
      BufferedReader input = new BufferedReader(new FileReader("Booking.txt"));
      
      SimpleDateFormat format = new SimpleDateFormat("dd-MM-yy hh:mm");
      
      String line ="";
      
      while((line = input.readLine()) != null)  {
         String[] split = line.split("     ");
         bookingList.add(new Booking(Integer.valueOf(split[0]),Integer.valueOf(split[1]),format.parse(split[2]),format.parse(split[3])));
      }
      input.close();
   }
   
   //Display
   
   public void displayBooking() throws IOException {
      
     System.out.printf("%-5s%-15s%-15s%-15s%-15s%-10s%n","ID","Room Number",
                        "Start Date","End Date","First Name","Phone number");
     System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
      for (int i = 0; i < bookingList.size(); i++) {
         bookingList.get(i).displayAlligned();
         guestList.get(i).displayNameAndPhoneNumber();
      }    
   }
    
   //Create
   
   public void createBooking() throws IOException, ParseException{

      DateFormat formatter = new SimpleDateFormat("dd-MM-yy hh:mm");
   
      Booking booking = new Booking();
      
      roomList_tempCreate.clear();
   
      System.out.println("In order to create a new booking, please enter the following:");
      
      do {
      
         System.out.println("StartDate: (Type \"dd-mm-yy hh:mm\")");

         Date startDate = new SimpleDateFormat("dd-MM-yy hh:mm").parse(validateDateFormat());
         startDate = validateCurrentTime(startDate, current);
         booking.setStartDate(startDate);

         System.out.println("EndDate: (Type \"dd-mm-yy hh:mm\")");
         Date endDate = new SimpleDateFormat("dd-MM-yy hh:mm").parse(validateDateFormat());
   
         endDate = validateDate(startDate, endDate);
   
         booking.setEndDate(endDate);
         
         validateDateOverlap(startDate,endDate);

      }  while(roomList_tempCreate.size() == 0);

      System.out.println("Type the RoomID");
      booking.setRoomID(validateRoomID());

      bookingList.add(booking);
   }
   
   //Search
   
   public boolean searchBooking() throws IOException, InterruptedException {    
      
      bookingList_temp.clear(); //We reset the temporary ArrayList whenever we search
      
      String input = br.readLine();
      
      System.out.println();
                        
      boolean ok_object = false, ok_headline = false;
      
      //Search by firstName or phoneNumber
      
      for(int i = 0; i < guestList.size(); i++) {
      
            if (guestList.get(i).getPhoneNumber().toLowerCase().equals(input.toLowerCase())  ||    //checkPhoneNumber
                guestList.get(i).getFirstName().toLowerCase().contains(input.toLowerCase()))  {       //checkFirstName
               
               ok_object = true;
               
               if(!ok_headline)  {
                  System.out.printf("%-5s%-15s%-15s%-15s%-15s%-10s%n","ID","Room Number",
                           "Start Date","End Date","First Name","Phone number");
                  System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
                  ok_headline = true;
               }
                                          
               bookingList_temp.add(bookingList.get(i));        //Every found object is stored in a temporary ArrayList
               bookingList.get(i).displayAlligned();
               guestList.get(i).displayNameAndPhoneNumber();
            }
         }
      
      //Search by roomNumber
      boolean match = Pattern.matches(decimalPattern,input);
      if(match)   {
         if(!ok_object)  {
            for(int i = 0; i < bookingList.size(); i++) {
         
               if (bookingList.get(i).getRoomID() == Integer.valueOf(input))  {       //checkRoomNumber
                  
                  ok_object = true;
                  
                  if(!ok_headline)  {
                     System.out.printf("%-5s%-15s%-15s%-15s%-15s%-10s%n","ID","Room Number",
                              "Start Date","End Date","First Name","Phone number");
                     System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
                     ok_headline = true;
                  }
                                             
                  bookingList_temp.add(bookingList.get(i));        //Every found object is stored in a temporary ArrayList
                  bookingList.get(i).displayAlligned();
                  guestList.get(i).displayNameAndPhoneNumber();
               }
            }   
         }   
      }  
      
      if(!ok_object) {
         System.out.println("The booking hasn't been found");
         Thread.sleep(1000);
         return false;
      }  
      return true;
   } 
   
   //Set The Booking ID 
   
   public void setBookingGuestID() throws IOException{
      bookingList.get(bookingList.size()-1).setGuestID(guestList.get(guestList.size()-1).getID());
      BufferedWriter output = new BufferedWriter(new FileWriter("Booking.txt", true));

      if(bookingList.size() != 0) {
         output.newLine();
      }
      output.write(bookingList.get(bookingList.size() - 1).toString());
      output.close(); 
   }
   
   //Update
   
   public void updateBooking(int toUpdate, String task)  throws IOException  {
      
      int remember = chooseBooking(toUpdate);
      
      String oldLine = bookingList.get(remember).toString();
      
      switch(task)   {
         case "startDate":
            
            break;
            
         case "endDate":
                      
            break;
            
         case "everything":
            
            break;
            
         default:
            System.out.println("Wrong task");
      }
      
      String newLine = roomList.get(remember).toString();
      
      modifyFile(oldLine,newLine,"Room.txt",roomList);   
   }
   
   //Renew Booking
   
   public void renewBooking() throws IOException, ParseException, InterruptedException {
      deleteBooking();
      createBooking();
   }
   
   //Delete Booking
   
   public boolean deleteBooking()  throws FileNotFoundException, IOException, InterruptedException {
      System.out.println("Type the ID of the staff member you want to delete ");
      
      int toDelete = whereInsideBookingTempArray();
      int remember = chooseBooking(toDelete);  
      
      String firstName = guestList.get(remember).getFirstName();
      String lastName = guestList.get(remember).getLastName();
      
      System.out.println();
      System.out.println("Are you sure you want to delete <" + firstName + " " + lastName + 
                        ">'s booking? (Type \"Y/YES\" or \"N/NO\")");
      
      String answer = isYesOrNo();
      
      if(answer.equalsIgnoreCase("YES") || answer.equalsIgnoreCase("Y"))   {
         deleteFromFile(bookingList.get(remember).toString(),"Booking.txt",bookingList);   //Delete from file                  
         deleteFromFile(guestList.get(remember).toString(),"Guest.txt",guestList);
         bookingList.remove(remember);   //Delete from array  
         guestList.remove(remember);
         System.out.println("The booking has been deleted");
         Thread.sleep(1000);
         
         return false;
      }  else  {
         return true;
      }
   }
   
   //Choose What To Update/Delete
   
   public int chooseBooking(int toUpdate)  {
      int i;
      for(i = 0 ; i < bookingList.size(); i++)   {
         if(bookingList.get(i).getGuestID() == toUpdate) {
            return i;
         }
      }
      return -1;
   }
   
   //Delete Booking RealTime

   public void deleteRealTime() throws FileNotFoundException, IOException {
      int i;
      for(i = 0 ; i < bookingList.size(); i++){
         localDateTime = LocalDateTime.now();
         current = Date.from( localDateTime.atZone(ZoneId.systemDefault()).toInstant());
         if (bookingList.get(i).getStartDate().before(current)) {
            deleteFromFile(bookingList.get(i).toString(),"Booking.txt",bookingList);
            deleteFromFile(guestList.get(i).toString(),"Guest.txt",guestList); 
            bookingList.remove(i);
            guestList.remove(i);
         } 
      }
   }

               //VALIDATIONS\\
               
   public void validateDateOverlap(Date startDate, Date endDate)   {
         // for(int i = 0; i < bookingList.size(); i++) {
//             if (startDate.before(bookingList.get(i).getStartDate()) || startDate.after(bookingList.get(i).getEndDate()))  {
//                if (endDate.before(bookingList.get(i).getStartDate()) || endDate.after(bookingList.get(i).getEndDate()))  {
//                
//                } else
//                   bookingList_temp.add(bookingList.get(i));
//                } else {
//                   bookingList_temp.add(bookingList.get(i));
//                }
//          }
         for(int i = 0; i < bookingList.size(); i++) {
            if (startDate.after(bookingList.get(i).getStartDate()) && startDate.before(bookingList.get(i).getEndDate()))  {
               bookingList_temp.add(bookingList.get(i));

            } else {
               if (startDate.before(bookingList.get(i).getStartDate()) && endDate.after(bookingList.get(i).getStartDate())) {
                  bookingList_temp.add(bookingList.get(i));
               }
            }
         }
         
         for (int j = 0; j < bookingList_temp.size(); j++)  {
            bookingList_temp.get(j).displayAlligned();
         }
            
   
         //Stores the availble rooms in a temp array
   
         int j = 0;
         boolean ok = true;
         while (j < roomList.size())  {
            for(int u = 0; u < bookingList_temp.size(); u++) {
               if (bookingList_temp.get(u).getRoomID() == roomList.get(j).getID())  {
                  ok = false;
                  continue;
               }
            }
            
            if (ok) {
               roomList_tempCreate.add(roomList.get(j));
            }
            ok = true;
            j++;
         }
         System.out.println();
         if(roomList_tempCreate.size() == 0) {
            System.out.println("There is no available room for the chosen dates.");
            System.out.println();
            test = false;
         }
         
         //Prints out the availble rooms.
         if (test) {
            roomHeadLine();
         }
         for (int p = 0; p < roomList_tempCreate.size(); p++) {
            roomList_tempCreate.get(p).displayAlligned();
         }
   }   
   //Integers
   
   public int validateInput()  {
      Scanner console = new Scanner(System.in);
      
      while(!console.hasNextInt())  {
         System.out.println("Wrong input. It has to be a number.");
         String test = console.next();
      }
      int choice = console.nextInt();
      return choice;
   }
   
   //CPR
   
   public String validateCPR()  throws IOException{
            
      String CPR = console.nextLine();
      boolean match = Pattern.matches(CPR_Pattern,CPR);
      while(!match) {
         System.out.println("Wrong format. Try again!  ---> (\"ddmmyy-xxxx\") ");
         CPR = console.nextLine();
         match = Pattern.matches(CPR_Pattern,CPR);
      }
      return CPR;
   }
   
   //Dates
   
   public Date validateDate(Date startDate, Date endDate) throws ParseException {
      
      while(endDate.before(startDate))  {
         System.out.println("Wrong input, the EndDate has to be after the StartDate.");
         endDate = new SimpleDateFormat("dd-MM-yy hh:mm").parse(console.nextLine());
      }
      return endDate;
   }
   
   //Date Format
   
   public String validateDateFormat()  {
      String date = console.nextLine();
      boolean match = Pattern.matches(datePattern,date);
      while(!match)  {
         System.out.println("Wrong Format. (Type \"dd-mm-yy hh:mm\").");
         date = console.nextLine();
         match = Pattern.matches(datePattern,date);
      }
      return date;
   }
   
   //Yes / No
   
   public String isYesOrNo() {
      String input = console.next();
      while(isNotYesOrNO(input)) {     //Input Validation
         System.out.println("Wrong input. Type \"Y/YES\" or \"N/NO\"");
         input = console.next(); 
      }
      return input;
   }
   
   public boolean isNotYesOrNO(String input) {
      return !(input.equalsIgnoreCase("N") || input.equalsIgnoreCase("NO") || input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("YES"));
   }
   
   //Where is the ID in the staffList_temp?  
   
   public int whereInsideStaffTempArray() {
      int input = validateInput();
      boolean ok = isInStaffTempArray(input);
      
      while(!ok)  {
        System.out.println("You can only choose between the listed IDs");
        input = validateInput(); 
        ok = isInStaffTempArray(input);
      }
      return input;
   }
   
   //Is the ID in the staffList_temp?
   
   public boolean isInStaffTempArray(int input) {    
      for(int i = 0; i < staffList_temp.size(); i++)  {
         if(staffList_temp.get(i).getID() == input)   {
            return true;
         }
      }
      return false;
   }
   
   //Where is the ID in the roomList_temp?
   
   public int validateRoomID() {
      int input = validateInput();
      boolean ok = isInRoomTempCreateArray(input);

      while(!ok)  {
        System.out.println("You can only choose between the listed IDs");
        input = validateInput(); 
        ok = isInRoomTempCreateArray(input);
    
      }
      return input;
   }
   
   //Is the ID in the roomList_temp?
   
   public boolean isInRoomTempCreateArray(int input) {
      for(int i = 0; i < roomList_tempCreate.size(); i++)  {
         if(roomList_tempCreate.get(i).getID() == input)   {
            return true;
         }
      }
      return false;
   }
   
   //Where is the ID in the staffList_temp?  
   
   public int whereInsideBookingTempArray() {
      int input = validateInput();
      boolean ok = isInBookingTempArray(input);
      
      while(!ok)  {
        System.out.println("You can only choose between the listed IDs");
        input = validateInput(); 
        ok = isInBookingTempArray(input);
      }
      return input;
   }
   
   //Is the ID in the bookingList_temp?
   
   public boolean isInBookingTempArray(int input) {
      for(int i = 0; i < bookingList_temp.size(); i++)  {
         if(bookingList_temp.get(i).getGuestID() == input)   {
            return true;
         }
      }
      return false;
   }
   
   //Current time
   
   public Date validateCurrentTime(Date startDate, Date current) throws ParseException  {
      while (startDate.before(current)) {
            System.out.println("The start date has to be after the current time");
            startDate = new SimpleDateFormat("dd-MM-yy hh:mm").parse(validateDateFormat());
      } 
      return startDate;
   }
   
            //FILES UPDATE\\
   
   //Modify (in)
   
   public void modifyFile(String oldLine, String newLine, String fileName, ArrayList <?> arr) throws IOException   {
      String line = "";
      String oldText = "";
      BufferedReader input = new BufferedReader(new FileReader(fileName));
      
      int lineNr = 0;
      while((line = input.readLine())!= null)  {
         lineNr++;
         
         if(lineNr != arr.size()) {
            oldText += line + "\r\n";
         }  else {
            oldText += line;
         }
      }
      
      input.close();
      
      String newText = oldText.replaceAll(oldLine,newLine);
      
      FileWriter output = new FileWriter(fileName);
      output.write(newText);
      output.close();
   }
   
   //Delete (from)
   
   public void deleteFromFile(String lineToDelete, String fileName, ArrayList <?> arr)  throws FileNotFoundException, IOException{
      File inputFile = new File(fileName);
      File tempFile = new File("myTempFile.txt");
   
      BufferedReader input = new BufferedReader(new FileReader(inputFile));
      BufferedWriter output = new BufferedWriter(new FileWriter(tempFile));
      
      String currentLine;
      int line = 0;
      while((currentLine = input.readLine()) != null) {
         String trimmedLine = currentLine.trim();
         line++;
         if(trimmedLine.equals(lineToDelete))   
            continue;
         if(line != arr.size() - 1) {         
            output.write(currentLine + System.getProperty("line.separator"));
         }  else {
            output.write(currentLine);
         }
      }
      output.close();
      input.close();
      inputFile.setWritable(true);
      inputFile.delete();
      boolean successful = tempFile.renameTo(inputFile);
   }
}

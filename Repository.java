import java.util.*;
import java.io.*;
import java.text.*;
import java.time.format.DateTimeFormatter;

public class Repository {
   
   //Console inputs
   
   Scanner console = new Scanner(System.in);
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  //Used to avoid scanner skip issue
   
   //Arraylists
   
   ArrayList<Staff> staffList = new ArrayList<>();
   ArrayList<Room> roomList = new ArrayList<>();
   ArrayList<Guest> guestList = new ArrayList<>();
   ArrayList<Booking> bookingList = new ArrayList<>();
   
            
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
            
      BufferedWriter output = new BufferedWriter(new FileWriter("Staff.txt", true));   //Append
      
      output.newLine();
      output.write(staffList.get(staffList.size() - 1).toString());
      output.close();
      
      return maxID;
   }
  
   
   //Search  
   
   public void searchStaff() throws IOException {
      
      String input = br.readLine();
      
      System.out.println();
                        
      boolean ok_object = false, ok_headline = false;
      
      for(Staff s : staffList) {
      
         if (s.getJob().toLowerCase().contains(input.toLowerCase()) || 
            s.getFirstName().toLowerCase().contains(input.toLowerCase()) ||
            s.getCpr().toLowerCase().equals(input.toLowerCase()))  {
            
            ok_object = true;
            
            if(!ok_headline)  {
               System.out.printf("%-5s%-21s%-21s%-20s%-20s%-15s%-12s%-16s%-15s%n","ID","First Name",
                        "Last Name","Job","Address","Phone number","CPR","Working hours","Salary");
               System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
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
            staffList.get(remember).setCpr(br.readLine());
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
            staffList.get(remember).setCpr(br.readLine());
            
            System.out.println("Type the new <Hours Per Week> of the staff member");
            staffList.get(remember).setHours(Integer.valueOf(br.readLine()));
            
            System.out.println("Type the new <Salary> of the staff member");
            staffList.get(remember).setSalary(Integer.valueOf(br.readLine()));
            break;
            
         default:
            System.out.println("Wrong task");
      }
      
      String newLine = staffList.get(remember).toString();
      
      modifyFile(oldLine,newLine,"Staff.txt");
   }
   
   //Delete
   
   public boolean deleteStaff()  throws FileNotFoundException, IOException {
      System.out.println("Type the ID of the staff member you want to delete ");
      
      int toDelete = console.nextInt();
      int remember = chooseStaff(toDelete);  
      
      String firstName = staffList.get(remember).getFirstName();
      String lastName = staffList.get(remember).getLastName();
      
      
      System.out.println("Are you sure you want to delete the staff member <" + firstName + " " + lastName + 
                        ">? (Type \"Y/YES\" or \"N/NO\")");
      
      String answer = isYesOrNo();
      
      if(answer.equalsIgnoreCase("YES") || answer.equalsIgnoreCase("Y"))   {
         deleteFromFile(staffList.get(remember).toString(),"Staff.txt");   //Delete from file                  
         staffList.remove(remember);   //Delete from array  
         System.out.println("The staff member has been deleted");
         
         return false;
      }  else  {
         return true;
      }
   }
   
   //Choose Who To Update/Delete
   
   public int chooseStaff(int toUpdate)  {
      int i;
      for(i = 0 ; i < staffList.size(); i++)   {
         if(staffList.get(i).getId() == toUpdate) {
            return i;
         }
      }
      return -1;
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
            
            roomHeadline();
            
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
               
               roomHeadline();
               
               for(int i = 0; i < roomList.size(); i++)   {
                  if(roomList.get(i).getInternet())   {     
                     roomList.get(i).displayAlligned();        //Display the ones with wi-fi
                  }
               }
            }  else {      //It's gonna be a "NO/N" anyway, because of the isYesOrNO() method
               
               roomHeadline();
               
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
            
            roomHeadline();
            
            for(int i = 0; i < roomList.size(); i++)   {
               if(floor == roomList.get(i).getFloor())   {
                  roomList.get(i).displayAlligned();
               }
            }
            break;
            
         case "price":
            
            System.out.println("Choose the price"); //Maybe we can go for ranges here, but usually, rooms have fixed prices)
            
            int price = console.nextInt();
            
            roomHeadline();
            
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
   
   public void roomHeadline()   {
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
      
      output.newLine();
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
            
            System.out.println("Type whether you want the room to have <Internet Connection> or not");
            roomList.get(remember).setInternet(Boolean.valueOf(br.readLine()));
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
      
      modifyFile(oldLine,newLine,"Room.txt");   
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
         guestList.get(i).displayAlligned();
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
   
   
   
            //BOOKING FUNCTIONALITY\\
   
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

               //VALIDATIONS\\
   
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
   
   //Dates
   
   public Date validateDate(Date startDate, Date endDate) throws ParseException {
      
      while(endDate.before(startDate))  {
         System.out.println("Wrong input, the EndDate has to be after the StartDate.");
         endDate = new SimpleDateFormat("dd/MM/yyyy").parse(console.next());
      }
      return endDate;
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
   
            //FILES UPDATE\\
   
   //Modify (in)
   
   public void modifyFile(String oldLine, String newLine, String fileName) throws IOException   {
      String line = "";
      String oldText = "";
      BufferedReader input = new BufferedReader(new FileReader(fileName));
      
      while((line = input.readLine())!= null)  {
         oldText += line + "\r\n";
      }
      
      input.close();
      
      String newText = oldText.replaceAll(oldLine,newLine);
      
      FileWriter output = new FileWriter(fileName);
      output.write(newText);
      output.close();
   }
   
   //Delete (from)
   
   public void deleteFromFile(String lineToDelete, String fileName)  throws FileNotFoundException, IOException{
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
         
         if(line != staffList.size()) {
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



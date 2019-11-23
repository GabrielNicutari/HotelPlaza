import java.util.*;
import java.io.*;
import java.text.*;
import java.time.format.DateTimeFormatter;

public class Menu {
   
   public Menu()  {}
   
   Repository repo = new Repository();    //Repository - The class in charge of the BackEnd
   
   //We use these to have constant IDs, and not based on index
   int maxID = 0;       //guest 
   int maxID_Staff = 0;    //staff
   
   //Console inputs
   Scanner console = new Scanner(System.in);
   
   
            //MAIN MENU\\
         
   public void displayForAdministrator() throws IOException, ParseException{
      //Check the current maxID for staff and guest at the beginning of the program (based on the files)
      //Also input everything from the files at the same time
      maxID = repo.inputGuest(maxID);
      maxID_Staff = repo.inputStaff(maxID_Staff);
      repo.inputRoom();
      repo.inputBooking();
      
      int choice = -1;
      do {
         System.out.println("MAIN MENU");
         System.out.println("****************************");
         System.out.println("Choose an option: ");
         System.out.println("[1] Staff");
         System.out.println("[2] Rooms");
         System.out.println("[3] Guests");
         System.out.println("[4] Bookings");
         System.out.println("[5] Exit program");
         System.out.println("============================");
         
         choice = validateInput(choice, 5);
         
         switch(choice) {
            
            case 1:
            
               printEmptyLines();
               staffMenu();
               printEmptyLines();
               break;
               
            case 2:
            
               printEmptyLines();
               roomMenu();
               printEmptyLines();
               break;
               
            case 3:
            
               printEmptyLines();
               guestMenu();
               printEmptyLines();
               break;
               
            case 4:
            
               printEmptyLines();
               bookingMenu();
               printEmptyLines();
               break;
               
            case 5:
               break;
               
            default:
            
               printEmptyLines();
               System.out.println("Choice must be a value between \"1\" and \"5\".");
         }
      } while(choice != 5);
   }
   
            //STAFF MENUS\\
   
   //Actions Menu
   
   public void staffMenu() throws IOException{
      int choice = -1;
      do {
         System.out.println("STAFF MENU");
         System.out.println("****************************");
         System.out.println("Choose an option: ");
         System.out.println("[1] Display");
         System.out.println("[2] Create");
         System.out.println("[3] Search");     
         System.out.println("[4] Back To Main Menu");
         System.out.println("============================");
         
         choice = validateInput(choice, 4);
         
         switch(choice) {
            case 1:
            
               printEmptyLines();
               repo.displayStaff();
               doesStop();
               printEmptyLines();
               break;
               
            case 2:
            
               printEmptyLines();
               maxID_Staff = repo.createStaff(maxID_Staff);
               doesStop();
               printEmptyLines();
               break;
               
            case 3:
            
               printEmptyLines();  
               searchStaff();
               printEmptyLines();
               
            case 4:
               break;
               
            default:
               printEmptyLines();
               System.out.println("Choice must be a value between \"1\" and \"4\".");
         }
      } while(choice != 4);
   }
   
   //Search
   
   public void searchStaff()  throws IOException   {
      int choice = -1;
      boolean repeat = true;
      boolean updated = false;
      
      do {
         System.out.println("SEARCH STAFF MENU");
         System.out.println("****************************");
         
         if(repeat)  {
            System.out.println("Type the first name, the CPR (ddmmyy-xxxx) or the role of the staff member.");
            repo.searchStaff();
         }
         
         System.out.println("Choose an option: ");
         System.out.println("[1] Update");
         System.out.println("[2] Delete");
         System.out.println("[3] Go Back");
         System.out.println("============================");
         
         choice = validateInput(choice,3);
         
         switch(choice) {
            case 1:
            
               updateStaff();
               repeat = false;
               updated = true;
               printEmptyLines();
               break;
               
            case 2:
            
               repeat = repo.deleteStaff();
               updated = true;
               printEmptyLines();
               break;
               
            case 3:
               break;
               
            default:
               printEmptyLines();
               System.out.println("Choice must be a value between \"1\" and \"3\".");
         }
      }while(choice != 3 && !updated); 
   }
   
   //Update
   
   public void updateStaff()  throws IOException   {      
      System.out.println("Type the <ID> of the staff member you want to modify ");
      int toUpdate = console.nextInt();
      
      int choice = -1;
      do {
          System.out.println();
          System.out.println("Choose what to modify: ");
          System.out.println("[1] First Name ");
          System.out.println("[2] Last Name");
          System.out.println("[3] Job");
          System.out.println("[4] Address");
          System.out.println("[5] Phone Number");
          System.out.println("[6] CPR");
          System.out.println("[7] Hours");
          System.out.println("[8] Salary");
          System.out.println("[9] Everything");
          System.out.println("[10] Go back");
               
          choice = validateInput(choice,10);
          switch(choice) {
            case 1:
            
               printEmptyLines();
               repo.updateStaff(toUpdate,"firstName");
               printEmptyLines();
               break;
               
            case 2:
            
               printEmptyLines();
               repo.updateStaff(toUpdate,"lastName");
               printEmptyLines();
               break;
               
            case 3:
            
               printEmptyLines();
               repo.updateStaff(toUpdate,"job");
               printEmptyLines();
               break;
               
            case 4:
            
               printEmptyLines();
               repo.updateStaff(toUpdate,"address");
               printEmptyLines();
               break;
               
            case 5:
            
               printEmptyLines();
               repo.updateStaff(toUpdate,"phoneNumber");
               printEmptyLines();
               break;
               
            case 6:
            
               printEmptyLines();
               repo.updateStaff(toUpdate,"CPR"); 
               printEmptyLines();     
               break;
               
            case 7:
            
               printEmptyLines();
               repo.updateStaff(toUpdate,"hours");
               printEmptyLines();
               break;
               
            case 8:
            
               printEmptyLines();
               repo.updateStaff(toUpdate,"salary");
               printEmptyLines();
               break;
               
            case 9:
            
               printEmptyLines();
               repo.updateStaff(toUpdate,"everything");
               printEmptyLines();
               break;
               
            case 10:
               break;
               
            default:
               printEmptyLines();
               System.out.println("Choice must be a value between \"1\" and \"10\".");
          }
      }  while(choice != 10);
   }
   
            //ROOM MENUS\\
            
   //Actions Menu
   
   public void roomMenu() throws IOException {
      int choice = -1;
      do {
         System.out.println("ROOMS MENU");
         System.out.println("****************************");
         System.out.println("Choose an option: ");
         System.out.println("[1] Display");
         System.out.println("[2] Create");
         System.out.println("[3] Search");
         System.out.println("[4] Back To Main Menu");
         System.out.println("============================");
         
         choice = validateInput(choice, 4);
         
         switch(choice) {
            case 1:
            
               System.out.println();
               repo.displayRoom("all");
               doesStop();
               printEmptyLines();
               break;
               
            case 2:
            
               printEmptyLines();
               repo.createRoom();
               doesStop();
               printEmptyLines();
               break;
               
            case 3:
            
               printEmptyLines();
               searchRoom();  //Another menu
               printEmptyLines();
               break;
               
            case 4:
               break;
               
            default:
               printEmptyLines();
               System.out.println("Choice must be a value between \"1\" and \"4\".");
         }
      }while(choice != 4);
   }
   
   //Search
   
   public void searchRoom()  throws IOException {
      System.out.println("SEARCH ROOM MENU");
      System.out.println("****************************");
      
      boolean repeat = true;
      int choice = -1;
      do {
         if(repeat)  {
            chooseRoomFilter();
         }
         
         System.out.println("Choose an option: ");
         System.out.println("[1] Further filter");
         System.out.println("[2] Update");
         System.out.println("[3] Go Back");
         System.out.println("============================");
         
         choice = validateInput(choice,3);
         
         switch(choice) {
            case 1:
            
               repeat = true;
               break;
               
            case 2:
            
               updateRoom();     //Another menu
               repeat = false;
               printEmptyLines();
               break;
               
            case 3:
               break;
               
            default:
               printEmptyLines();
               System.out.println("Choice must be a value between \"1\" and \"3\".");
         }
      }while(choice != 3);
   }
   
   //Choose Search Filter
   
   public void chooseRoomFilter()   throws IOException{
      int choice = -1;
      
      System.out.println("Choose a filter: ");
      System.out.println("[1] Number of beds");
      System.out.println("[2] Internet connection");
      System.out.println("[3] Floor");
      System.out.println("[4] Price");
      System.out.println("[5] Go back");
      System.out.println("============================");
         
      choice = validateInput(choice,5);
      switch(choice) {
         case 1:
            
            System.out.println();
            repo.displayRoom("beds");
            System.out.println();
            break;
            
         case 2:
            System.out.println();
            repo.displayRoom("internet");
            System.out.println();
            break;
            
         case 3:
         
            System.out.println();
            repo.displayRoom("floor");
            System.out.println();
            break;
            
         case 4:
            System.out.println();
            repo.displayRoom("price");
            System.out.println();
            break;
         case 5:
            break;
            
         default:
            printEmptyLines();
            System.out.println("Choice must be a value between \"1\" and \"5\".");
      }
   }
   
   //Update
   
   public void updateRoom()   throws IOException   {
      System.out.println("Type the ID of the room you want to modify");
      int toUpdate = console.nextInt();

      //I don't think we ever need to update floor tho
      
      int choice = -1;
      do {
         System.out.println();
         System.out.println("Choose what to modify: ");
         System.out.println("[1] Number Of Beds ");
         System.out.println("[2] Internet Connection");
         System.out.println("[3] Price");
         System.out.println("[4] Everything");
         System.out.println("[5] Go back");
         
         choice = validateInput(choice,5);
         
         switch(choice) {
            case 1:
            
               printEmptyLines();
               repo.updateRoom(toUpdate,"numOfBeds");
               printEmptyLines();
               break;
               
            case 2:
            
               printEmptyLines();
               repo.updateRoom(toUpdate,"internet");
               printEmptyLines();
               break;
               
            case 3:
            
               printEmptyLines();
               repo.updateRoom(toUpdate,"price");
               printEmptyLines();
               break;
               
            case 4:
               
               printEmptyLines();
               repo.updateRoom(toUpdate,"everything");
               printEmptyLines();
               break;
            
            case 5: 
               break;
               
            default:
               printEmptyLines();
               System.out.println("Choice must be a value between \"1\" and \"5\".");
         }
         
      }  while(choice != 5);
   }
   
            //GUEST MENUS\\
   
   //Actions Menu
   
   public void guestMenu()   throws IOException {
      int choice = -1;
      do {
         System.out.println("GUESTS MENU");
         System.out.println("****************************");
         System.out.println("Choose an option: ");
         System.out.println("[1] Display");
         System.out.println("[2] Search");
         System.out.println("[3] Back To Main Menu");
         System.out.println("============================");
         
         choice = validateInput(choice,3);
         
         switch(choice) {
            case 1:
              
               printEmptyLines();
               repo.displayGuest();
               doesStop();
               printEmptyLines();
               break;
               
            case 2:
            
               printEmptyLines();
               searchGuest();    //Another menu
               printEmptyLines();
               break;
               
            case 3:
               break;
               
            default:
               printEmptyLines();
               System.out.println("Choice must be a value between \"1\" and \"3\".");
         }
      }while(choice != 3);
   }
   
   //Search
   
   public void searchGuest() throws IOException{
      int choice = -1;
      boolean repeat = true;
      boolean updated = false;
      
      do {
         System.out.println("SEARCH GUEST MENU");
         System.out.println("****************************");
         
         
         if(repeat)  {
            System.out.println("Type the <First Name> or the <Phone Number> of the guest.");
            repo.searchGuest();
         }
         
         
         System.out.println("Choose an option: ");
         System.out.println("[1] Update");
         //System.out.println("[2] Delete");
         System.out.println("[3] Go Back");
         System.out.println("============================");
         
         choice = validateInput(choice,3);
         
         switch(choice) {
            case 1:
           
               updateGuest();  //Another menu
               repeat = false;
               updated = true;
               printEmptyLines();
               break;
               
            case 2:
            
               //repo.deleteGuest();
               printEmptyLines();
               break;
               
            case 3:
               break;
               
            default:
               printEmptyLines();
               System.out.println("Choice must be a value between \"1\" and \"3\".");
         }
      }while(choice != 3 && !updated);
   }
   
   //Update
   
   public void updateGuest()  throws IOException   {      
      System.out.println("Type the <ID> of the Guest you want to modify ");
      int toUpdate = console.nextInt();
      
      int choice = -1;
      do {
          System.out.println();
          System.out.println("Choose what to modify: ");
          System.out.println("[1] First Name ");
          System.out.println("[2] Last Name");
          System.out.println("[3] Address");
          System.out.println("[4] Phone Number");
          System.out.println("[5] Everything");
          System.out.println("[6] Go back");
               
          choice = validateInput(choice,6);
          switch(choice) {
            case 1:
            
               printEmptyLines();
               repo.updateGuest(toUpdate,"firstName");
               printEmptyLines();
               break;
               
            case 2:
            
               printEmptyLines();
               repo.updateGuest(toUpdate,"lastName");
               printEmptyLines();
               break;
               
            case 3:
            
               printEmptyLines();
               repo.updateGuest(toUpdate,"address");
               printEmptyLines();
               break;
               
            case 4:
            
               printEmptyLines();
               repo.updateGuest(toUpdate,"phoneNumber");
               printEmptyLines();
               break;
               
            case 5:
            
               printEmptyLines();
               repo.updateGuest(toUpdate,"everything");
               printEmptyLines();
               break;
               
            case 6:
               break;
               
            default:
               printEmptyLines();
               System.out.println("Choice must be a value between \"1\" and \"6\".");
          }
      }  while(choice != 6);
   }
   
   
            //BOOKING MENUS\\
            
   //Actions Menu
   
   public void bookingMenu() throws IOException, ParseException   {
      int choice = -1;
      do {
         System.out.println("BOOKINGS MENU");
         System.out.println("****************************");
         System.out.println("Choose an option: ");
         System.out.println("[1] Display");
         System.out.println("[2] Create");
         System.out.println("[3] Search");
         System.out.println("[4] Back To Main Menu");
         System.out.println("============================");
         
         choice = validateInput(choice,4);
         
         switch(choice) {
            case 1:
            
               printEmptyLines();
               repo.displayBooking();
               doesStop();
               printEmptyLines();
               break;
               
            case 2:
            
               printEmptyLines();
               maxID = repo.createGuest(maxID);
               repo.createBooking();
               doesStop();
               printEmptyLines();
               break;
               
            case 3:
            
               printEmptyLines();
               searchBooking();
               printEmptyLines();
               break;
               
            case 4:
               break;
               
            default:
               printEmptyLines();
               System.out.println("Choice must be a value between \"1\" and \"4\".");
         }
      }while(choice != 4);
   }  
   
   //Search
   
   public void searchBooking()  {
      int choice = -1;
      do {
         System.out.println("SEARCH BOOKING MENU");
         System.out.println("****************************");
         System.out.println("");
         
         //repo.searchBooking();
         //chooseBookingFilter();      //Probably not
         
         System.out.println("Choose an option: ");
         System.out.println("[1] Further filter");    //Probably not
         System.out.println("[2] Update");
         System.out.println("[3] Delete");
         System.out.println("[4] Go Back");
         System.out.println("============================");
         
         choice = validateInput(choice,4);
         
         switch(choice) {
            case 1:
            
               // goes through the loop again
               break;
               
            case 2:
            
               printEmptyLines();
               //repo.updateBooking();
               printEmptyLines();
               
               break;
            case 3:
            
               printEmptyLines();
               //repo.deleteBooking();
               //repo.deleteGuest();
               printEmptyLines();
               
               break;
            case 4:
               break;
               
            default:
               printEmptyLines();
               System.out.println("Choice must be a value between \"1\" and \"4\".");
         }
      }while(choice != 4);
   }             
   
            //VALIDATIONS\\
   
   //Integers
   
   public int validateInput(int choice, int lastChoice)  {
      Scanner console = new Scanner(System.in);
      
      while(!console.hasNextInt())  {
         System.out.println("Choice must be a value between \"1\" and " +"\"" + lastChoice + "\".");
         String test = console.next();
      }
      choice = console.nextInt();
      return choice;
   }
   
   //When To Stop
   
   public void doesStop() {
      System.out.println();   //Readability
      System.out.println("Do you want to do anything else? (Type \"Y/YES\" or \"N/NO\")");
      
      String input = console.next();
      while(isNotYesOrNO(input)) {     //Input Validation
         System.out.println("Wrong input. Type Type \"Y/YES\" or \"N/NO\"");
         input = console.next(); 
      }
      
      if(input.equalsIgnoreCase("N") || input.equalsIgnoreCase("NO"))   {
         System.exit(0);
      } 
   }
   
   public boolean isNotYesOrNO(String input) {
      return !(input.equalsIgnoreCase("N") || input.equalsIgnoreCase("NO") || input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("YES"));
   }
   
            //UTILITIES\\
            
   //Empty Lines
   
   public void printEmptyLines() {
      for(int i = 0; i < 5; i++)   {
         System.out.println();
      }
   }
   
}
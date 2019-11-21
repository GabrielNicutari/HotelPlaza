import java.util.*;
import java.io.*;
import java.text.*;
import java.time.format.DateTimeFormatter;

public class Menu {
   
   public Menu()  {}
   
   Repository repo = new Repository();
   
   public void displayForAdministrator() throws IOException, ParseException{
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
               printEmptyLines();
               break;
            case 2:
               printEmptyLines();
               repo.createStaff();
               printEmptyLines();
               break;
            case 3:
               printEmptyLines();
               repo.searchStaff();
               printEmptyLines();
            case 4:
               break;
            default:
               printEmptyLines();
               System.out.println("Choice must be a value between \"1\" and \"4\".");
         }
      } while(choice != 4);
   }
   
   public void roomMenu() {
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
               printEmptyLines();
               //display
               printEmptyLines();
               break;
            case 2:
               printEmptyLines();
               //create
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
   
   public void guestMenu()   {
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
               //display
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
   
   public void bookingMenu() throws IOException, ParseException{
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
               //display;
               printEmptyLines();
               break;
            case 2:
               printEmptyLines();
               repo.createGuest();
               repo.createBooking();
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
   
   public void searchStaff()  throws IOException{
      int choice = -1;
      do {
         System.out.println("SEARCH STAFF MENU");
         System.out.println("****************************");
         System.out.println("Type the first name or the CPR (ddmmyy-xxxx) of the staff member.");
         
         //repo.searchStaff();
         
         System.out.println("Choose an option: ");
         System.out.println("[1] Update");
         System.out.println("[2] Delete");
         System.out.println("[3] Go Back");
         System.out.println("============================");
         
         choice = validateInput(choice,3);
         
         switch(choice) {
            case 1:
               printEmptyLines();
               updateStaff();
               printEmptyLines();
               break;
            case 2:
               printEmptyLines();
               //repo.deleteStaff();
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
   
   public void searchRoom()  {
      int choice = -1;
      do {
         System.out.println("SEARCH ROOM MENU");
         System.out.println("****************************");
         System.out.println("");
         
         //repo.searchRoom();
         chooseRoomFilter();
         
         System.out.println("Choose an option: ");
         System.out.println("[1] Further filter");
         System.out.println("[2] Update");
         System.out.println("[3] Delete");   //We can't delete rooms, I think
         System.out.println("[4] Go Back");
         System.out.println("============================");
         
         choice = validateInput(choice,4);
         
         switch(choice) {
            case 1:
               // goes through the loop again
               break;
            case 2:
               printEmptyLines();
               //repo.updateRoom();
               printEmptyLines();
               break;
            case 3:
               printEmptyLines();
               //repo.deleteRoom();    //Probably not
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
   
   public void chooseRoomFilter()   {
      int choice = -1;
      do {
         System.out.println("****************************");
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
               printEmptyLines();
               //repo.displayRoom("beds");
               printEmptyLines();
               break;
            case 2:
               printEmptyLines();
               //repo.displayRoom("internet");
               printEmptyLines();
               break;
            case 3:
               printEmptyLines();
               //repo.displayRoom("floor");
               printEmptyLines();
               break;
            case 4:
               printEmptyLines();
               //repo.displayRoom("price");
               printEmptyLines();
               break;
            case 5:
               break;
            default:
               printEmptyLines();
               System.out.println("Choice must be a value between \"1\" and \"3\".");
         }
      }while(choice != 5);
   }
   
   public void searchGuest() {
      int choice = -1;
      do {
         System.out.println("SEARCH GUEST MENU");
         System.out.println("****************************");
         System.out.println("Type the first name or the CPR (ddmmyy-xxxx) of the guest.");
         
         //repo.searchGuest();
         
         System.out.println("Choose an option: ");
         System.out.println("[1] Update");
         System.out.println("[2] Delete");
         System.out.println("[3] Go Back");
         System.out.println("============================");
         
         choice = validateInput(choice,3);
         
         switch(choice) {
            case 1:
               printEmptyLines();
               //updateGuest();  //Another menu
               printEmptyLines();
               break;
            case 2:
               printEmptyLines();
               //repo.deleteGuest();
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
   
   public void updateStaff()  throws IOException{
      BufferedReader console = new BufferedReader (new InputStreamReader(System.in)); 
      
      System.out.println("Type the ID of the staff member you want to modify ");
      int toUpdate = console.read();
      
      //repo.updateStaff(toUpdate,"choose");
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
               //repo.updateStaff(toUpdate,"firstName");
               printEmptyLines();
               break;
            case 2:
               printEmptyLines();
               //repo.updateStaff(toUpdate,"lastName");
               printEmptyLines();
               break;
            case 3:
               printEmptyLines();
               //repo.updateStaff(toUpdate,"job");
               printEmptyLines();
               break;
            case 4:
               printEmptyLines();
               //repo.updateStaff(toUpdate,"address");
               printEmptyLines();
               break;
            case 5:
               printEmptyLines();
               //repo.updateStaff(toUpdate,"phoneNumber");
               printEmptyLines();
               break;
            case 6:
               printEmptyLines();
               //repo.updateStaff(toUpdate,"CPR"); 
               printEmptyLines();     
               break;
            case 7:
               printEmptyLines();
               //repo.updateStaff(toUpdate,"hours");
               printEmptyLines();
               break;
            case 8:
               printEmptyLines();
               //repo.updateStaff(toUpdate,"salary");
               printEmptyLines();
               break;
            case 9:
               printEmptyLines();
               //repo.updateStaff(toUpdate,"hours");
               printEmptyLines();
               break;
            case 10:
               printEmptyLines();
              // repo.updateStaff(toUpdate,"everything");
               printEmptyLines();
               break;
            default:
               printEmptyLines();
               System.out.println("Choice must be a value between \"1\" and \"10\".");
          }
      }  while(choice != 10);
   }             
   
   
   public int validateInput(int choice, int lastChoice)  {
      Scanner console = new Scanner(System.in);
      
      while(!console.hasNextInt())  {
         System.out.println("Choice must be a value between \"1\" and " +"\"" + lastChoice + "\".");
         String test = console.next();
      }
      choice = console.nextInt();
      return choice;
   }
   
   public void printEmptyLines() {
      for(int i = 0; i < 5; i++)   {
         System.out.println();
      }
   }
   
   public void doesStop() {
      Scanner console = new Scanner(System.in);
      System.out.println("Do you want to do anything else? (Type \"Y\" or \"N\")");
      
      String input = console.next();
      while(isNotYesOrNO(input)) {     //Input Validation
         input = console.next(); 
      }
      
      if(input.equalsIgnoreCase("N") || input.equalsIgnoreCase("NO"))   {
         System.exit(0);
      } 
   }
   
   public boolean isNotYesOrNO(String input) {
      return !(input.equalsIgnoreCase("N") || input.equalsIgnoreCase("NO") || input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("YES"));
   }
}
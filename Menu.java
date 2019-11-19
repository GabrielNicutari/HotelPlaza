import java.util.*;
import java.io.*;

public class Menu {
   
   public Menu()  {}
   
   public void displayForAdministrator() {
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
         
         choice = validateInput(choice,4);
         
         switch(choice) {
            case 1:
               System.out.println("1");
               staffMenu();
               break;
            case 2:
               System.out.println("2");
               roomsMenu();
               break;
            case 3:
               System.out.println("3");
               guestsMenu();
               break;
            case 4:
               System.out.println("4");
               bookingsMenu();
               break;
            case 5:
               break;
            default:
               System.out.println("Choice must be a value between \"1\" and \"5\".");
         }
      }while(choice != 5);
   }
   
   public void staffMenu() {
      int choice = -1;
      do {
         System.out.println("MAIN MENU");
         System.out.println("****************************");
         System.out.println("Choose an option: ");
         System.out.println("[1] Create");
         System.out.println("[2] Search");
         System.out.println("[3] Back To Main Menu");
         System.out.println("============================");
         
         choice = validateInput(choice,3);
         
         switch(choice) {
            case 1:
               //createStaff();
               break;
            case 2:
               System.out.println("2");
               //searchStaff();
               break;
            case 3:
               break;
            default:
               System.out.println("Choice must be a value between \"1\" and \"3\".");
         }
      }while(choice != 3);
   }
   
   public void roomsMenu() {
      int choice = -1;
      do {
         System.out.println("MAIN MENU");
         System.out.println("****************************");
         System.out.println("Choose an option: ");
         System.out.println("[1] Create");
         System.out.println("[2] Search");
         System.out.println("[3] Back To Main Menu");
         System.out.println("============================");
         
         choice = validateInput(choice,3);
         
         switch(choice) {
            case 1:
               //createRooms();
               break;
            case 2:
               System.out.println("2");
               //searchRooms();
               break;
            case 3:
               break;
            default:
               System.out.println("Choice must be a value between \"1\" and \"3\".");
         }
      }while(choice != 3);
   }
   
   public void guestsMenu()   {
      int choice = -1;
      do {
         System.out.println("MAIN MENU");
         System.out.println("****************************");
         System.out.println("Choose an option: ");
         System.out.println("[1] Display");
         System.out.println("[2] Search");
         System.out.println("[3] Back To Main Menu");
         System.out.println("============================");
         
         choice = validateInput(choice,3);
         
         switch(choice) {
            case 1:
               //createStaff();
               break;
            case 2:
               //searchStaff();
               break;
            case 3:
               break;
            default:
               System.out.println("Choice must be a value between \"1\" and \"3\".");
         }
      }while(choice != 3);
   }
   
   public void bookingsMenu() {
   
   }
   
   public int validateInput(int choice, int lastChoice)   {
      Scanner console = new Scanner(System.in);
      
      while(!console.hasNextInt())  {
         System.out.println("Choice must be a value between \"1\" and " +"\"" + lastChoice + "\".");
         String test = console.next();
      }
      choice = console.nextInt();
      return choice;
   }
}
public class Transit {

//GOES INTO THE ROOM CLASS

 public void displayAlligenedRoom() {
      System.out.printf("%-15d%-15d%-15b%-15d%-15d%n",RoomID,
                        numOfBeds,internet,floor,price);
   }
   
//GOES INTO THE GUEST CLASS
public void displayAlligenedGuest() {
      System.out.printf("%-15s%-15s%-15s%-15s%-15d%n",firstName,
                        lastName,address,phonenumber,guestID);
   }

//ROOM DISPLAY - REMEMBER TO PUT IN THE MENU TOO.

public void displayRoom() throws IOException {
      System.out.println("Room overveiw");
      
      System.out.printf("%-15s%-15s%-15s%-15s%-15s%n","RoomID",
                        "Beds","Wifi","Floor","Price per night");
      System.out.println("------------------------------------------------------------------------------------------------------------------------------");
      
      for (int i=0; i < roomList.size(); i++) {
         roomList.get(i).displayAlligenedRoom();
      }
   }
   
//GUEST DISPLAY - REMEMBER TO PUT IN THE MENU TOO. - REMEMBER MAX ID
public void displayGuest() throws IOException {
      System.out.println("Guest overveiw");
      
      System.out.printf("%-15s%-15s%-15s%-15s%-15s%n","First Name",
                        "Last Name","Adress","Phone number","Guest ID");
      System.out.println("------------------------------------------------------------------------------------------------------------------------------");
      
      for (int i=0; i < guestList.size(); i++) {
         guestList.get(i).displayAlligenedGuest();
      }
   }

//GUEST CREATE
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
//GUEST INPUT - REMEMBER TO PUT IT IN THE MENU TOO.
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

//IN THE MENU REMEMBER TO ADD THE CREATE WHICH IS ALREADY MADE.

//ROOM INPUT - REMEMBER TO PUT IT IN THE MENU TOO.

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







}

}
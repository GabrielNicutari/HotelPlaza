import java.util.*;
import java.io.*;
import java.text.*;
import java.time.format.DateTimeFormatter;

public class HotelPlaza {

   public static void main(String[] args) throws IOException, ParseException, InterruptedException {
      Menu menu = new Menu();
      menu.displayForAdministrator();
   }
}
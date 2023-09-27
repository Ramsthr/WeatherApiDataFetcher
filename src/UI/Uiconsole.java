package UI;

import Methods.Functions;
import org.json.JSONObject;

import java.util.Scanner;


public class Uiconsole {

    private final JSONObject weatherdata;

   Scanner scanner=new Scanner(System.in);



    public Uiconsole(JSONObject weatherdata) {
        this.weatherdata = weatherdata;
    }

    public void run() throws Exception {
        final Functions functions=new Functions(this.weatherdata);
       while (true) {
           System.out.println("\nOptions:");
           System.out.println("1. Get Temperature");
           System.out.println("2. Get Wind Speed");
           System.out.println("3. Get Pressure");
           System.out.println("0. Exit");

           System.out.print("Enter your choice: ");
           String option = scanner.nextLine();

           if (option.equals("0")) {
               System.out.println("Exiting the program.");
               break;
           }


           System.out.print("Enter date and time (YYYY-MM-DD HH:mm:ss): ");
           String dateTime = scanner.nextLine();
            functions.selectionofops(option);
           switch (option) {
               case "1":
                   double temperature = functions.methods(dateTime);
                   if (temperature != -1) {
                       System.out.println("Temperature at " + dateTime + ": " + temperature + " K");
                   } else {
                       System.out.println("Data not found for the given date and time.");
                   }
                   break;
               case "2":
                   double windSpeed = functions.methods(dateTime);
                   if (windSpeed != -1) {
                       System.out.println("Wind Speed at " + dateTime + ": " + windSpeed + " m/s");
                   } else {
                       System.out.println("Data not found for the given date and time.");
                   }
                   break;
               case "3":
                   double pressure = functions.methods(dateTime);
                   if (pressure != -1) {
                       System.out.println("Pressure at " + dateTime + ": " + pressure + " hPa");
                   } else {
                       System.out.println("Data not found for the given date and time.");
                   }
                   break;
               default:
                   System.out.println("Invalid option. Please try again.");
                   break;
           }
       }
   }
}

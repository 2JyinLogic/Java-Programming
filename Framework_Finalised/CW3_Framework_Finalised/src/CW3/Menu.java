//2034355
package CW3;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFrame;
/**
 *
 * @author ANDREW.ABEL
 */
public class Menu {

    // ArrayList for id
    List<Person> ids = new ArrayList<>();
    
    public void mainMenu(String fileName) {
        
        // Display a welcome message, get option and input
        
        // Do not Change
        
        System.out.println("\nCriminal Database Menu \n");
        System.out.println("Choose an option: ");
        System.out.println("1. Load Crime File");
        System.out.println("2. List all Criminals");
        System.out.println("3. Search for a Criminal");
        System.out.println("4. Generate a Wanted Poster");
        System.out.println("5. Generate Stats");
        System.out.println("6. Check Criminal for ID Fraud");
        System.out.println("7. Exit");

        // Get input from method
        int command = getIntInput();
        System.out.println("You entered " + command);
        switch (command) {
            case 1:
                System.out.println("Load Database");
                ids = loadFiles(fileName, ids);
                break;
            case 2:
                System.out.println("Listing all Criminals");
                listPeople(ids);
                break;
            case 3:
                System.out.println("Search for a Criminal with partial match");
                String input = getStringInput("Please input a partial match for the ID file");      
                searchIDs(ids, input);
                break;
            case 4:
                System.out.println("Generate a Wanted Poster");
                input = getStringInput("Please input a exact match for the ID code"); 
                generatePoster(ids, input);
                break;
            case 5:
                System.out.println("\nGenerate Stats");
                generateStats(ids);
                break;
            case 6:
                System.out.println("Check for Fraud");
                input = getStringInput("Please input a exact match for the ID code");                
                // Get a boolean of whether valid
                boolean valid = checkFraud(ids, input);
                if(valid){
                    System.out.println("Valid ID");
                } else {
                    System.out.println("Invalid ID or not found in system");
                }
                
                break;
            case 7:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Choice, please re-enter between 1 and 6");
            //  showMenu();
        }
        // Loop through menus again
        mainMenu(fileName);
    }
    
    
    private List<Person> loadFiles(String fileName, List<Person> ids) {
        // Method to handle loading of file and writing into array
        // Completed method, do not change
        
        System.out.println("Loading file " + fileName);
        ids = FileUtils.readFile(fileName);
        return ids;
    }
    
    // Generate Stats
    // This method is pre-completed
    private void generateStats(List<Person> ids) {
        // Method to generate stats
        // Completed method, do not change 
        System.out.println("Number of criminals in System: " + statsIdNumber(ids));
        System.out.println("Number of Nationalities in System: " + statsNatNumber(ids));
        System.out.println("Average age of people: " + statsAvgAge(ids));
        System.out.println("Average reward level: " + avgReward(ids));
    }
    

    
    public static int getIntInput() {
        // Method to check for input
        // Completed method, do not change
        
        Scanner kb = new Scanner(System.in);
        String input = kb.nextLine();

        int cmd = 6;
        try {
            cmd = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            // If not a number
            System.out.println("Invalid number option chosen");
            cmd = getIntInput();
        }

        return cmd;
    }
    
    public static String getStringInput(String inputMessage) {
        // Method to receive a message to display, and get a string input
        // from keyboard
        // Completed method, do not change
        
        Scanner kb = new Scanner(System.in);
        System.out.println(inputMessage);
        String input = kb.nextLine();
        return input;
    }
   
    

    
    private void listPeople(List<Person> ids) {
        // Display list of Peoople using toString method
        // Complete this method
        for(Person person: ids) {
            System.out.println(person.toString());
        }
       
    }

    
    private void searchIDs(List<Person> ids, String input) {
        // Method to search for people and display using toString
        // Search by full or partial match of first name, family name, nationality,
        // id or nickname, not case sensitive
        // Complete this method

        for(Person person : ids) {
            if(person.toString().toLowerCase().contains(input.toLowerCase())) {
                System.out.println(person.toString());
            }
        }
    }

    private void generatePoster(List<Person> ids, String input) {
        
        // Method will receive a String input and a list of persons.  Will
        // Look for an exact match with the id and if a match is found, will
        // Display a wanted poster
        // Complete this method
        JFrame frame = new JFrame();
        for(Person person : ids) {
            if(person.getIdCode().equals(input)) {
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(600,700);
                ImagePanel imagePanel = new ImagePanel(person,0,0,600,700 );
                frame.add(imagePanel);
                frame.setVisible(true);
            }
        }

    }
    
    private int statsIdNumber(List<Person> ids){
        // method to calculate the number of ids in the system
        // complete this method   
        // Return temporary value, change this\
        //罪犯数量
        int number = ids.size();
        return number;
    }
    
    private int statsNatNumber(List<Person> ids){
        // Method to return the number of nationalities present in the system
        // Complete this method 
       // Return temporary value, change this
        List<String> list = new ArrayList();
        for(Person person : ids) {
            if(!list.contains(person.getNationality())) {
                list.add(person.getNationality());
            }
        }
        return list.size();
    }
    
    private double statsAvgAge(List<Person> criminals){
        // Calculate age of every person in the system and return as double
        double age = 0;

        for(Person person: criminals) {
            age += person.getAgeinYears();
        }
        double avg = age/criminals.size();
        // Complete this method
        // Return temporary value, change this
        return avg;
    }
    
    private double avgReward(List<Person> ids){
        // Method to calculate average reward amount of all people in system
        // Complete this method
        double reward = 0;
        for(Person person : ids) {
            reward += person.getReward();
        }
        double avg = reward/ids.size();
        // Return temporary value, change this
        return avg;
    }

   public boolean checkFraud(List<Person> ids, String input) {
   boolean bol = false;
        for(Person person: ids) {
            if(person.getIdCode().equals(input)) {
                bol = true;
                if(input.length() != 8) {
                    bol  = false;
                }
                String first = input.substring(0,1);
                if(!first.equals("A") && !first.equals("B") && !first.equals("C")) {
                    bol = false;
                }
                String age = input.substring(2,3);
                String year = String.valueOf(person.getDob().getYear());
                if(!age.equals(year.substring(year.length() -1 ,year.length()))) {
                    bol =  false;
                }
                int one = Integer.valueOf(input.substring(input.length()-1, input.length())) + Integer.valueOf(input.substring(input.length()-2, input.length()-1));

                if(one != 7) {
                    bol =  false;
                }
            }
         
        }
        
        return bol;
    }

}

    
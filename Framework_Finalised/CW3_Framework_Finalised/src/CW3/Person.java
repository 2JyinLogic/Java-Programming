//2034355
package CW3;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


/**
 *
 * @author andrew.abel
 */
public class Person {

    // Instance variables
    private String firstName;
    private String familyName;
    private String nickname;
    private int reward;
    private String nationality;
    private String idCode;
    private String crimes;
    private LocalDate dob;
    private Image photo;


   
    public Person(String[] info)  {
        // Constructor to take a String array and assign it to instance variables
//person.set

this.firstName = info[0].trim();
this.familyName = info[1].trim();
this.nickname = info[2].trim();
this.reward = Integer.valueOf(info[3].trim());
this.nationality = info[4].trim();
this.idCode = info[5].trim();
this.crimes = info[6].trim();
this.dob = this.convertDateOfBirth( info[7].trim());
this.photo = this.readImage(info[8].trim());
}
    
    public Person(String line) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        String[] item = line.split(",");// CSV format files are comma-delimited files, which are split according to commas
        //person.set
        this.firstName = item[0].trim();
        this.familyName = item[1].trim();
        this.nickname = item[2].trim();
        this.reward = Integer.valueOf(item[3].trim());
        this.nationality = item[4].trim();
        this.idCode = item[5].trim();
        this.crimes = item[6].trim();
        this.dob = this.convertDateOfBirth( item[7].trim());
        this.photo = this.readImage(item[8].trim());
    }



    public BufferedImage readImage(String filename) {
        // Read an image from a file and return a Buffered image
        // Complete this method
        // Return temporary value, change this
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(new File(filename));
        } catch (IOException ex) {
                System.out.print("error");
        }
        return bufferedImage;
    }

   public LocalDate convertDateOfBirth(String inputDate) {
        // Take a date input String and convert to a local date
        // If the date is an incorrect value, assign a default value of 1/1/1991
        // Complete this method
        // Return temporary value, change this
        String[] data = inputDate.trim().split("/");
        try {
    LocalDate localDate = LocalDate.of(Integer.valueOf(data[2]),  Integer.valueOf(data[1]), Integer.valueOf(data[0]));
    return localDate;
    }catch (Exception e) {
            LocalDate localDate = LocalDate.of(1991,  1, 1);
            return localDate;
}
    }

    public int getAgeinYears() {
        // return the age of the person in years
        // Complete this method
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public String toString() {
        // Output method as String
        // Do not change!
        String out = "***\n" + getIdCode() + ", " + getFirstName() + " "
                + getFamilyName() + ", Reward: " + getReward() + ", " + getNationality()
                + ", " + getDob().toString() + ", " + getNickname() + ", " + getCrimes();

        return out;
    }

    // All getters are completed, do not change
    public String getFirstName() {

        return firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public int getReward() {
        return reward;
    }

    public String getNationality() {
        return nationality;
    }

    public String getIdCode() {
        return idCode;
    }

    public LocalDate getDob() {
        return dob;
    }

    public Image getPhoto() {
        return photo;
    }

    public String getNickname() {
        return nickname;
    }

    public String getCrimes() {
        return crimes;
    }

}

    

    
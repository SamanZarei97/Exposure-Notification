/**
 * Name: Saman Zarei
 * This file connects the ContactInfo class and Server class to
 * the students class and checks if the students are in the highRisk of
 * getting Covid-19 or not by the information.
 */

import java.util.ArrayList;
import java.util.Random;

/**
 * This class has designed for some purposes. Determining the locations
 * of the students, updating infected ids and also Determining that if the
 * students are in the high risk of covid and need to be in quarantine.
 * Also, this class is representing phones to handle ID exchanges and
 * representing students to handle movements and COVID-19 test status.
 * @author Saman Zarei
 */
public class Student{

  // representing value of id
  public int id;
  // representing the location
  public int location;
  // Determining if covid test is positive or not.
  public boolean covidPositive;
  // Determining if the students is in quarantine or not.
  public boolean inQuarantine;
  // ArrayList that stores all of the random IDs that the student has used
  public ArrayList<Integer> usedIds;
  // Stores the ContactInfo object that has sent to the students.
  public ArrayList<ContactInfo> contactHistory;
  // Represent of value number 3
  private static final int THREE = 3;

  /**
   * This is a constructor that initializes the variables of this
   * class.
   */
  public Student() {

    // initializing id to -1
    this.id = -1;
    // // initializing location to -1
    this.location = -1;
    // initializing covidPositive to false
    this.covidPositive = false;
    // initializing inQuarantine to false
    this.inQuarantine = false;
    // initializing usedIds to an empty ArrayList
    this.usedIds = new ArrayList<Integer>();
    // initializing contactHistory to an empty ArrayList
    this.contactHistory = new ArrayList<ContactInfo>();
  }

  /**
   * This Method has designed to update the locations by setting the new
   * locations if the new location is valid. The new location is valid if
   * it's 0 or positive number and inQuarantine is false.
   * @param newLocation an int variables which shows the newLocation number.
   * @return returns true if the value of newLocation is valid and the
   * inQuarantine is false. Otherwise it returns false.
   */
  public boolean setLocation(int newLocation){

    // if newLocation is valid and inQuarantine is false, update the location
    if(newLocation >= 0 && inQuarantine == false){

      // Updating the location by the value of newLocation.
      this.location = newLocation;
      return true;
    }

    else{
      return false;
    }
  }

  /**
   * This method has designed to update the id by a Random Integer
   * which its value is from 0 to Integer.MAX_VALUE-1 [0, Integer.MAX_VALUE)
   * and storing the id in the usedIds ArrayList for updating.
   */
  public void updateId(){

    // Generating Random class object
    Random ran = new Random();
    // updating the id by a random value.
    this.id = ran.nextInt(Integer.MAX_VALUE);
    // Adding the id in the usedIds ArrayList
    this.usedIds.add(id);
  }

  /**
   * This mathod has designed to add all the information from
   * ContactInfo class in the contactHistory ArrayList if the ContactInfo
   * is valid and it's not null.
   * @param info is the reference variable of ContactInfo class
   * that gives us access to the ContactInfo class.
   * @return returns true if the info from ContactInfo class is not null and
   * it's valid. Otherwise it returns false.
   */
  public boolean addContactInfo(ContactInfo info){

    // If the info is not null and it's valid add info to contactHistory
    if(info != null && info.isValid() == true){

      // Adding the info into the contactHistory
      this.contactHistory.add(info);
      return true;
    }

    else{
      return false;
    }
  }

  /**
   * This method has designed to update all usedIds by calling the
   * addInfectedIds method from server class if the server is not null and
   * and addInfectedIds method executes successfully.
   * @param server is the reference variable of Server class that gives us
   * access to the Server class.
   * @return returns true if server is not null and addInfectedIds method
   * executes successfully. Otherwise it returns false.
   */
  public boolean uploadAllUsedIds(Server server){

    // If server is not null
    if(server != null){

      // If updating usedIds by calling addInfectedIds method executes right
      if(server.addInfectedIds(this.usedIds) == true){
        return true;
      }

      else{
        return false;
      }
    }

    else{
      return false;
    }
  }

  /**
   * This methods has designed to update covidPositive & inQuarantine
   * to true. Also it uploads usedIds to server by calling uploadAllUsedIds
   * method and determine if uploadAllUsedIds method has executed successfully
   * or not.
   * @param server is the reference variable of Server class that gives us
   * access to the Server class.
   * return returns true if uploadAllUsedIds method has executed successfully.
   * Otherwise, it returns false.
   */
  public boolean testPositive(Server server){

    // Updating covidPositive to true
    this.covidPositive = true;
    // Updating inQuarantine to true
    this.inQuarantine = true;

    // if uploadAllUsedIds method executes successfully
    if(uploadAllUsedIds(server) == true){
      return true;
    }

    else{
      return false;
    }
  }

  /**
   * This methods has designed to Get all infected IDs from the server by
   * by calling getInfectedIds methods from the Server class, and checking
   * contactHistory against them. After that, it returns a sublist of
   * contactHistory where each ContactInfo has the required conditions.
   * They ArrayList list this class returns, contains the recent positive case
   * @param server is the reference variable of Server class that gives us
   * access to the Server class.
   * @param fromTime the starting time that students should check risk from
   * @return returns the ArrayList of ContactInfo type which contains the
   * recent positive contacts (infected ids) after compating the server
   * which got the value of getInfectedIds methods from Server class and
   * contactHistory ArrayList.
   *
   */
  public ArrayList<ContactInfo> getRecentPositiveContacts
  (Server server, int fromTime){

    // if server is null, it's invalid and return null.
    if(server == null){
      return null;
    }

    // ArrayList which hold the values of getInfectedIds method from server
    ArrayList<Integer> infect = server.getInfectedIds();

    // If infect is null, it's not valid and returns null.
    if(infect == null){
      return null;
    }

    // If the value of fromTime is Invalid, return null.
    if(fromTime < 0){
      return null;
    }

    // The ArrayList which returns as the sublist of contactHistory
    ArrayList<ContactInfo> recent = new ArrayList<ContactInfo>();

    /*
     * Toward the for loop. The sublist of contactHistory (recent) must
     * contain the ids from contactHistory that have these conditions:
     * 1- ids must be infected id
     * 2- Used from ContactInfo class must be false
     * 3- time must be equal or greater than fromTime
     */
    for (int i = 0; i < contactHistory.size(); i++){

      // If contactHistory ids are the infected one
      if(infect.contains(contactHistory.get(i).id)){

        // if used if false and time us equal or greater than fromTime
        if(contactHistory.get(i).used == false &&
        contactHistory.get(i).time >= fromTime){

          // Addiing the qualified ids from contactHistory to recent ArrayList
          recent.add(contactHistory.get(i));
        }
      }
    }

    return recent;
  }

  /**
   * This method has designed to determine if the students are in the highRisk
   * of getting infected to COVID-19 and needs to be quarantined.
   * @param server is the reference variable of Server class that gives us
   * access to the Server class.
   * @param fromTime the starting time that students should check risk from
   * @param quarantineChoice the boolean that determine if quarantineChoice
   * is true or false. (student needs to be quarantined or not)
   * @return returns 1 if the student assessed the highRisk and 0 if the
   * student is not assessed the highRisk and -1 if contact is null.
   */
  public int riskCheck(Server server, int fromTime, boolean quarantineChoice){

    // ArrayList which holds the value of getRecentPositiveContacts mwthod
    ArrayList<ContactInfo> contact =
    getRecentPositiveContacts(server,fromTime);
    // Determining if the student assessed the highRisk or not.
    int highRisk = 0;

    // if the contact is null, return -1
    if(contact == null){
      return -1;
    }

    /*
     * Toward the loop and checking if the student is in the highRisk.
     * The students is in the highRisk if one of these conditions is true
     * 1- distance is equal or less than 1
     * 2- the student has three or more recent contacts who tested positive
     * it means that if contact.size() is equal or greater than 3
     * If one of these conditions is true, used instance variable of
     * ContactInfo class must be set to true.
     * If the students are in the high risk, highRisk = 1
     */
    for(int i = 0; i < contact.size(); i++){

      // if distance is equal or less than 1
      if(contact.get(i).distance <= 1){

        // Set the used from ContactInfo class to true
        contact.get(i).used = true;
        // highRisk is 1
        highRisk = 1;
      }

      // If the number of positive contact is equal or greater than THREE
      if(contact.size() >= THREE) {

        //Set the used from ContactInfo class to true
        contact.get(i).used = true;
        // highRisk is 1
        highRisk = 1;
      }
    }

    /*
     * inQuarantine is true if the student is in the highRisk and needs
     * to be quarantined (quarantineChoice is true.)
     */
    if(highRisk == 1 && quarantineChoice == true){

      inQuarantine = true;
    }

    // If student is in the highRisk, returns 1
    if(highRisk == 1){
      return 1;
    }

    else{
      return 0;
    }
  }
}

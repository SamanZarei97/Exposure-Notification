/**
 * This file has designed to provide some valid information about each
 * student like their random IDs, distance between the students and the
 * time  they had contact to each other. These information will use to see
 * if any students are in the highRisk of geeting covid or not in the other
 * classes.
 */

 import java.util.ArrayList;
 import java.util.Random;

/**
 * This class has designed to hold all the information used for the exchange.
 * When two phones exchange information via Bluetooth,in addition to random
 * IDs, they will also store the distance and time of that contact. So this
 * class provides all the contact information like ID, distance and time.
 */
public class ContactInfo{

  // stores the (random) ID that is sent
  public int id;
  // stores the distance between the two students
  public int distance;
  // stores the time contact happens.
  public int time;
  // stores if contact information has been used to send notification
  public boolean used;

  /**
   * This is a constructor method and it will initialize all the values
   * of the class (id , distance, time, used).
   * @param id is the value of id for initializing this.id
   * @param distance is the value distance for initializing this.distance
   * @param time if the value of time for initializing this.time
   */
  public ContactInfo(int id, int distance, int time){

    // initializing this.id to value of id
    this.id = id;
    // initializing this.distance to value of distance
    this.distance = distance;
    // initializing this.time to value of time
    this.time = time;
    // initializing used to false
    this.used = false;
  }

  /**
   * This method has designed to determine if the value of id, distance
   * and time is valid or not. If the value of these variables is negative,
   * it's not valid. Otherwise if the value is 0 or positive number, it's
   * valid.
   * @return returns false if the value is invalid and true if it's valid.
   */
  public boolean isValid(){

    // If id is negative it's invalid and returns false
    if(this.id < 0 ){
      return false;
    }

    // If distance is negative it's invalid and returns false
    else if (this.distance < 0){
      return false;
    }

    // // If time is negative it's invalid and returns false
    else if (this.time < 0){
      return false;
    }

    else{
      return true;
    }
  }
}

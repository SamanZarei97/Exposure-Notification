/**
 * Name: Saman Zarei
 * This file has designed to check and find the infected id.
 * This file collects all the infected IDs and stores them to know
 * which IDs are infected and by doing this, we recognize students who are
 * infected and who are in the highRisk of geeting covid.
 */

import java.util.ArrayList;
import java.util.Random;

/**
 * This class has designed to represent the server that stores all recent
 * IDs from COVID-19 positive users. The server will only support two
 * operations: adding new infected IDs and getting all stored infected IDs.
 * @author Saman Zarei
 */
public class Server{

  // ArrayList that stores all infected ID
  public ArrayList<Integer> infectedIds;

  /**
   * This is a constructor that initializes infected ArrayList to an emnpty
   * ArrayList for the beginning.
   */
  public Server(){

    // initializing ArrayList infectedIds to an empty ArrayList.
    this.infectedIds = new ArrayList<Integer>();
  }

  /**
   * This method has designed to add all ids into the infectedIds in order
   * they appear respectively and return true to indicate it was successful
   * and return false if ids is null.
   * @param ids the ArrayList which contains all the ids we need to add them
   * all into the infectedIds ArrayList.
   * @return return true if adding ids to infectedIds was successfully done
   * and return false if ids is null;
   */
  public boolean addInfectedIds(ArrayList<Integer> ids){

    //if ids is null, it's invalid and returns false.
    if(ids == null){
      return false;
    }

    else{
      // Adding all ids into the infectedIds
      this.infectedIds.addAll(ids);
      return true;
    }
  }

  /**
   * This method has designed to make a deep copy of infectedIds ArrayList
   * by creating an empty ArrayList and copy everything in it and return it.
   * @return returns an ArrayList which is the deep copy of infectedIds
   * ArrayList.
   */
  public ArrayList<Integer> getInfectedIds(){

    // An ArrayList which will be a deep copy of infectedIds ArrayList.
    ArrayList<Integer> copy = new ArrayList<Integer>();

    /*
     * Toward the for loop to make a deep copy of infectedIds ArrayList into
     * the copy ArrayList to return it.
     */
    for(int i = 0; i < infectedIds.size(); i++){

      // adding all the elements of infectedIds ArrayList to copy ArrayList
      copy.add(this.infectedIds.get(i));
    }

    return copy;
  }
}

import java.util.*;
import java.io.*;

/**
 * This class holds an arraylist of Supplier objects taken from an input txt file. The user can search for an object in the list by ID.
 */
public class SupDirectory {
    
    private ArrayList <Supplier> suppArrayList = new ArrayList<>();

    //runs load data - populates list
    public SupDirectory() throws FileNotFoundException {
        loadData();
    }

    /**
     * This method loads data from a file called Supplier.txt and populates an array list with Supplier objects
     * @throws FileNotFoundException
     */
    private void loadData() throws FileNotFoundException {

        String supId;
        String companyName;
        String supAddress;
        String salesContact;

        //declaring a file
        File inFile = new File ("resources/suppliers.txt");
        //calling info from the file
        Scanner in = new Scanner (inFile);
        
        while (in.hasNext()) {
            in.useDelimiter(";");
            supId = in.next();
            companyName = in.next();
            supAddress = in.next();
            salesContact = in.nextLine();

            //creating new supplier
            Supplier newSup = new Supplier(supId, companyName, supAddress, salesContact);

            //adding new supplier to the arraylist
            suppArrayList.add(newSup);
        }
        in.close();
    }
    
    /**
     * Takes in a supplier ID as a parameter (this ID may be taken from a tool object) 
     * This method then searches the arraylist of Suppliers until it finds one with a matching supplier ID
     * @param id - the supplier id. 
     * @return the Supplier object who's ID matches that of the one taken in as a parameter. Returns null if match not found. 
     */
    public Supplier searchSupId(String id) {
        Supplier supFound = null;

        for (Supplier tempSup : suppArrayList) {
            if (tempSup.getId().equals(id)) {
                supFound = tempSup;
                break;
            }
        }
        return supFound;
    }

}
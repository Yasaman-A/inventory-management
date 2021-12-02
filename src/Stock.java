import java.util.Scanner;
import java.util.*;
import java.io.*;

/**
 * The Stock class store the quantity of the items in the inventory
 */
public class Stock {

    // Declare variables
    private ArrayList<Tool> items = new ArrayList<Tool>();
    private Scanner kb = new Scanner(System.in);

    private SupDirectory supDir;
    private int id;
    private String toolName;
    private int quantity;
    private double price;
    private String supplierId;
    
    
    //Constructor
    public Stock (SupDirectory supDir) throws IOException{
        this.supDir = supDir;
        loadItems();
    }

    /**
     * Method that loads the inventory using the items.txt file which stores the inventory information
     * @throws FileNotFoundException
     */
    public void loadItems() throws FileNotFoundException {
        File inFile;
        Scanner in;

        inFile = new File("resources/items.txt");
        in = new Scanner(inFile);

        // Load items.txt
        while (in.hasNext()) {
            in.useDelimiter(";");
            id = in.nextInt();
            toolName = in.next();
            quantity = in.nextInt();
            price = in.nextDouble();
            supplierId = in.nextLine();
            supplierId = supplierId.replace(";", "");

            // Parametized constructor
            Tool item = new Tool(id, toolName, quantity, price, supplierId);
            items.add(item);

            // test
            // System.out.println(id + " " + toolName + " " + quantity + " " + price + " " + supplierId);
        }

        in.close();
    }

    /**
     * Method that allows the user to search the inventory for tools by tool name and tool ID
     * @param toolName
     * @param toolId
     * @return returnInventory
     */
    public Tool searchInventory(String toolName, int toolId) {

        Tool returnInventory = new Tool();

        for (Tool inventory : items) {
            if (toolName.equals(inventory.getToolName()) && toolId == inventory.getId()) {
                returnInventory = inventory;
                break;
            }
        }
        return returnInventory;
    }

    /**
     * Method that prints the inventory information that was searched by the user in the searchInventory() method
     * @param toolName
     * @param toolId
     */
    public void searchPrint(String toolName, int toolId) {


        for (Tool inventory : items) {
            if (toolName.equals(inventory.getToolName()) && toolId == inventory.getId()) {
                
                System.out.println("\nHere is the full information for this tool:");
                System.out.println("\nid: " + inventory.getId() + "  " + "name: " + inventory.getToolName() + "  " + "quantity: " + inventory.getQuantity() + "  " + "price: $" + inventory.getPrice() + "  " + "supplier_ID: " + inventory.getSupplierId());

                break;
            }
        }
    }

    /**
     * Method that allows the user to add a tool in the inventory list.
     * @param id
     * @param toolName
     * @param quantity
     * @param price
     * @param supplierId
     * @throws IOException
     */
    public void addTool (int id, String toolName, int quantity, double price, String supplierId){
        
    	Tool newTool = new Tool (id, toolName, quantity, price, supplierId);

        //Add new tool into ArrayList
        items.add(newTool);

        
    }
    


    /**
     * Method that allows the user to remove a tool in the inventory list.
     * @param toolName
     * @param toolId
     */
    public void removeTool(String toolName, int toolId) {

        //Remove the specific tool from the ArrayList
        Tool toolToBeRemoved = searchInventory(toolName, toolId);

        items.remove(toolToBeRemoved);
        
        System.out.println("\nThe tool has been removed from stock!");
    }

    /**
     * Method that prints the list of the current inventory of each tool.
     */
    public void printInventory(){
        System.out.println("------------------------------");
        System.out.println("Current inventory of each Tool");
        System.out.println("Tool \t\t" + "     Quantity");

        for (Tool toolItem: items){

            if ((toolItem.getToolName()).length() <= 7){
                System.out.println(toolItem.getToolName() + "\t\t\t" + toolItem.getQuantity());
            }

            else{
                System.out.println(toolItem.getToolName() + "\t\t" + toolItem.getQuantity());
            }
        }

        System.out.println("------------------------------");
    }

    /**
     * Method that checks the quantity of item in each stock. 
     * If a quantity of an item goes below 40, this method would generate a new order line for that item.
     * @throws FileNotFoundException
     */
    public void checkQuantity() throws IOException{

        for(Tool checkToolQ : items){
            
            if (checkToolQ.getQuantity() < 40){

                System.out.println("\nWarning! Low tool stock! Attempting to generate Order...");
                String supplierID = checkToolQ.getSupplierId();
                Supplier foundSup = supDir.searchSupId(supplierID);

                int orderAmt = (50 - checkToolQ.getQuantity());

                new Order (foundSup, orderAmt, checkToolQ.getToolName());
            }
        }
    }
    
    public void saveStock(String fileName) throws IOException {

//      FileWriter newWrite = new FileWriter("resources/items.txt");

      FileWriter fr = new FileWriter(fileName, true);
      BufferedWriter br = new BufferedWriter(fr);

      for (int i = 0; i< items.size(); i++) {
    	  Tool item = items.get(i);
    	  br.write(item.getId() + ";" + item.getToolName() + ";" + item.getQuantity() + ";" + item.getPrice() + ";" + item.getSupplierId());
          br.write("\n");
      }

      br.close();
      fr.close();
    }

}
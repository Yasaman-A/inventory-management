
import java.io.IOException;
import java.util.Scanner;

public class Menu {

    /**
     * Main run method, continously loops until user decides to quit
     * @throws IOException
     */
    public void run() throws IOException{

        //Declared Variables
        Scanner kb = new Scanner (System.in);
        String input;
        char choice;
        boolean stopLoop = false;

        //Load classes & Files
        //Creates new SupDirectory object
        SupDirectory dir = new SupDirectory();

        //SupDirectory object is passed into Stock in order to load suppliers & use its methods
        Stock stock = new Stock(dir);
        stock.checkQuantity();

        //Main menu
        System.out.println("\n");
        System.out.println("----------------------------------------------");
        System.out.println("Welcome to our retail shop interface!");
        System.out.println("Please choose from one of the options below:");
        showMenu();

        input = kb.next();
        choice = input.toUpperCase().charAt(0);

        //Loop for user choices
        while (!stopLoop){

            switch(choice){
                
                case('I'):
                    stock.printInventory();
                    break;

                case('A'):
                    
                    Scanner akb = new Scanner (System.in);

                    int id;
                    String toolName;
                    int quantity;
                    double price;
                    String supplierId;

                    System.out.println("\n");

                    System.out.println("Please enter a 4-digit ID for the tool:");
                    id = akb.nextInt();
                    akb.nextLine();

                    System.out.println("Please enter the tool name:");
                    toolName = akb.nextLine();

                    System.out.println("Please enter the quantity of this new tool as an integer:");
                    quantity = akb.nextInt();

                    System.out.println("Please enter the price of this new tool:");
                    price = akb.nextDouble();

                    System.out.println("Please enter the 4-digit supplier ID of this new tool:");
                    supplierId = akb.next();

                    stock.addTool(id, toolName, quantity, price, supplierId);

                    System.out.println("\nThe tool has been succesfully added into stock!");
                    break;

                case('R'):
                    
                    Scanner rkb = new Scanner (System.in);

                    String rTool;
                    int rID;

                    System.out.println("\n");
                    System.out.println("Please enter the tool name AND the tool ID to remove it from stock:");

                    System.out.println("Enter the tool name:");
                    rTool = rkb.nextLine();

                    System.out.println("Enter the tool id:");
                    rID = rkb.nextInt();

                    stock.removeTool(rTool, rID);

                    break;

                case('S'):

                    Scanner skb = new Scanner (System.in);

                    String sName;
                    int sID;

                    System.out.println("\n");
                    System.out.println("Please enter the tool name to search:");
                    sName = skb.nextLine();
                    System.out.println("Please enter the tool id to search:");
                    sID = skb.nextInt();

                    stock.searchPrint(sName, sID);

                    break;

                case('Q'):
//                	stock.saveStock("resources/items.txt");
                	
                    System.out.println("\nThank you for using our system. Goodbye!");
                
                    stopLoop = true;
                    break;
                
                default:
                    System.out.println("Invalid choice! Please enter one of the following:");
            }

            if (!stopLoop){
                showMenu();
                input = kb.next();
                choice = input.toUpperCase().charAt(0);
            }
        }

    }

    /**
     * Method to show printouts
     */
    public static void showMenu(){

        System.out.println("\nMENU:\n");
        System.out.println("I - Show store inventory/stock");
        System.out.println("A - Add a new tool into stock");
        System.out.println("R - Remove a tool into stock");
        System.out.println("S - Search inventory/stock for an item");
        System.out.println("Q - Quit menu and save changes");

    }
}

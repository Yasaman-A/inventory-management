import java.time.format.DateTimeFormatter;
import java.io.PrintWriter;
import java.time.LocalDateTime;  
import java.util.concurrent.ThreadLocalRandom;
import java.util.*;
import java.io.*;

/**
 * This class is meant to create an order for items that are low in quantity. This class will retrieve 
 * information that is necessary from other classes to create appropriate format.
 * An order file (out.txt) will then be created that owner can view.
 * 
 * 
 */

public class Order {

    String itDesc;
    int amtOrder;
    Supplier sup;
    /**
     * Constructor method for Order class 
     * @param sup - Supplier type
     * @param amtOrder - how much order is needed
     * @param itDesc - description of item
     * @throws IOException
     */
    public Order(Supplier sup, int amtOrder, String itDesc)throws IOException{

        this.sup = sup;
        this.amtOrder = amtOrder;
        this.itDesc = itDesc;
        printOrder();
    }

    /**
     * retrieves the current date
     * @return current date 
     */
    public String getDate(){

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMMM dd yyyy");
        LocalDateTime now = LocalDateTime.now();
        return (dtf.format(now));
    }

    /**
     * Using a thread local random to generate a random 5 digit order
     * thread local random is beneficial for multi threaded environment
     * @return
     */
    public int getOrderNum(){
       int randomId = ThreadLocalRandom.current().nextInt(11111, 99999 +1);
       return randomId;
    }

    /**
     * creates an output file with the required format 
     * @throws FileNotFoundException
     */
    public void printOrder() throws IOException{
        
        FileWriter fr = new FileWriter("orders.txt", true);
        BufferedWriter br = new BufferedWriter(fr);

        br.write("******************************");
        br.write("\n");
        br.write(String.format("Order I.D:         %d\n" , getOrderNum()));
        br.write(String.format("Date Ordered:    %s\n" , getDate()));
        br.write("\n");
        br.write(String.format("Item Description:  %s\n" , itDesc)); 
        br.write(String.format("Amount Ordered:    %d\n" , amtOrder));
        br.write(String.format("Supplier:          %s\n" , sup.getCompanyName()));

        br.close();
        fr.close();

        System.out.println("A copy of your file has been created - please check 'orders.txt' to view your order(s) ");
    }
}
/**
 * Tool class. Holds tool id, tool name, quantity, price, and supplier id for tool objects.
 */
public class Tool {
    
    private int id;
    private String toolName;
    private int quantity;
    private double price;
    private String supplierId;

    /**
     * Constructor method
     */
    public Tool (int id, String toolName, int quantity, double price, String supplierId) {
        this.id = id;
        this.toolName = toolName;
        this.quantity = quantity;
        this.price = price;
        this.supplierId = supplierId;
    }

    public Tool (){
        
    }

    /**
    * Sets id
    * @param id of tool
    */
    public void setId (int id) {
        this.id = id;
    }
    /**
    * Sets tool name
    * @param toolName name or description of tool
    */
    public void setToolName (String toolName) {
        this.toolName = toolName;
    }
    /**
    * Sets quantity of tool
    * @param quantity of tool
    */
    public void setQuantity (int quantity) {
        this.quantity = quantity;
    }
    /**
    * Sets price
    * @param price of tool
    */
    public void setPrice (double price) {
        this.price = price;
    }
    /**
    * Sets supplier ID
    * @param supplierId of tool
    */
    public void setSupplierId (String supplierId) {
        this.supplierId = supplierId;
    }

    /**
     * get id
     * @return tool id
     */
    public int getId() {
        return id;
    }
    /**
     * get tool name
     * @return tool name
     */
    public String getToolName() {
        return toolName;
    }
    /**
     * get quantity
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }
    /**
     * get price of tool
     * @return price
     */
    public double getPrice() {
        return price;
    }
    /**
     * get supplier ID
     * @return supplier ID
     */
    public String getSupplierId() {
        return supplierId;
    }
        
}
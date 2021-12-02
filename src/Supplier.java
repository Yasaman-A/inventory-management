/**
 * This class allows you to create  Supplier object with all the required variables
 */
public class Supplier {
    
    //Variables
    private String sup_id;
    private String compName;
    private String addy;
    private String sales_contact;

    /**
     * A simple parametrized constructor that takes in values for the supplier object
     * 
     * @param sup_id    ID of the supplied
     * @param compName  Name of the supplier
     * @param addy  Address of the supplier
     * @param sales_contact Name of the representative of the supplier
     */
    public Supplier(String sup_id, String compName, String addy, String sales_contact ){

        this.sup_id = sup_id;
        this.compName = compName;
        this.addy = addy;
        this.sales_contact = sales_contact;

    }

    /**
     * Sets supplier ID
     * @param sup_id
     */
    public void setId(String sup_id){
        this.sup_id = sup_id;
    }

    /**
     * Sets the name of the company
     * @param compName
     */
    public void setCompanyName(String compName){
        this.compName = compName;
    }

    /**
     * Sets the address of the company
     * @param addy
     */
    public void setAddy(String addy){
        this.addy = addy;
    }

    /**
     * Sets the sales contact (name) 
     */
    public void setSalesContact(String sales_contact){
        this.sales_contact = sales_contact;
    }

    /**
     * Gets the ID of the company
     * @return
     */
    public String getId(){
        return this.sup_id;
    }

    /**
     * Gets the name of the company
     * @return
     */
    public String getCompanyName(){
        return this.compName;
    }

    /**
     * Gets the address of the company
     * @return
     */
    public String getAddy(){
        return this.addy;
    }

    /**
     * Gets the name of the sales contact of the company
     * @return
     */
    public String getSalesContact(){
        return this.sales_contact;
    }

}
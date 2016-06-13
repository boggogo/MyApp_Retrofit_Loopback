package georgikoemdzhiev.myappretrofit;

/**
 * Created by koemdzhiev on 13/06/16.
 */
public class Order {
    private String name = "";
    private int customerID = 0;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    @Override
    public String toString() {
        return "Order: " + name + " " + customerID;
    }
}

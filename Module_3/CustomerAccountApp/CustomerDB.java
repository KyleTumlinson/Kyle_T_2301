package CustomerAccountApp;
/*Liang, Y.D. (2019).  Introduction to Java Programming and Data Structures: 
Comprehensive Version (12th ed.).  Pearson Education, Inc. */

public class CustomerDB {
    // retrieve the customer based on the integer passed in
    public static  Customer getCustomer(Integer id)
    {
        Customer returnCust;
        if(id.equals(1007))
        {
            returnCust = new Customer("Kyle", "123 argile lane", "garland", "14235");
        }
        else if(id.equals(1008))
        {
            returnCust = new Customer("Josh", "321 magnolia way", "dallas", "45424");
        }
        else if(id.equals(1009))
        {
            returnCust = new Customer("Marco", "4215 omaha park", "Oklahoma City", "780134");
        }
        else
        {
            // if there is not a matching customer return the dummy customer
            returnCust = new Customer();
        }
        return returnCust;
    }
}

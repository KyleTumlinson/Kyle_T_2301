package CustomerAccountApp;
/*Liang, Y.D. (2019).  Introduction to Java Programming and Data Structures: 
Comprehensive Version (12th ed.).  Pearson Education, Inc. */

public class Customer {
    // store the customer information: name, address, city, and zip as private strings
    private String name;
    private String address;
    private String city;
    private String zip;

    // this is a no argument constructor for a dummy customer
    Customer()
    {
        this.name = "dummy_customer";
        this.address = "123 dummy_address";
        this.city = "dummy_city";
        this.zip = "12345";
    }

    // this is an argument constructor for a more realistic customer
    Customer(String name, String address, String city, String zip)
    {
        this.name = name;
        this.address = address;
        this.city = city;
        this.zip = zip;
    }

    // change the toString method to output customer data rather than a memory location
    @Override
    public String toString()
    {
        return "  Name: " + this.name + "\n  Address: " + this.address + "\n  City: " + this.city + "\n  Zip: " + this.zip;
    }

    // below are the getters for private variables
    public String getName()
    {
        return this.name;
    }
    public String getAddress()
    {
        return this.address;
    }
    public String getCity()
    {
        return this.city;
    }
    public String getZip()
    {
        return this.zip;
    }

    // below are the setters for private variables
    public void setName(String name)
    {
        this.name = name;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    public void setCity(String city)
    {
        this.city = city;
    }
    public void setZip(String zip)
    {
        this.zip = zip;
    }
}

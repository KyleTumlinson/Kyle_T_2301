package Module_4.TumlinsonBowlingShopApp;

public class Product {
    private String code;
    private String description;
    private double price;
    
    // the no args constructor is for product is below
    Product()
    {
        code = "";
        description = "";
        price = 0.0;
    }

    // the setters and getters are below
    public String getCode()
    {
        return this.code;
    }
    public void setCode(String code)
    {
        this.code = code;
    }
    
    public String getDescription()
    {
        return this.description;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }

    public double getPrice()
    {
        return this.price;
    }
    public void setPrice(double price)
    {
        this.price = price;
    }

    // override toString to output the stats of the product on separate lines
    @Override
    public String toString()
    {
        return String.format("  Product Code: %s\n  Description:  %s\n  Price: $%,6.2f", this.code, this.description, this.price);
    }
}

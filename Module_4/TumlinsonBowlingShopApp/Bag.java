package Module_4.TumlinsonBowlingShopApp;

public class Bag extends Product {
    private String type;

    // the no arg constructor for bag is below, implicit call to super()
    Bag()
    {
        this.type = "";
    }

    // the getter and setter are below
    public String getType()
    {
        return this.type;
    }
    public void setType(String type)
    {
        this.type = type;
    }

    // override tostring to also show bag type
    @Override
    public String toString() {
        return super.toString() + "\n  Bag Type: ";
    }
}

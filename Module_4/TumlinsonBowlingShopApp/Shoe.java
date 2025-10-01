package Module_4.TumlinsonBowlingShopApp;

public class Shoe extends Product {
    private double size;

    // the no arg constructor for Shoe, implicitly calls super()
    Shoe()
    {
        size = 0;
    }

    // getters and setters for shoe are below
    public double getSize()
    {
        return this.size;
    }
    public void setSize(double size)
    {
        this.size = size;
    }

    // override toString to also put the shoe size
    @Override
    public String toString() {
        return super.toString() + "\n  Shoe Size: " + this.size;
    }
}

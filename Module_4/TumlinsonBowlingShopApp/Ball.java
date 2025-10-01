package Module_4.TumlinsonBowlingShopApp;

public class Ball extends Product{
    private String color;

    // the no args constructor for ball is below, implicit call to super()
    Ball()
    {
        color = "";
    }

    // get and set method below
    public String getColor()
    {
        return this.color;
    }
    public void setColor(String color)
    {
        this.color = color;
    }

    // override tostring to also show the ball color
    @Override
    public String toString() {
        return super.toString() + "\n  Ball Color: " + color;
    }
}

public class Fan {
    public static final int STOPPED = 0;
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;
    private int speed;
    private boolean isOn;
    private double radius;
    private String color;

    public Fan()
    {
        speed = STOPPED;
        isOn = false;
        radius = 6;
        color = "white"; 
    }

    public Fan(int speed, boolean isOn, double radius, String color)
    {
        this.speed = speed;
        this.isOn = isOn;
        this.radius = radius;
        this.color = color;
    }

    @Override
    public String toString()
    {
        if(isOn)
        {
            return "Fan Speed: " + speed + " Color: " + color + " Radius: " + radius;
        }
        return "Color: " + color + " Radius: " + radius + " the fan is off.";
    }
    

    public void setSpeed(int speed)
    {
        this.speed = speed;
    }
    public void setOn(boolean isOn)
    {
        this.isOn = isOn;
    }
    public void setRadius(double radius)
    {
        this.radius = radius;
    }
    public void setColor(String color)
    {
        this.color = color;
    }
    public int getSpeed()
    {
        return speed;
    }
    public boolean getOn()
    {
        return isOn;
    }
    public double getRadius()
    {
        return radius;
    }
    public String getColor()
    {
        return color;
    }

}

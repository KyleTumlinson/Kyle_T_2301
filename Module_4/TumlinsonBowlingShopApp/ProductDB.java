package Module_4.TumlinsonBowlingShopApp;

public class ProductDB {
    public static GenericQueue<Product> getProducts(String code)
    { 
        // ball creation
        if(code.equalsIgnoreCase("b"))
        {
            GenericQueue<Product> balls = new GenericQueue<>();
            String[] colors = {"Black and Red", "Red and Blue", "Orange and White", "Purple and Red", "All Purple"};
            String[] descriptions = {"Black Widow 2.0", "The Dead Tide", "The Orange Soda", "The Monster's Eye", "The Purple People Eater"};
            for(int ballIndex = 0; ballIndex < 5; ballIndex++)
            {
                Ball tempBall = new Ball();
                tempBall.setCode("B" + (ballIndex + 1) + "00");
                tempBall.setDescription(descriptions[ballIndex]);
                tempBall.setPrice((ballIndex + 1) * 55);
                tempBall.setColor(colors[ballIndex]);
                balls.enqueue(tempBall);
                tempBall = null;
            }
            return balls;
        }
        // shoe creation
        else if(code.equalsIgnoreCase("s")) // 5
        {
            GenericQueue<Product> shoes = new GenericQueue<>();
            // shoes based on actor heights
            String[] descriptions = {"Verne Troyers", "Chris Hearts", "Owen Wilsons", "Bill Murrays", "Clint Eastwoods"};
            for(int shoeIndex = 0; shoeIndex < 5; shoeIndex++)
            {
                Shoe tempShoe = new Shoe();
                tempShoe.setCode("S" + (shoeIndex + 1) + "00");
                tempShoe.setDescription(descriptions[shoeIndex]);
                tempShoe.setPrice(shoeIndex * 30);
                tempShoe.setSize(10.0 + (shoeIndex + 1) / 2);
                shoes.enqueue(tempShoe);
                tempShoe = null;
            }
            return shoes;
        }
        // ball bag creation
        else if(code.equalsIgnoreCase("a")) // 3
        {
            GenericQueue<Product> bags = new GenericQueue<>();
            for(int bagIndex = 0; bagIndex < 3; bagIndex++)
            {
                Bag tempBag = new Bag();
                tempBag.setCode("A" + (bagIndex + 1) + "00");
                tempBag.setDescription("Bag for " + (bagIndex + 1) +  " balls");
                tempBag.setPrice((bagIndex + 1) * 25);
                tempBag.setType(Integer.toString(bagIndex));
                bags.enqueue(tempBag);
                tempBag = null;
            }
            return bags;
        }
        return new GenericQueue<Product>();
    }    
}

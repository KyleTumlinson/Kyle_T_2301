public class TestFanApp {
    public static void main(String[] args)
    {
        Fan testFan1 = new Fan();
        Fan testFan2 = new Fan(Fan.FAST, true, 8, "blue");

        System.out.println(testFan1.toString());
        System.out.println(testFan2.toString());

    }
}

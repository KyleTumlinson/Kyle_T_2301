public class FinanceCalculator {
    private static int MONTHS_IN_YEAR = 12;

    public static double calculateFutureValue(double monthlyPayment, double rate, int years)
    {
        int months = years * MONTHS_IN_YEAR;
        System.out.println(months);
        double interestRate =  (1 + rate / 100);
        System.out.println(interestRate);
        double presentValue = monthlyPayment * months;
        System.out.println(presentValue);
        System.out.println(presentValue * (Math.pow(interestRate, months)));
        return presentValue * (Math.pow(interestRate, months));
    }
}

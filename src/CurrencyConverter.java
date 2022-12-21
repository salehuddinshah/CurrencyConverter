import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyConversion cc = new CurrencyConversion(scanner);

        System.out.println("Welcome to the currency converter!");
        do {
            int fromCurrency = cc.getCurrencyFrom();
            double amount = cc.getAmountToConvert();
            double[] conversion = cc.convert(fromCurrency, amount);
            cc.printExchangedCurrency(fromCurrency, amount, conversion);

            System.out.println("\nWould you like to do another conversion? " +
                               "\nY: Yes \t Any other key: No");
        } while (scanner.next().equalsIgnoreCase("y"));
    }
}
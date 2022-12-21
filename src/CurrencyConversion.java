import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

class CurrencyConversion {
    Scanner scanner;
    public CurrencyConversion(Scanner scanner){
        this.scanner = scanner;
    }

    public void printExchangedCurrency(int fromCurrency, double amount, double[] exchanged) {
        DecimalFormat f = new DecimalFormat("0.00");
        for (int i = 0; i < exchanged.length; i++) {
            if (exchanged[i] >= 0) {
                System.out.println(f.format(amount) + " " + getCurrencyName(fromCurrency - 1) + " = " + f.format(exchanged[i]) + " " + getCurrencyName(i));
            }
        }
    }

    public void printCurrencyList() {
        System.out.println("[1]USD (US Dollar)\t[2]SGD (Singaporean Dollar)\t[3]MYR (Malaysian Ringgit)\t[4]EUR (European Euro)\t[5]GBP (British Pound)");
    }

    public String getCurrencyName(int fromCurrency) {
        HashMap<Integer, String> currencyCodes = new HashMap<>();
        currencyCodes.put(0, "USD");
        currencyCodes.put(1, "SGD");
        currencyCodes.put(2, "MYR");
        currencyCodes.put(3, "EUR");
        currencyCodes.put(4, "GBP");
        return currencyCodes.get(fromCurrency);
    }

    public double getAmountToConvert() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Amount wish to convert? :");
        double input = scanner.nextDouble();
        while (input < 0) {
            System.out.println("ERROR: Please insert a positive value: ");
            input = scanner.nextDouble();
        }
        return input;
    }

    public int getCurrencyFrom() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select a currency to convert from:");
        printCurrencyList();
        int input = scanner.nextInt();
        while (input < 1 || input > 5) {
            System.out.println("ERROR: Please insert a valid number from the list: ");
            input = scanner.nextInt();
        }
        return input;
    }

    public double[] convert(int fromCurrency, double amount) {
        double dollar, sdollar, ringgit, euro, pound;
        double[] toCurrency = new double[5];

        switch (fromCurrency) {
            case 1: //Dollar conversion
                dollar = -1;
                sdollar = amount * 1.3526;
                ringgit = amount * 4.3968;
                euro = amount * 0.9505;
                pound = amount * 0.8167;
                toCurrency = new double[]{dollar, sdollar, ringgit, euro, pound};
                break;
            case 2:  // SDollar conversion
                dollar = amount * 0.7393;
                sdollar = -1;
                ringgit = amount * 3.2506;
                euro = amount * 0.7027;
                pound = amount * 0.6038;
                toCurrency = new double[]{dollar, sdollar, ringgit, euro, pound};
                break;
            case 3:  // Ringgit conversion
                dollar = amount * 0.2274;
                sdollar = amount * 0.3076;
                ringgit = -1;
                euro = amount * 0.2162;
                pound = amount * 0.1857;
                toCurrency = new double[]{dollar, sdollar, ringgit, euro, pound};
                break;
            case 4:  // Euro conversion
                dollar = amount * 1.0522;
                sdollar = amount * 1.4232;
                ringgit = amount * 4.6262;
                euro = -1;
                pound = amount * 0.8593;
                toCurrency = new double[]{dollar, sdollar, ringgit, euro, pound};
                break;
            case 5:  // Pound conversion
                dollar = amount * 1.2245;
                sdollar = amount * 1.6562;
                ringgit = amount * 5.3840;
                euro = amount * 1.1638;
                pound = -1;
                toCurrency = new double[]{dollar, sdollar, ringgit, euro, pound};
                break;
        }
        return toCurrency;
    }


}
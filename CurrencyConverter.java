import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Supported currencies
        String[] currencies = {"USD", "INR", "EUR", "GBP", "JPY"};

        // Exchange rates relative to USD
        double usdToInr = 83.20;
        double usdToEur = 0.93;
        double usdToGbp = 0.81;
        double usdToJpy = 150.45;

        System.out.println("===== CURRENCY CONVERTER =====");
        System.out.println("Supported currencies: USD, INR, EUR, GBP, JPY");

        // Input base currency
        System.out.print("Enter base currency: ");
        String base = sc.next().trim().toUpperCase();

        // Input target currency
        System.out.print("Enter target currency: ");
        String target = sc.next().trim().toUpperCase();

        // Check if both currencies are supported
        if (!isSupported(base, currencies)) {
            System.out.println("Unsupported base currency!");
            sc.close();
            return;
        }

        if (!isSupported(target, currencies)) {
            System.out.println("Unsupported target currency!");
            sc.close();
            return;
        }

        // Input amount with error handling
        System.out.print("Enter amount to convert: ");
        double amount;
        try {
            amount = sc.nextDouble();
            if (amount < 0) {
                System.out.println("Amount cannot be negative!");
                sc.close();
                return;
            }
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter a numeric value for the amount.");
            sc.close();
            return;
        }

        double usdAmount = 0.0;
        double convertedAmount = 0.0;

        // Convert base currency to USD
        switch (base) {
            case "USD": usdAmount = amount; break;
            case "INR": usdAmount = amount / usdToInr; break;
            case "EUR": usdAmount = amount / usdToEur; break;
            case "GBP": usdAmount = amount / usdToGbp; break;
            case "JPY": usdAmount = amount / usdToJpy; break;
        }

        // Convert USD to target currency
        switch (target) {
            case "USD": convertedAmount = usdAmount; break;
            case "INR": convertedAmount = usdAmount * usdToInr; break;
            case "EUR": convertedAmount = usdAmount * usdToEur; break;
            case "GBP": convertedAmount = usdAmount * usdToGbp; break;
            case "JPY": convertedAmount = usdAmount * usdToJpy; break;
        }

        // Display result
        System.out.printf("\n%.2f %s = %.2f %s\n", amount, base, convertedAmount, target);

        sc.close();
    }

    // Helper method to check if currency is supported
    public static boolean isSupported(String currency, String[] list) {
        for (String curr : list) {
            if (curr.equalsIgnoreCase(currency)) {
                return true;
            }
        }
        return false;
    }
}

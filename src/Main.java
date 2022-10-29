import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/** Bank ATM
 1 create new user, user first name last name email then store data
 2 set up a user ID(PIN)
 3 Deposit and or withdraw from account
 4 view balance and exit console.
*/

public class Main {
   
    public static void main(String[] args) {
        Customer customer = null;

        while (true) {
            if (customer == null) {
                try {
                    customer = signInOrCreateNewUser();
                } catch (IOException exception) {
                    System.out.println("Invalid entry on account creation, please retry");
                }
            }
        }
    }
 

    private static Customer signInOrCreateNewUser() throws IOException {
        System.out.println("Welcome to Future Bank ");
        System.out.println("Please create a new account with us");
        System.out.println("Please enter your fist name, thank you ");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String firstName = bufferedReader.readLine();

        System.out.println("Please enter your last name");
        String lastName = bufferedReader.readLine();

        System.out.println("Please enter your email, example name@domain.com");
        String email = bufferedReader.readLine();


        String pin = " ";
        boolean isValidPin = false;
        while (!isValidPin) {
            System.out.println("Please enter your personal PIN number(4 digit number)");
            pin = bufferedReader.readLine();

            if (pin.length() == 4) {
                Float integer = isValidNumber(pin);

                if (integer == null) {
                    System.out.println("Invalid pin entry, retry please!");
                }

                } else {
                    System.out.println("PIN needs to be four (4) digits");
            }
        }

        Customer customer = new Customer(firstName, lastName, pin, email, 0);
        System.out.println("Please enter initial deposit, type Yes if you want to or No if you do not");
        String answer = bufferedReader.readLine();

        if ("Yes".equalsIgnoreCase(answer)) {
            System.out.println("Thanks, how much would you like to enter ?");
            String amount = bufferedReader.readLine();

            Float convertedAmount = isValidNumber(amount);
            if (convertedAmount != null) {
                customer.deposit(convertedAmount);
            } else {
                System.out.println("The number is not valid! please retry");
            }
        }
            return customer;
    }

    private static Float isValidNumber(String value) {
        try {
            return Float.parseFloat(value);

        } catch (Exception ex) {
            return null;
        }
    }

    private void displayOptions(Customer customer) throws IOException {
        System.out.println("Hello" + customer.getFirstName() + "How can we help you today");
        System.out.println("1. Deposit ");
        System.out.println("2. Withdrawals ");
        System.out.println("3. Check Account Balance ");
        System.out.println("4. Exit");
        System.out.println("Please choose between 1-3, Thank you");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String response = bufferedReader.readLine();

        switch (response) {
            case "1":
                boolean depositSuccessful = false;
                boolean stayInLoop = true;

                while (!depositSuccessful) {
                    System.out.println("How much would you like to deposit ? ");
                    String amount = bufferedReader.readLine();
                    Float convertedAmount = isValidNumber(amount);
                    if (convertedAmount != null) {
                        customer.deposit(convertedAmount);
                        displayAccountBalance(customer);
                        depositSuccessful = true;
                    }else{
                        System.out.println("Invalid number!");
                    }
                }
                break;

            case "2":
                boolean withdrawalSuccessful = false;
                while (!withdrawalSuccessful) {
                    System.out.println("How much would you like to withdraw? ");
                    String amount = bufferedReader.readLine();
                    Float convertedAmount = isValidNumber(amount);
                    if (convertedAmount != null) {
                        customer.withdraw(convertedAmount);
                        displayAccountBalance(customer);
                        withdrawalSuccessful = true;
                    } else {
                        System.out.println("Number is not valid");
                    }
                }
                break;

            case "3":
                displayAccountBalance(customer);
                break;

            case "4":

                stayInLoop = false;
                break;

            default:
                System.out.println("Invalid action");
                break;
        }

    }

    private void displayAccountBalance(Customer customer) {
    }
}

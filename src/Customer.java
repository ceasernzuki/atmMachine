public class Customer {
    private String firstName;
    private String lastName;
    private String email;
    private String pin;
    private Float accountBalance;

    public Customer(String firstName, String lastName, String email, String pin, float accountBalance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.pin = pin;
        this.accountBalance = accountBalance;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Float getAccountBalance() {
        return accountBalance;
    }

    public Float deposit(Float amount){
        this.accountBalance += amount;
        return accountBalance;
    }
    public Float withdraw(Float amount) {
        this.accountBalance -= amount;
        return accountBalance;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", pin='" + pin + '\'' +
                ", accountBalance=" + accountBalance +
                '}';
    }
}


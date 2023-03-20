import java.io.PrintWriter;
import java.util.Scanner;

public class Customer {
    private String customerID;
    private String surname;
    private String firstName;
    private String otherInitials;
    private String title;

    public Customer(String surname, String firstName, String otherInitials, String title) {
        this.customerID = "unknown";
        this.surname = surname;
        this.firstName = firstName;
        this.otherInitials = otherInitials;
        this.title = title;
    }

    public Customer() {
        this.customerID = "unknown";
        this.surname = "";
        this.firstName = "";
        this.otherInitials = "";
        this.title = "";


    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    // Method to print customer details
    public void printDetails() {
        System.out.println("Customer ID: " + customerID);
        System.out.println("Surname: " + surname);
        System.out.println("First name: " + firstName);
        System.out.println("Other initials: " + otherInitials);
        System.out.println("Title: " + title);
    }


    public void readData(Scanner scanner) {
        scanner.useDelimiter("\\s*,\\s*|\\s+(?=[,])");

        this.customerID = scanner.next();
        this.surname = scanner.next();
        this.firstName = scanner.next();
        this.otherInitials=scanner.next();
        this.title= scanner.next();
    }

    public void writeData(PrintWriter writer) {
        writer.println("Customer ID: " + customerID);
        writer.println("Surname: " + surname);
        writer.println("First name: " + firstName);
        writer.println("OtherInitials: " + otherInitials);
        writer.println("Gender: " + title );
        writer.println();
    }

}

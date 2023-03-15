import java.util.Scanner;

public class Tool {
    private String toolName;
    private String itemCode;
    private int timesBorrowed;
    private boolean onLoan;
    private int cost;
    private int weight;


    // printDetails method
    public void printDetails() {
        System.out.println("Tool name: " + toolName);
        System.out.println("Code: " + itemCode);
        System.out.println("Times Borrowed: " + timesBorrowed);
        System.out.println("On Loan: " + onLoan);
        System.out.println("Cost: " + cost);
        System.out.println("Weight: " + weight);
    }

    public void readData(Scanner scanner) {
        scanner.useDelimiter(",");

        this.toolName = scanner.next();
        this.itemCode = scanner.next();
        this.timesBorrowed = Integer.parseInt(scanner.next());
        this.onLoan = Boolean.parseBoolean(scanner.next());
        this.cost = Integer.parseInt(scanner.next());
        this.weight = Integer.parseInt(scanner.next());
    }

}

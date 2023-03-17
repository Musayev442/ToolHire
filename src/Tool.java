import java.util.Scanner;

public class Tool {
    protected String toolName;
    protected String itemCode;
    protected int timesBorrowed;
    protected boolean onLoan;
    protected int cost;
    protected int weight;


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

import java.util.Scanner;

public class Tool {
    private String toolName;
    private String itemCode;
    private int timesBorrowed;
    private boolean onLoan;
    private int cost;
    private int weight;
    private boolean rechargeable;
    private boolean sharpenable;
    private String power;


    // printDetails method
    public void printDetails() {
        System.out.println("Tool name: " + toolName);
        System.out.println("Code: " + itemCode);
        System.out.println("Times Borrowed: " + timesBorrowed);
        System.out.println("On Loan: " + onLoan);
        System.out.println("Cost: " + cost);
        System.out.println("Weight: " + weight);
        System.out.println("Rechargeable: " + rechargeable);
        System.out.println("Sharpenable: " + sharpenable);
        System.out.println("Power: " + power);
    }

    public void readData(Scanner scanner) {
        scanner.useDelimiter(",");

        this.toolName = scanner.next().trim();
        this.itemCode = scanner.next().trim();
        this.timesBorrowed = Integer.parseInt(scanner.next().trim());
        this.onLoan = Boolean.parseBoolean(scanner.next().trim());
        this.cost = Integer.parseInt(scanner.next().trim());
        this.weight = Integer.parseInt(scanner.next().trim());
        this.rechargeable = Boolean.parseBoolean(scanner.next().trim());
//        this.sharpenable = Boolean.parseBoolean(scanner.next().trim());
//        this.power = scanner.next().trim();
        scanner.close();
    }

}

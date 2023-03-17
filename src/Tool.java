import java.util.Scanner;

public class Tool extends ShopItem{
    protected int timesBorrowed;
    protected boolean onLoan;
    protected int weight;


    public void printDetails() {
        System.out.println("Tool name: " + itemName);
        System.out.println("Code: " + itemCode);
        System.out.println("Times Borrowed: " + timesBorrowed);
        System.out.println("On Loan: " + onLoan);
        System.out.println("Cost: " + cost);
        System.out.println("Weight: " + weight);
    }

    public void readData(Scanner scanner) {
        scanner.useDelimiter(",");

        this.itemName = scanner.next();
        this.itemCode = scanner.next();
        this.timesBorrowed = Integer.parseInt(scanner.next());
        this.onLoan = Boolean.parseBoolean(scanner.next());
        this.cost = Integer.parseInt(scanner.next());
        this.weight = Integer.parseInt(scanner.next());
    }

}

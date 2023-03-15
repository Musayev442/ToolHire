public class Tool {
    private String toolName;
    private String itemCode;
    private int timesBorrowed;
    private boolean onLoan;
    private int cost;
    private int weight;

    public Tool(String toolName, String itemCode, int timesBorrowed, boolean onLoan, int cost, int weight) {
        this.toolName = toolName;
        this.itemCode = itemCode;
        this.timesBorrowed = timesBorrowed;
        this.onLoan = onLoan;
        this.cost = cost;
        this.weight = weight;
    }

    // printDetails method
    public void printDetails() {
        System.out.println("Tool name: " + toolName);
        System.out.println("Code: " + itemCode);
        System.out.println("Times Borrowed: " + timesBorrowed);
        System.out.println("On Loan: " + onLoan);
        System.out.println("Cost: " + cost);
        System.out.println("Weight: " + weight);
    }
}

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Tool tool1 = new Tool("DeWalt Circular Saw", "RD6582", 250, false, 350, 345);

        shop.storeTool(tool1);
        shop.printAllTools();
    }
}
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Shop {
    //    private ArrayList<ShopItem> shopItemList;
//    private ArrayList<Customer> customerList;
//    private List<ShopItem> itemsList;
//    private List<Customer> customerList;
    private HashSet<String> customerIDsSet;
    private HashMap<String, Customer> customerMap;
    private HashMap<String, ShopItem> itemsMap;
    private HashMap<String, ShopItemReservation> itemReservationMap;
    private Random randomGenerator;
    private int lastReservationNo = 0;

    public Shop() {
        // create new ArrayList objects for customerList and itemsList
//        customerList = new ArrayList<Customer>();
//        itemsList = new ArrayList<ShopItem>();

        // create new HashMap objects for customerMap and itemsMap
        this.customerMap = new HashMap<String, Customer>();
        this.itemsMap = new HashMap<String, ShopItem>();
        this.itemReservationMap = new HashMap<String, ShopItemReservation>();

        this.customerIDsSet = new HashSet<String>();
        this.randomGenerator = new Random();
    }

    //Get Item by itemCode
    public ShopItem getItem(String itemCode) {
        return itemsMap.get(itemCode);
    }

    // Get Customer by customerId
    public Customer getCustomer(String customerId) {
        return customerMap.get(customerId);
    }

    // Get ShopItemReservation by reservationNo
    public ShopItemReservation getItemReservation(String reservationNo) {
        return itemReservationMap.get(reservationNo);
    }

    // Method to store a new item
    public void storeItem(ShopItem item) {
        //itemsList.add(item);
        itemsMap.put(item.getItemCode(), item);
    }

    // Method to store a new customer
    public void storeCustomer(Customer customer) {
        // Allocate a unique customer ID
        if (customer.getCustomerID().equals("unknown")) {

            String newId = generateCustomerID("AB-", 6);

            customer.setCustomerID(newId);
        }


        // Add the customer to the customerList
        //this.customerList.add(customer);
        this.customerMap.put(customer.getCustomerID(), customer);
    }

    // Method to store a new ShopItemReservation
    public void storeItemReservation(ShopItemReservation itemReservation) {
        itemReservationMap.put(itemReservation.getReservationNo(), itemReservation);
    }

    // Method to print details of all tools
    public void printAllTools() {
        int itemCount = 1;

        System.out.println("--------- Shop Tools ---------");

//        for (ShopItem item : itemsList) {
//            System.out.println("Tool: " + itemCount);
//
//            item.printDetails();
//
//            System.out.println("\n");
//            itemCount++;
//        }

        for (HashMap.Entry<String, ShopItem> item : this.itemsMap.entrySet()) {

            System.out.println("Tool: " + itemCount);

            item.getValue().printDetails();

            System.out.println("\n");
            itemCount++;
        }

    }

    // Method to print details of all customers
    public void printAllCustomers() {
        int customerCount = 1;
        System.out.println("--------- Customers ---------");

//        for (Customer customer : this.customerList) {
//            System.out.println("Tool: " + customerCount);
//
//            customer.printDetails();
//
//            // Add a blank line between each customer's details
//            System.out.println("\n");
//
//            customerCount++;
//        }

        for (HashMap.Entry<String, Customer> customer : this.customerMap.entrySet()) {

            System.out.println("Customer: " + customerCount);

            customer.getValue().printDetails();

            System.out.println("\n");
            customerCount++;
        }
    }

    public void printItemReservations() {
        System.out.println("Reservations for item: ");

        for (HashMap.Entry<String, ShopItemReservation> reservationEntry : this.itemReservationMap.entrySet()) {

            reservationEntry.getValue().printDetails();

            System.out.println("\n");
        }
    }

    // Method to read shop items data from a file
    public void readToolData() {
        // create a FileDialog to select the input file
        FileDialog dialog = new FileDialog((Frame) null, "Select Items Data File to Open");
        dialog.setMode(FileDialog.LOAD);
        dialog.setDirectory("JavaProjects\\Tool Hire\\datas\\tool_data_1.txt"); // set directory to your desired path
        dialog.setVisible(true);

        String fileName = dialog.getFile();

        if (fileName != null) {

            File file = new File(dialog.getDirectory(), fileName);
            String typeOfData = "";

            try {
                Scanner fileScanner = new Scanner(file);

                // read each line of the file and print it to the console
                while (fileScanner.hasNextLine()) {

                    String lineOfText = (fileScanner.nextLine()).trim();

                    if (lineOfText.startsWith("//") || lineOfText.isEmpty()) {
                        continue; // ignore comments and empty lines
                    }

                    if (lineOfText.startsWith("[")) {
                        typeOfData = lineOfText; // set type of data based on flag
                    } else {

                        Scanner lineScanner = new Scanner(lineOfText);

                        if (typeOfData.equalsIgnoreCase("[ElectricTool data]")) {
                            ElectricTool electricTool = new ElectricTool();
                            electricTool.readData(lineScanner);
                            storeItem(electricTool);
                        } else if (typeOfData.equals("[HandTool data]")) {
                            Handtool handtool = new Handtool();
                            handtool.readData(lineScanner);
                            storeItem(handtool);
                        } else if (typeOfData.equals("[Perishable data]")) {
                            Perishable perishable = new Perishable();
                            perishable.readData(lineScanner);
                            storeItem(perishable);
                        } else if (typeOfData.equals("[Workwear data]")) {
                            Workwear workwear = new Workwear();
                            workwear.readData(lineScanner);
                            storeItem(workwear);
                        }

                        lineScanner.close(); // close scanner for this line
                    }
                }

                fileScanner.close(); // close scanner for file
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
            }
        } else {
            System.exit(0);
        }

        printAllTools(); // print all tools for debugging purposes

        System.out.println("Press Enter button to continue!");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
    }

    // Method to read customer data from a file
    public void readCustomerData() {
        // create a FileDialog to select the input file
        FileDialog dialog = new FileDialog((Frame) null, "Select Customer Data File to Open");
        dialog.setMode(FileDialog.LOAD);
        dialog.setDirectory("JavaProjects\\Tool Hire\\datas\\tool_data_1.txt"); // set directory to your desired path
        dialog.setVisible(true);

        String fileName = dialog.getFile();

        if (fileName != null) {

            File file = new File(dialog.getDirectory(), fileName);
            String typeOfData = "";

            try {
                Scanner fileScanner = new Scanner(file);

                // read each line of the file and print it to the console
                while (fileScanner.hasNextLine()) {

                    String lineOfText = (fileScanner.nextLine()).trim();

                    if (lineOfText.startsWith("//") || lineOfText.isEmpty()) {
                        continue; // ignore comments and empty lines
                    }

                    Scanner lineScanner = new Scanner(lineOfText);

                    Customer customer = new Customer();

                    customer.readData(lineScanner);

                    // Off course, we can use this mehod, but I have one question. Why we declared readData() method in Customer class?
                    // Why we have two constructors in Customer class, where we should use them?
                    //scanner.useDelimiter("\\s*,\\s*|\\s+(?=[,])");
                    //Customer customer = new Customer(scanner.next(), scanner.next(), scanner.next(), scanner.next());

                    storeCustomer(customer);

                    lineScanner.close(); // close scanner for this line
                }

                fileScanner.close(); // close scanner for file
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
            }
        } else {

            System.exit(0);
        }
        writeCustomerData();
        printAllCustomers(); // print all customers for debugging purposes

    }

    public void readItemReservationData() {
        // create a FileDialog to select the input file
        FileDialog dialog = new FileDialog((Frame) null, "Select Reservation Data File to Open");
        dialog.setMode(FileDialog.LOAD);
        dialog.setDirectory("JavaProjects\\Tool Hire\\datas\\tool_data_1.txt"); // set directory to your desired path
        dialog.setVisible(true);

        String fileName = dialog.getFile();

        if (fileName != null) {

            File file = new File(dialog.getDirectory(), fileName);
            String typeOfData = "";

            try {
                Scanner fileScanner = new Scanner(file);

                // read each line of the file and print it to the console
                while (fileScanner.hasNextLine()) {

                    String lineOfText = (fileScanner.nextLine()).trim();

                    if (lineOfText.startsWith("//") || lineOfText.isEmpty()) {
                        continue; // ignore comments and empty lines
                    }

                    Scanner lineScanner = new Scanner(lineOfText);

                    // Why we use this method and where we use this method (readItemReservationData(); method)?

                    lineScanner.close(); // close scanner for this line
                }

                fileScanner.close(); // close scanner for file
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
            }
        }
        printItemReservations(); // print all customers for debugging purposes

        System.exit(0);
    }

    // Method to write customer data to a file
    public void writeCustomerData() {
        String filename = "new_customer_data";
        try {
            PrintWriter writer = new PrintWriter(filename);

            for (HashMap.Entry<String, Customer> customer : this.customerMap.entrySet()) {
                customer.getValue().writeData(writer);
            }

            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: Could not create file " + filename);
        }
    }

    // Method to write Reservation data to a file
    public void writeItemReservationData() {
        String filename = "new_item_reservation_data";
        try {
            PrintWriter writer = new PrintWriter(filename);

            for (HashMap.Entry<String, ShopItemReservation> reservationEntry : this.itemReservationMap.entrySet()) {
                reservationEntry.getValue().writeData(writer);
            }

            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: Could not create file " + filename);
        }
    }

    // Method to generate a unique customer ID with the given prefix and number of digits
    public String generateCustomerID(String prefix, int numDigits) {
        // Generate a random number with the given number of digits
        int min = (int) Math.pow(10, numDigits - 1);
        int max = (int) Math.pow(10, numDigits) - 1;

        String customerID;
        do {
            int randomNum = randomGenerator.nextInt(max - min + 1) + min;

            // Combine the prefix and random number to create the customer ID
            customerID = prefix + randomNum;

            // Check HashSet contains new ID
        } while (!customerIDsSet.add(customerID));

        // If the ID is not already in use, return it
        return customerID;
    }

    public String generateReservationNo() {
        lastReservationNo++;
        String reservationNo = String.format("%06d", lastReservationNo);
        return reservationNo;
    }

    public boolean makeItemReservation(String customerID, String itemID, String startDate, int noOfDays) {
        // Check if customerID, itemID, startDate, and noOfDays are valid
        if (customerID == null || customerID.isEmpty()) {
            System.out.println("Invalid customer ID.");
            return false;
        }
        if (itemID == null || itemID.isEmpty()) {
            System.out.println("Invalid item ID.");
            return false;
        }
        if (startDate == null || startDate.isEmpty()) {
            System.out.println("Invalid start date.");
            return false;
        }
        if (noOfDays <= 0) {
            System.out.println("Invalid number of days.");
            return false;
        }

        // Generate a reservation number
        String reservationNo = generateReservationNo();

        // Create a ShopItemReservation object
        ShopItemReservation reservation = new ShopItemReservation(reservationNo, customerID, itemID, startDate, noOfDays);

        // Add the reservation to the list of reservations
        storeItemReservation(reservation);

        return true;
    }


}

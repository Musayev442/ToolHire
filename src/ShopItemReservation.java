import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

public class ShopItemReservation {
    private String reservationNo;
    private String itemID;
    private String customerID;
    private Date startDate;
    private int noOfDays;
    //private static int nextId = 1;
    public ShopItemReservation(String reservationNo, String itemID, String customerID, String startDate, int noOfDays) {
        //this.reservationNo = String.format("%06d", nextId++);
        this.reservationNo = reservationNo;
        this.itemID = itemID;
        this.customerID = customerID;
        this.startDate = DateUtil.convertStringToDate(startDate);
        this.noOfDays = noOfDays;
    }

    public String getReservationNo() {
        return reservationNo;
    }

    public void setReservationNo(String reservationNo) {
        this.reservationNo = reservationNo;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(int noOfDays) {
        this.noOfDays = noOfDays;
    }

    public void printDetails() {
        System.out.println("Reservation No: " + reservationNo);
        System.out.println("Item ID: " + itemID);
        System.out.println("Customer ID: " + customerID);
        System.out.println("Start Date: " + startDate);
        System.out.println("No of Days: " + noOfDays);
    }

    public void readData(Scanner scanner) {
        scanner.useDelimiter("\\s*,\\s*|\\s+(?=[,])");

        this.reservationNo = scanner.next();
        this.itemID = scanner.next();
        this.customerID = scanner.next();
        this.startDate = DateUtil.convertStringToDate(scanner.next());
        this.noOfDays = Integer.parseInt(scanner.next());
    }

    public void writeData(PrintWriter writer) {
        writer.println("Reservation No: " + reservationNo);
        writer.println("Item ID: " + itemID);
        writer.println("Customer ID: " + customerID);
        writer.println("Start Date: " + startDate);
        writer.println("No of Days: " + noOfDays);
    }

}

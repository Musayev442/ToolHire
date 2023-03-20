import java.util.Date;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();
        shop.readToolData();
        shop.readCustomerData();


        Date today = DateUtil.convertStringToDate("25-03-2023");
        Date todayWeek = DateUtil. incrementDate(today, 7);
        System.out.println(DateUtil.convertDateToShortString(todayWeek));

        Date date1 = DateUtil.convertStringToDate("25-03-2023");
        Date date2 = DateUtil.convertStringToDate("30-03-2023");
        int daysBetween = DateUtil.daysBetween(date1, date2);
        System.out.println("Days between " + DateUtil.convertDateToShortString(date1) + " and " + DateUtil.convertDateToShortString(date2) + ": " + daysBetween);


    }
}
//package lawnmoving;
import lawnmoving.Lawn;
import java.util.ArrayList;
import java.util.Scanner;
//LawnTest class use to get lawn numer and lawn area as inputs and calculate thye fee 

public class LawnTest {

    // Create an arraylist to store instance values
    private static final ArrayList<Lawn> list = new ArrayList<>();

    public static void main(String[] args) {
        double lowestWeeklyFee = 100, heighestWeeklyFee = 0, total_weekly_fee = 0, lawn_area = 0;
        double weeklyLawnFee = 0;
        int count = 1, lawn_number_heighest_monthly_fee;
        lawnmoving.Lawn lawn1 = new lawnmoving.Lawn();
        Scanner sc = new Scanner(System.in);//create scanner class object to accept keyboard inputs
        System.out.print("Please enter number of lawns = ");
        //use while loop to check validation 
        while (!sc.hasNextInt()) {
            System.out.println("\nInvalid Input. Please enter integer value");
            System.out.print("Please enter number of lawns = ");
            sc.next();
        }
        int N = sc.nextInt();
        //dowhile loop used to accept n lawns area
        do {
            System.out.print("Enter the area for lawn " + count + ": ");
            //use while loop to check validation 
            while (!sc.hasNextDouble()) {
                System.out.println("\nInvalid Input. Please enter Correct value.");
                System.out.print("Enter the area for lawn " + count + ": ");
                sc.next();
            }
            lawn_area = sc.nextDouble();
            //to calculate the lawn moving fee
            weeklyLawnFee = lawn1.lawnMowingFee(lawn_area);
            System.out.println("The weekly fee for lawn " + count + " is $" + weeklyLawnFee + "\n");
            //to add Lawn class objects in arraylist
            list.add(new Lawn(count, lawn_area, weeklyLawnFee));

            count++;
        } while (count <= N);
        //to calculate the lowest and heighest weekly fee and tatal fee
        for (lawnmoving.Lawn lawn : list) {
            if (lawn.getWeekly_fee() < lowestWeeklyFee) {
                lowestWeeklyFee = lawn.getWeekly_fee();
            }
            if (lawn.getWeekly_fee() > heighestWeeklyFee) {
                heighestWeeklyFee = lawn.getWeekly_fee();
            }

            total_weekly_fee += lawn.getWeekly_fee();
        }
        //display heighest, lowest, total, and average weekly fee. And find the heighest monthly fee lawn numer.
        lawn_number_heighest_monthly_fee = lawnNumber(heighestWeeklyFee);
        System.out.println("Total weekly lawn mowing fee: $" + total_weekly_fee);
        System.out.println("Lowest weekly lawn mowing fee: $" + lowestWeeklyFee);
        System.out.println("Highest weekly lawn mowing fee: $" + heighestWeeklyFee);
        System.out.println("Average weekly lawn mowing fee: $" + total_weekly_fee / list.size());
        System.out.println("Lawn number with highest monthly fee: " + lawn_number_heighest_monthly_fee);
    }
    //lawnNumber method find the lawn number with heighst monthly lawn moving fee

    public static int lawnNumber(double fee) {
        double maxFeeMonthly = 0;
        int number_heighst_month_fee = 0;
        maxFeeMonthly = fee * 4;
        for (lawnmoving.Lawn lawn : list) {
            if (lawn.getWeekly_fee() == fee) {
                number_heighst_month_fee = lawn.getN();
            }
        }
        return number_heighst_month_fee;
    }
}

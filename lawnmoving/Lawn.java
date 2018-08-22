package lawnmoving;
// Lawn class use to get all instance area and number of lawns

public class Lawn {

    private int N;
    private double area;

    private double weekly_fee;
//constructor of Lawn class taks perameters

    public Lawn(int N, double area, double weekly_fee) {
        this.N = N;
        this.area = area;
        this.weekly_fee = weekly_fee;
    }
//default constructor 

    public Lawn() {
    }

    public int getN() {
        return N;
    }

    public double getArea() {
        return area;
    }

    public double getWeekly_fee() {
        return weekly_fee;
    }
//lawnMowingFee to calculate the lawn moving fee according lawn area

    public double lawnMowingFee(double area) {
        if (area < 500) {
            weekly_fee = 40;
        } else if (area >= 500 && area < 900) {
            weekly_fee = 60;
        } else if (area >= 900 && area < 1500) {
            weekly_fee = 75;
        } else if (area >= 1500) {
            weekly_fee = 100;
        }
        return weekly_fee;
    }
}

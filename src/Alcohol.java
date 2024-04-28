/*
 * Class: CMSC203 
 * Instructor: Dr.Grinberg
 * Description: Represents an alcoholic beverage with properties for size and whether it is ordered on a weekend, affecting its pricing.
 * Due: 04/27/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Leul Belay
*/


// Alcohol subclass of Beverage
public class Alcohol extends Beverage {
    private boolean weekend;
    private final double weekendPrice = 0.6;

    public Alcohol(String name, Size size, boolean weekend) {
        super(name, size, Type.ALCOHOL);
        this.weekend = weekend;
    }

    @Override
    public double calcPrice() {
        double price = addSizePrice();
        if (weekend) {
            price += weekendPrice;
        }
        return price;
    }

    @Override
    public String toString() {
        String details = super.toString();
        details += ", Weekend: " + weekend;
        return details;
    }

    // Getters and setters for weekend
    public boolean isWeekend() {
        return weekend;
    }

    public void setWeekend(boolean weekend) {
        this.weekend = weekend;
    }
}
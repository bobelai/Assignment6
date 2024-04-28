/*
 * Class: CMSC203 
 * Instructor: Dr.Grinberg
 * Description: Describes a coffee beverage that can include additional options like extra shots and syrups, influencing its final price.
 * Due: 04/27/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Leul Belay
*/

// Coffee subclass of Beverage
public class Coffee extends Beverage {
    private boolean extraShot;
    private boolean extraSyrup;
    private final double extraShotPrice = 0.5;
    private final double extraSyrupPrice = 0.5;

    public Coffee(String name, Size size, boolean extraShot, boolean extraSyrup) {
        super(name, size, Type.COFFEE);
        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
    }

    @Override
    public double calcPrice() {
        double price = addSizePrice();
        if (extraShot) {
            price += extraShotPrice;
        }
        if (extraSyrup) {
            price += extraSyrupPrice;
        }
        return price;
    }

    @Override
    public String toString() {
        String details = super.toString();
        details += ", Extra Shot: " + extraShot + ", Extra Syrup: " + extraSyrup;
        return details;
    }

    // Getters and setters for extraShot and extraSyrup
    public boolean isExtraShot() {
        return extraShot;
    }

    public void setExtraShot(boolean extraShot) {
        this.extraShot = extraShot;
    }

    public boolean isExtraSyrup() {
        return extraSyrup;
    }

    public void setExtraSyrup(boolean extraSyrup) {
        this.extraSyrup = extraSyrup;
    }
}
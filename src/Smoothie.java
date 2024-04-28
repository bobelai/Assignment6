/*
 * Class: CMSC203 
 * Instructor: Dr.Grinberg
 * Description: Represents a smoothie beverage, allowing customization through added fruits and protein options that affect its price.
 * Due: 04/27/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Leul Belay
*/

// Smoothie subclass of Beverage
public class Smoothie extends Beverage {
    private int numOfFruits;
    private boolean addProtein;
    private final double proteinPrice = 1.5;
    private final double fruitPrice = 0.5;

    public Smoothie(String name, Size size, int numOfFruits, boolean addProtein) {
        super(name, size, Type.SMOOTHIE);
        this.numOfFruits = numOfFruits;
        this.addProtein = addProtein;
    }

    @Override
    public double calcPrice() {
        double price = addSizePrice() + numOfFruits * fruitPrice;
        if (addProtein) {
            price += proteinPrice;
        }
        return price;
    }

    @Override
    public String toString() {
        String details = super.toString();
        details += ", Number of Fruits: " + numOfFruits + ", Add Protein: " + addProtein;
        return details;
    }

    // Getters and setters for numOfFruits and addProtein
    public int getNumOfFruits() {
        return numOfFruits;
    }

    public void setNumOfFruits(int numOfFruits) {
        this.numOfFruits = numOfFruits;
    }

    public boolean isAddProtein() {
        return addProtein;
    }

    public void setAddProtein(boolean addProtein) {
        this.addProtein = addProtein;
    }
}
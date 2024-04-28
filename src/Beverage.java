/*
 * Class: CMSC203 
 * Instructor: Dr.Grinberg
 * Description: An abstract class that serves as a base for different types of beverages, defining common properties and behaviors like size and pricing calculations.
 * Due: 04/27/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Leul Belay
*/


public abstract class Beverage {
    private String name;
    private Size size;
    private Type type;
    private final double basePrice = 2.0;
    private final double sizePrice = 0.5;

    public Beverage(String name, Size size, Type type) {
        this.name = name;
        this.size = size;
        this.type = type;
    }

    public double addSizePrice() {
        switch (this.size) {
            case SMALL:
                return basePrice;
            case MEDIUM:
                return basePrice + sizePrice;
            case LARGE:
                return basePrice + 2 * sizePrice;
            default:
                return basePrice;
        }
    }

    public abstract double calcPrice();

    @Override
    public String toString() {
        return "Name: " + name + ", Size: " + size + ", Type: " + type + ", Price: $" + calcPrice();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Beverage other = (Beverage) obj;
        return Double.compare(other.calcPrice(), calcPrice()) == 0 &&
                name.equals(other.name) &&
                size == other.size &&
                type == other.type;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}

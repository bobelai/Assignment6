/*
 * Class: CMSC203 
 * Instructor: Dr.Grinberg
 * Description: Encapsulates an order, containing multiple beverages and customer details, and provides methods for order management and price calculation.
 * Due: 04/27/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Leul Belay
*/

import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface, Comparable<Order> {
    private int orderNo;
    private int orderTime;
    private Day orderDay;
    private Customer customer;
    private ArrayList<Beverage> beverages;

    public Order(int orderTime, Day orderDay, Customer customer) {
        this.orderNo = generateOrderNo();
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        this.customer = customer;
        this.beverages = new ArrayList<>();
    }

    private int generateOrderNo() {
        Random random = new Random();
        return 10000 + random.nextInt(80001);  // Range [10000, 90000]
    }

    @Override
    public boolean isWeekend() {
        return orderDay == Day.SATURDAY || orderDay == Day.SUNDAY;
    }

    @Override
    public Beverage getBeverage(int itemNo) {
        if (itemNo >= 0 && itemNo < beverages.size()) {
            return beverages.get(itemNo);
        }
        return null;
    }

    @Override
    public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
    }

    @Override
    public void addNewBeverage(String bevName, Size size) {
        beverages.add(new Alcohol(bevName, size, isWeekend()));
    }

    @Override
    public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
        beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));
    }

    @Override
    public double calcOrderTotal() {
        double total = 0;
        for (Beverage beverage : beverages) {
            total += beverage.calcPrice();
        }
        return total;
    }

    @Override
    public int findNumOfBeveType(Type type) {
        int count = 0;
        for (Beverage beverage : beverages) {
            if (beverage.getType() == type) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return "Order No: " + orderNo +
                ", Order Time: " + orderTime +
                ", Order Day: " + orderDay +
                ", Customer: " + customer +
                ", Beverages: " + beverages;
    }

    @Override
    public int compareTo(Order other) {
        return Integer.compare(this.orderNo, other.orderNo);
    }

    // Getters and Setters
    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public int getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(int orderTime) {
        this.orderTime = orderTime;
    }

    public Day getOrderDay() {
        return orderDay;
    }

    public void setOrderDay(Day orderDay) {
        this.orderDay = orderDay;
    }

    public Customer getCustomer() {
        return customer.getDeepCopy();
    }

    public void setCustomer(Customer customer) {
        this.customer = customer.getDeepCopy();
    }

    public ArrayList<Beverage> getBeverages() {
        return new ArrayList<>(beverages); // Shallow copy of the list
    }

    public void setBeverages(ArrayList<Beverage> beverages) {
        this.beverages = new ArrayList<>(beverages); // Shallow copy of the list
    }
}

/*
 * Class: CMSC203 
 * Instructor: Dr.Grinberg
 * Description: Manages a beverage shop's operations, including order creation, beverage processing, and sales tracking.
 * Due: 04/27/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Leul Belay
*/

import java.util.ArrayList;
import java.util.Collections;

public class BevShop implements BevShopInterface {
    private ArrayList<Order> orders;
    private Order currentOrder;

    public BevShop() {
        orders = new ArrayList<>();
    }

    
    public boolean isValidTime(int time) {
        return time >= MIN_TIME && time <= MAX_TIME;
    }


    public int getMaxNumOfFruits() {
        return MAX_FRUIT;
    }

 
    public int getMinAgeForAlcohol() {
        return MIN_AGE_FOR_ALCOHOL;
    }


    public boolean isMaxFruit(int numOfFruits) {
        return numOfFruits > MAX_FRUIT;
    }

    
    public int getMaxOrderForAlcohol() {
        return MAX_ORDER_FOR_ALCOHOL;
    }

  
    public boolean isEligibleForMore() {
        return getNumOfAlcoholDrink() < MAX_ORDER_FOR_ALCOHOL;
    }

  
    public int getNumOfAlcoholDrink() {
        return currentOrder != null ? currentOrder.findNumOfBeveType(Type.ALCOHOL) : 0;
    }

   
    public boolean isValidAge(int age) {
        return age >= MIN_AGE_FOR_ALCOHOL;
    }

   
    public void startNewOrder(int time, Day day, String customerName, int customerAge) {
        Customer customer = new Customer(customerName, customerAge);
        currentOrder = new Order(time, day, customer);
        orders.add(currentOrder);
    }


    public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
    }

    
    public void processAlcoholOrder(String bevName, Size size) {
        currentOrder.addNewBeverage(bevName, size);
    }

  
    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
        currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtein);
    }

    
    public int findOrder(int orderNo) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderNo() == orderNo) {
                return i;
            }
        }
        return -1;
    }

    
    public double totalOrderPrice(int orderNo) {
        int index = findOrder(orderNo);
        if (index != -1) {
            return orders.get(index).calcOrderTotal();
        }
        return 0;
    }

  
    public double totalMonthlySale() {
        double total = 0;
        for (Order order : orders) {
            total += order.calcOrderTotal();
        }
        return total;
    }


    public int totalNumOfMonthlyOrders() {
        return orders.size();
    }

    
    public Order getCurrentOrder() {
        return currentOrder;
    }

    
    public Order getOrderAtIndex(int index) {
        if (index >= 0 && index < orders.size()) {
            return orders.get(index);
        }
        return null;
    }


    public void sortOrders() {
        Collections.sort(orders);
    }

    
}

/*
 * Class: CMSC203 
 * Instructor: Dr.Grinberg
 * Description:  Manages customer information such as name and age, and provides functionality to create a deep copy of its instances.
 * Due: 04/27/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Leul Belay
*/
public class Customer {
    private String name;
    private int age;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Customer [Name=" + name + ", Age=" + age + "]";
    }

    // Deep copy of the customer
    public Customer getDeepCopy() {
        return new Customer(this.name, this.age);
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

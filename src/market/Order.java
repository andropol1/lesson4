package market;

import java.util.HashMap;
import java.util.Map;

import static market.Customer.Gender.FEMALE;
import static market.Customer.Gender.MALE;

public class Order {

    private static int count = 1;
    private int id;
    private Customer customer;
    private Map<Product, Integer> products;
    public enum Holiday {notHoliday, NewYear, March_8, February_23};
    private Holiday day;
    private double discount;

    public Order(Customer customer, String day) {
        this.id = count;
        count++;
        this.day = Holiday.valueOf(day);
        this.customer = customer;
        products = new HashMap<Product, Integer>();
        switch(Holiday.valueOf(day)){
            case NewYear : {
                this.discount = 20;
                break;
            }
            case March_8: {
                if (customer.getSex().equals(FEMALE)){
                    this.discount = 15;
                    break;
                }
            }
            case February_23: {
                if (customer.getSex().equals(MALE)){
                    this.discount = 15;
                    break;
                }
            }
            default: {
                this.discount = 0;
            }
        }
    }

    public int getId() {
        return id;
    }

    public Customer getUser() {
        return customer;
    }

    public void add (Product product, int quantity) {
        products.put(product, quantity);
    }

    @Override
    public String toString() {
        return "market.Order{" +
                "customer=" + customer +
                ", products=" + products +
                '}';
    }
}

package market;

import Exceptions.ProductNotFoundException;
import Exceptions.QuantityIsNegativeException;
import Exceptions.UserNotFoudException;

import java.util.ArrayList;
import java.util.List;

public class Market {

    private List<Customer> customers;
    private List<Product> products;
    private List<Order> orders;


    public Market() {
        customers = new ArrayList<>(List.of(
                new Customer("Tom", 45, "11111","MALE"),
                new Customer("Bob", 26, "22222","MALE"),
                new Customer("Jim", 53, "33333","MALE"),
                new Customer("John", 40, "44444","MALE")
        ));
        products = new ArrayList<>(List.of(
                new Product("Milk", 89),
                new Product("Bread", 26),
                new Product("Cheese", 125)
        ));
        orders = new ArrayList<>();
    }

    public int createOrder(Customer customer, String day) throws UserNotFoudException {
        if (!customers.contains(customer)) throw new UserNotFoudException("customer not found, " + customer);
        Order order = new Order(customer, day);
        orders.add(order);
        return order.getId();
    }

    public Order addProductToOrder(int orderId, Product product, int quantity)
            throws ProductNotFoundException, QuantityIsNegativeException {
        if (!products.contains(product)) throw new ProductNotFoundException("product not found");
        if (quantity <= 0) throw new QuantityIsNegativeException("quantity of product is negative");
        Order order = orders.stream().filter(o -> o.getId() == orderId).findFirst().get();
        order.add(product, quantity);
        return order;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Order> getOrders() {
        return orders;
    }
}

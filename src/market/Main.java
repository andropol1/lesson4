package market;

import Exceptions.ProductNotFoundException;
import Exceptions.QuantityIsNegativeException;
import Exceptions.UserNotFoudException;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Market market = new Market();
        List<Customer> customers = market.getCustomers();
        List<Product> products = market.getProducts();

        buy(market, customers.get(3), products.get(2), -1, "March_8"); // некоректное количество
        buy(market, customers.get(2), products.get(1), 15, "March_8");
        buy(market, customers.get(1), products.get(0), 2, "February_23");

        System.out.println("===========================================");
        int orderId2;
        try {
            orderId2 = market.createOrder(new Customer("Alex", 22, "666666", "MALE"), "March_8");
        } catch (UserNotFoudException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void buy(Market market, Customer customer, Product product, int quantity, String day) {
        try {
            int orderId = market.createOrder(customer, day);
            market.addProductToOrder(orderId, product, quantity);
            System.out.println(market.getOrders());
        } catch (UserNotFoudException | ProductNotFoundException | QuantityIsNegativeException e) {
            System.out.println(e.getMessage());
        }
    }
}

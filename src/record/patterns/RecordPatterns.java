package record.patterns;


import java.math.BigDecimal;
import java.util.List;

/**
 * Record: Special type of class in Java to model immutable aggregates
 * A compact syntax to declare classes(without  boilerplate code,
 *  Java compiler  automatically generates the private, final fields, getters, a public constructor, and the equals, hashCode, and toString methods.)
 * Allows de-structuring
 *-----------------------------------------------------------------------------------------------
 * Record Patterns help with clarity and conciseness of code
 * Provide Immutability
 * Ease to use
 * Record patterns allow us to extract the values of a record into variables using pattern matching
 */
public class RecordPatterns {

    static void main() {
        record Customer(String id, String name, String email) {

        }

        record  Product(String sku, String name, BigDecimal price) {

        }

        record OrderItem(Product product, int quantity){
            BigDecimal totalCost() {
                return product.price().multiply(BigDecimal.valueOf(quantity));
            }
        }

        record Order(String id, Customer customer, List<OrderItem> items, OrderStatus status) {
            enum OrderStatus {
                NEW, PROCESSING, SHIPPED, DELIVERED
            }

            BigDecimal totalPrice() {
                return items.stream().map(OrderItem::totalCost).reduce(BigDecimal.ZERO, BigDecimal::add);
            }
        }


        Customer customer =  new Customer("12", "mike", "amz@email.com");
        List<OrderItem> orderItems = List.of(
                new OrderItem(new Product("product1", "jjsq", new BigDecimal("1")), 1),
                new OrderItem(new Product("product2", "jjsq", new BigDecimal("1")), 1));

        Order order = new Order("1231", customer, orderItems, Order.OrderStatus.NEW);
        System.out.println(order);
    }
}

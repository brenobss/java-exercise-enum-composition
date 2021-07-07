package aplication;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

public class App {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String clientName = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        String birthDateClient = sc.nextLine();
        Date birthDateCli = sdf.parse(birthDateClient);

        Client cli = new Client(clientName, email, birthDateCli);

        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        String orderStatus = sc.nextLine();
        OrderStatus status = OrderStatus.valueOf(orderStatus);
        Order order = new Order(new Date(), status, cli);

        System.out.print("How many items to this order? ");
        int itemQuantity = sc.nextInt();
        for (int i = 1; i <= itemQuantity; i++){
            sc.nextLine();
            System.out.println("Enter #" + i + " item data: ");
            System.out.print("Product name: ");
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();
            System.out.print("Quantity: ");
            int productQuantity = sc.nextInt();
            Product product = new Product(productName, productPrice);
            OrderItem orderItem = new OrderItem(productQuantity, productPrice, product);
            order.addItem(orderItem);
        }
        System.out.println();
        System.out.println(order);
        sc.close();
    }
}

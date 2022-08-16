package ru.gb.savilin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ru.gb.savilin.config.ApplicationConfig.class);

        System.out.println("Commands:\n" +
                "new  - create new cart\n" +
                "add  - add product with id\n" +
                "remove - remove product by id\n" +
                "show - show the products in the cart\n" +
                "exit - close console");

        Scanner scanner = new Scanner(System.in);
        CartService cartService = null;
        while (true) {
            System.out.println("Enter command to operate with the cart");
            String command = scanner.next().toLowerCase().trim();

            switch (command) {
                case "new": {
                    cartService = context.getBean(CartService.class);
                    break;
                }
                case "add": {
                    if (cartService == null) {
                        System.out.println("You have to create the cart first");
                        break;
                    }
                    System.out.println("Enter product id");
                    long id = scanner.nextLong();
                    cartService.addProduct(id);
                    break;
                }
                case "remove": {
                    if (cartService == null) {
                        System.out.println("You have to create the cart first");
                        break;
                    }
                    System.out.print("Enter product id you want to add: ");
                    Long id = scanner.nextLong();
                    cartService.removeProduct(id);
                    break;
                }
                case "show":
                    if (cartService == null) {
                        System.out.println("You have to create the cart first");
                        break;
                    }
                    cartService.getAllProducts().forEach(System.out::println);
                    System.out.println();
                    break;
                case "exit":
                    return;
            }
        }
    }
}

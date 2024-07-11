package com.mercado.app;

import com.mercado.dao.OrderDAO;
import com.mercado.model.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        OrderDAO orderDAO = new OrderDAO();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Criar um pedido de exemplo
        Order order = createSampleOrder();

        while (running) {
            System.out.println("Escolha uma operação:");
            System.out.println("1. Criar pedido");
            System.out.println("2. Ler pedido");
            System.out.println("3. Atualizar pedido");
            System.out.println("4. Deletar pedido");
            System.out.println("5. Listar todos os pedidos");
            System.out.println("6. Sair");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (choice) {
                case 1:
                    // Criar um novo pedido
                    orderDAO.create(order);
                    System.out.println("Pedido criado com ID: " + order.getId());
                    break;

                case 2:
                    // Ler um pedido
                    System.out.println("Informe o ID do pedido (ObjectId):");
                    String readId = scanner.nextLine();
                    Order orderFromDB = orderDAO.read(readId);
                    System.out.println("Pedido lido: " + orderFromDB);
                    break;

                case 3:
                    // Atualizar um pedido
                    System.out.println("Informe o ID do pedido a ser atualizado (ObjectId):");
                    String updateId = scanner.nextLine();
                    Order orderToUpdate = orderDAO.read(updateId);
                    if (orderToUpdate != null) {
                        orderToUpdate.setOrderStatus("Delivered");
                        orderDAO.update(orderToUpdate);
                        Order updatedOrder = orderDAO.read(updateId);
                        System.out.println("Pedido atualizado: " + updatedOrder);
                    } else {
                        System.out.println("Pedido não encontrado!");
                    }
                    break;

                case 4:
                    // Deletar um pedido
                    System.out.println("Informe o ID do pedido a ser deletado (ObjectId):");
                    String deleteId = scanner.nextLine();
                    orderDAO.delete(deleteId);
                    System.out.println("Pedido deletado com ID: " + deleteId);
                    break;

                case 5:
                    // Listar todos os pedidos
                    List<Order> orders = orderDAO.readAll();
                    for (Order o : orders) {
                        System.out.println(o);
                    }
                    break;

                case 6:
                    // Sair
                    running = false;
                    break;

                default:
                    System.out.println("Escolha inválida, tente novamente.");
            }
        }

        scanner.close();
    }

    private static Order createSampleOrder() {
        // Criar uma nova loja
        Store store = new Store();
        store.setStoreId(301);
        store.setStoreName("Store 1");
        store.setWebAddress("http://store1.com");
        store.setPhysicalAddress("123 Store St, City, Country");
        store.setLatitude(40.7128);
        store.setLongitude(-74.0060);
        store.setLogo("base64EncodedLogoImageString");
        store.setLogoMimeType("image/png");
        store.setLogoFilename("logo1.png");
        store.setLogoCharset("UTF-8");
        store.setLogoLastUpdated("2024-07-08");

        // Criar um novo cliente
        Customer customer = new Customer();
        customer.setCustomerId(201);
        customer.setEmailAddress("customer@example.com");
        customer.setFullName("John Doe");

        // Criar produtos e itens do pedido
        Product product1 = new Product();
        product1.setProductId(101);
        product1.setProductName("Product 1");
        product1.setUnitPrice(19.99);
        product1.setProductDetails("Detailed description of Product 1");
        product1.setProductImage("base64EncodedImageString");
        product1.setImageMimeType("image/jpeg");
        product1.setImageFilename("product1.jpg");
        product1.setImageCharset("UTF-8");
        product1.setImageLastUpdated("2024-07-08");

        Product product2 = new Product();
        product2.setProductId(102);
        product2.setProductName("Product 2");
        product2.setUnitPrice(29.99);
        product2.setProductDetails("Detailed description of Product 2");
        product2.setProductImage("base64EncodedImageString");
        product2.setImageMimeType("image/jpeg");
        product2.setImageFilename("product2.jpg");
        product2.setImageCharset("UTF-8");
        product2.setImageLastUpdated("2024-07-08");

        OrderItem orderItem1 = new OrderItem();
        orderItem1.setLineItemId(1);
        orderItem1.setProduct(product1);
        orderItem1.setQuantity(2);

        OrderItem orderItem2 = new OrderItem();
        orderItem2.setLineItemId(2);
        orderItem2.setProduct(product2);
        orderItem2.setQuantity(1);

        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(orderItem1);
        orderItems.add(orderItem2);

        // Criar um novo pedido
        Order order = new Order();
        order.setOrderId(1);
        order.setOrderDatetime(LocalDateTime.parse("2024-07-09T12:34:56"));
        order.setOrderStatus("Shipped");
        order.setStore(store);
        order.setCustomer(customer);
        order.setOrderItems(orderItems);

        return order;
    }
}

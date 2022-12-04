package de.neuefische;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ShopService {
    private OrderRepo orderRepo = new OrderRepo();
    private ProductRepo productRepo = new ProductRepo();

    public static void main(String[] args){
        /*
        makeOrder(1, "Apfel");
         */
    }

    /*
    void makeOrder(){
        System.out.println("Gib die Bestellung ein -> id;Product Name");
        String id;
        String productName;
        Scanner userInput = new Scanner(System.in);
        while(true) {
            id = userInput.next(";");
            productName = userInput.next(";");

            Product product = new Product();
            List<Product> productList = new ArrayList<>(List.of(products.split(" ")));
            productList.add(productRepo.get(i));
            Order orderMade = new Order(i, productList);
            orderRepo.add(orderMade);
        }
    }
     */

    public Product getProduct(int i) {
        return productRepo.get(i);
    }

    public List<Product> ListProducts() {
        return productRepo.list();
    }

    void addOrder(Order order){
        checkProductsExist(order.getProducts());
        orderRepo.add(order);
    }

    private void checkProductsExist(List<Product> produktsFromTheOrder){
        for(Product product : produktsFromTheOrder) {
            if (productRepo.list().contains(product)) {
                System.out.println(product +" Produkt kann bestellt werden");
            } else {
                throw new IndexOutOfBoundsException("Produkt nicht vorhanden");
            }
        }
    }

    public ShopService(OrderRepo orderRepo, ProductRepo productRepo) {
        this.orderRepo = orderRepo;
        this.productRepo = productRepo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShopService that = (ShopService) o;
        return Objects.equals(orderRepo, that.orderRepo) && Objects.equals(productRepo, that.productRepo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderRepo, productRepo);
    }

    @Override
    public String toString() {
        return "ShopService{" +
                "orderRepo=" + orderRepo +
                ", productRepo=" + productRepo +
                '}';
    }

    public Order getOrder(int i) {
        return orderRepo.get(i);
    }

    public List<Order> listOrders() {
        return orderRepo.list();
    }
}

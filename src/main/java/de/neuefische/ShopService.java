package de.neuefische;

import java.util.List;
import java.util.Objects;

public class ShopService {
    private OrderRepo orderRepo = new OrderRepo();
    private ProductRepo productRepo = new ProductRepo();

    void makeOrder(){}


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



    public ShopService() {
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

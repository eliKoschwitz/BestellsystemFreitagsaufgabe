package de.neuefische;

import java.util.List;
import java.util.Objects;

public class OrderRepo {

    private List<Order> orders;

    // die wird gemockt
    boolean add(Order order){
        return orders.add(order);
    }

    public List<Order> list() {
        return orders;
    }

    public Order get(int id) {
        for(Order order : orders) {
            if(order.getId() == id){
                return order;
            }
        }
        return null;
    }

    public OrderRepo() {
    }

    public OrderRepo(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderRepo orderRepo = (OrderRepo) o;
        return Objects.equals(orders, orderRepo.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orders);
    }

    @Override
    public String toString() {
        return "OrderRepo{" +
                "orderList=" + orders +
                '}';
    }

}

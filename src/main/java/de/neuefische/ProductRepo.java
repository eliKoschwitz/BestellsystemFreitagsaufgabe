package de.neuefische;

import java.util.List;
import java.util.Objects;

public class ProductRepo {
    private List<Product> products;

    public ProductRepo() {
    }

    public ProductRepo(List<Product> products) {
        this.products = products;
    }

    public List<Product> list() {
        return products;
    }

    public Product get(int id){
        for(Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductRepo that = (ProductRepo) o;
        return Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products);
    }

    @Override
    public String toString() {
        return "ProductRepo{" +
                "products=" + products +
                '}';
    }
}

package de.neuefische;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class ShopServiceTest {

    // 1) Tests der ProductRepo Klasse
    @Test
    void listProductRepo() {
        // GIVEN
        List<Product> productList = List.of(new Product(1, "Apfel"));
        ProductRepo productRepo = new ProductRepo(productList);
        // WHEN
        List<Product> actual = productRepo.list();
        // THEN
        Assertions.assertEquals(productList,actual);
    }

    @Test
    void getProductRepo() {
        // GIVEN
        List<Product> productList = List.of(new Product(1, "Apfel"));
        ProductRepo productRepo = new ProductRepo(productList);
        // WHEN
        Product actual = productRepo.get(1);
        // THEN
        Assertions.assertEquals(new Product(1, "Apfel"), actual);
    }

    @Test
    void constructorProductionRepo() {
        // GIVEN
        List <Product> productList = new ArrayList<>(List.of(new Product(1, "Apfel")));
        ProductRepo productRepo1 = new ProductRepo(productList);
        // WHEN
        ProductRepo productRepo2 = new ProductRepo(productList);
        // THEN
        Assertions.assertTrue(productRepo1.equals(productRepo2));
    }

    // 2) Tests der Product Klasse
    @Test
    void constructorProduct() {
        // GIVEN
        Product product1 = new Product(1, "Apfel");
        // WHEN
        Product product2 = new Product(1, "Apfel");
        // THEN
        Assertions.assertTrue(product1.equals(product2));
    }

    // 3) Tests der Order Klasse
    @Test
    void constructorOrder() {
        // GIVEN
        List <Product> productList = new ArrayList<>(List.of(new Product(1, "Apfel")));
        Order order1 = new Order(1,productList);
        // WHEN
        Order order2 = new Order(1,productList);
        // THEN
        Assertions.assertTrue(order1.equals(order2));
    }

    // 4) Test für OrderRepo Klasse
    @Test
    void constructorOrderRepo() {
        // GIVEN
        List<Order> orders = new ArrayList<>(List.of(new Order(1, new ArrayList<Product>(List.of(new Product(1, "Apfel"))))));
        OrderRepo orderRepo1 = new OrderRepo(orders);
        // WHEN
        OrderRepo orderRepo2 = new OrderRepo(orders);
        // THEN
        Assertions.assertTrue(orderRepo1.equals(orderRepo2));
    }

    @Test
    void listOrderRepo(){
        // GIVEN
        List<Order> orders = new ArrayList<>(List.of(new Order(1, new ArrayList<Product>(List.of(new Product(1, "Apfel"))))));
        OrderRepo orderRepo = new OrderRepo(orders);
        // WHEN
        List<Order> actual = orderRepo.list();
        // THEN
        Assertions.assertEquals(orders ,actual);
    }

    @Test
    void getOrderRepo() {
        // GIVEN
        List<Order> orders = new ArrayList<>(List.of(new Order(1, new ArrayList<Product>(List.of(new Product(1, "Apfel"))))));
        OrderRepo orderRepo = new OrderRepo(orders);
        // WHEN
        Order actual = orderRepo.get(1);
        // THEN
        Assertions.assertEquals(new Order(1, new ArrayList<Product>(List.of(new Product(1, "Apfel")))), actual);
    }

    @Test
    void addOrderRepo() {
        // GIVEN
        List<Order> orders = new ArrayList<>(List.of(new Order(1, new ArrayList<Product>(List.of(new Product(1, "Apfel"))))));
        OrderRepo orderRepo = new OrderRepo(orders);
        Order order = new Order(1, new ArrayList<Product>(List.of(new Product(2, "Kirsche"))));
        // WHEN
        orderRepo.add(order);
        // THEN
        Assertions.assertEquals(new ArrayList<>(List.of(new Order(1, new ArrayList<Product>(List.of(new Product(1, "Apfel")))),
                new Order(1, new ArrayList<Product>(List.of(new Product(2, "Kirsche")))))), orderRepo.list());
    }

    // 5) Test für ShopService Klasse
    @Test
    void getProductShopService() {
        // GIVEN
        OrderRepo orderRepo = new OrderRepo(new ArrayList<>(List.of(new Order(1, new ArrayList<Product>(List.of(new Product(1, "Apfel")))))));
        ProductRepo productRepo = new ProductRepo(new ArrayList<>(List.of(new Product(1, "Apfel"))));
        ShopService shopService = new ShopService(orderRepo,productRepo);
        // WHEN
        Product actual = shopService.getProduct(1);
        // THEN
        Assertions.assertEquals(new Product(1, "Apfel"), actual);
    }

    @Test
    void listProductsShopService() {
        // GIVEN
        OrderRepo orderRepo = new OrderRepo(new ArrayList<>(List.of(new Order(1, new ArrayList<Product>(List.of(new Product(1, "Apfel")))))));
        ProductRepo productRepo = new ProductRepo(new ArrayList<>(List.of(new Product(1, "Apfel"))));
        ShopService shopService = new ShopService(orderRepo,productRepo);
        // WHEN
        List<Product> actual = shopService.ListProducts();
        // THEN
        Assertions.assertEquals(new ArrayList<>(List.of(new Product(1, "Apfel"))), actual);
    }

    @Test
    void addOrderShopService() {
        // GIVEN
        OrderRepo orderRepo = new OrderRepo(new ArrayList<>(List.of(new Order(1, new ArrayList<Product>(List.of(new Product(1, "Apfel")))))));
        ProductRepo productRepo = new ProductRepo(new ArrayList<>(List.of(new Product(1, "Apfel"), new Product(2, "Kirsche"))));
        OrderRepo orderRepoExpected = new OrderRepo(new ArrayList<Order>(List.of(new Order(1, new ArrayList<Product>(List.of(new Product(1, "Apfel")))),(new Order(2, new ArrayList<Product>(List.of(new Product(2, "Kirsche"))))))));
        ShopService shopService = new ShopService(orderRepo,productRepo);
        // WHEN
        shopService.addOrder(new Order(2, new ArrayList<Product>(List.of(new Product(2, "Kirsche")))));
        // THEN
        Assertions.assertEquals(orderRepoExpected.toString(),orderRepo.toString());
    }

    @Test
    void getOrderShopService(){
        // GIVEN
        OrderRepo orderRepo = new OrderRepo(new ArrayList<>(List.of(new Order(1, new ArrayList<Product>(List.of(new Product(1, "Apfel")))))));
        ProductRepo productRepo = new ProductRepo(new ArrayList<>(List.of(new Product(1, "Apfel"))));
        ShopService shopService = new ShopService(orderRepo,productRepo);
        Order orderExpected = new Order(1, new ArrayList<Product>(List.of(new Product(1, "Apfel"))));
        // WHEN
        Order actual = shopService.getOrder(1);
        // THEN
        Assertions.assertEquals(orderExpected.toString(), actual.toString());
    }

    @Test
    void listOrdersShopService() {
        // GIVEN
        OrderRepo orderRepo = new OrderRepo(new ArrayList<>(List.of(new Order(1, new ArrayList<Product>(List.of(new Product(1, "Apfel")))))));
        ProductRepo productRepo = new ProductRepo(new ArrayList<>(List.of(new Product(1, "Apfel"))));
        ShopService shopService = new ShopService(orderRepo,productRepo);
        List <Order> listExpected = new ArrayList<>(List.of(new Order(1, new ArrayList<Product>(List.of(new Product(1, "Apfel"))))));
        // WHEN
        List<Order> actual = shopService.listOrders();
        // THEN
        Assertions.assertEquals(listExpected.toString(), actual.toString());
    }

    @Test
    void addOrderWithProductsThatDontExistsInRepo(){
        // GIVEN
        List<Product> produktsToBeOrder = List.of(new Product(1, "Apfel"), new Product(2, "Brine"));
        ProductRepo productRepo = new ProductRepo(List.of(new Product(1, "Apfel")));
        OrderRepo orderRepo = new OrderRepo();
        ShopService shopService = new ShopService(orderRepo, productRepo);
        Order order = new Order(1, produktsToBeOrder);
        try {
            // WHEN
            shopService.addOrder(order);
            Assertions.fail();
        } catch (IndexOutOfBoundsException e) {
            // THEN
            System.out.println(e.getMessage());
            Assertions.assertTrue(true);
        }
    }

    /*
    void giveMeAllProductsButAddThemBefore() {
        // GIVEN
        ProductRepo productRepo = new ProductRepo();
        List<Product> products = new ArrayList<>();
        Product apple = new Product(1, "Apfel");
        Product pear = new Product(2, "Brine");
        products.add(apple);
        products.add(pear);

        productRepo.setProducts(products);
        // WHEN
        List<Product> productsInShop = productRepo.list();
        // THEN
        Assertions.assertEquals(products, productsInShop);
    }

    @Test //Bestellung aufgeben
    void addProductToProductRepoToString() {
        // GIVEN
        ProductRepo productRepo = new ProductRepo();
        List<Product> products = new ArrayList<>();
        Product apple = new Product(1, "Apfel");
        Product pear = new Product(2, "Brine");
        products.add(apple);
        products.add(pear);
        // WHEN
        productRepo.setProducts(products);
        // THEN
        Assertions.assertEquals(products, productRepo.list());

    }

    @Test
    void addOrderToOrderRepo(){
        // GIVEN
        List<Product> productList1 = List.of(new Product(1, "Apfel"));
        List<Product> productList2 = List.of(new Product(2, "Brine"));
        List<Product> productList3 = List.of(new Product(1, "Apfel"),new Product(2, "Brine"));

        List<Order> orderList1 = new ArrayList<>(List.of(new Order(1, productList1)));
        List<Order> orderList2 = new ArrayList<>(List.of(new Order(1, productList1),new Order(2, productList2)));
        Order order = new Order(2, productList2);

        OrderRepo orderRepo1 = new OrderRepo(orderList1);
        OrderRepo orderRepo2 = new OrderRepo(orderList2);

        ProductRepo productRepo = new ProductRepo(productList3);

        ShopService shopService1 = new ShopService(orderRepo1, productRepo);
        // WHEN
        shopService1.addOrder(order);
        // THEN
        Assertions.assertEquals(orderRepo2.list(), orderRepo1.list());
    }
     */


}
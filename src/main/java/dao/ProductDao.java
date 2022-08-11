package dao;

import model.Product;

import java.util.List;

public interface ProductDao {
    Product get(String productName);
    List<Product> getAll();
    void update(Product product);
    void add(Product product);
}

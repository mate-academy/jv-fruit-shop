package dao;

import java.util.List;
import model.Product;

public interface ProductDao {
    Product get(String productName);

    List<Product> getAll();

    void update(Product product);

    void add(Product product);
}

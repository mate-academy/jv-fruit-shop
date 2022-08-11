package dao;

import db.Storage;
import model.Product;

import java.util.List;
import java.util.Objects;

public class ProductDaoImpl implements ProductDao{

    @Override
    public Product get(String productName) {
        return Storage.products.stream()
                .filter(p -> Objects.equals(p.getProductName(), productName))
                .findFirst().get();
    }

    @Override
    public List<Product> getAll() {
        return Storage.products;
    }

    @Override
    public void update(Product product) {
        Product productToRemove = get(product.getProductName());
        Storage.products.remove(productToRemove);
        Storage.products.add(product);
    }

    @Override
    public void add(Product product) {
        Storage.products.add(product);
    }
}

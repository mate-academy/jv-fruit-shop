package dao;

import db.Storage;
import java.util.List;
import model.ProductAccount;

public class ProductAccountDaoImpl implements ProductAccountDao {
    private Storage db;

    public ProductAccountDaoImpl(Storage db) {

        this.db = db;
    }

    @Override
    public void add(ProductAccount product) {
        db.products.add(product);
    }

    @Override
    public ProductAccount get(String productName) {
        if (db.products.stream().filter(a -> a.getName().equals(productName)).count() == 0) {
            return null;
        }
        return db.products.stream()
                .filter(a -> a.getName().equals(productName))
                .findFirst().get();
    }

    @Override
    public void update(ProductAccount product) {
        ProductAccount productFromDb = get(product.getName());
        db.products.remove(productFromDb);
        add(product);
    }

    @Override
    public List<ProductAccount> getBalance() {
        return db.products;
    }
}

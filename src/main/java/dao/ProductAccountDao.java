package dao;

import java.util.List;
import model.ProductAccount;

public interface ProductAccountDao {

    void add(ProductAccount product);

    ProductAccount get(String productName);

    void update(ProductAccount product);

    List<ProductAccount> getBalance();
}

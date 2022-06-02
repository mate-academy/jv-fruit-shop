package dao;

import java.util.List;
import java.util.Optional;
import model.ProductAccount;

public interface ProductAccountDao {

    void add(ProductAccount product);

    Optional<ProductAccount> get(String productName);

    void update(ProductAccount product);

    List<ProductAccount> getBalance();
}

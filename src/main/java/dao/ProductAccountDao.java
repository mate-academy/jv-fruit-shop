package dao;

import java.util.List;
import model.ProductAccount;

public interface ProductAccountDao {

    public void add(ProductAccount product);

    public ProductAccount get(String productName);

    public void update(ProductAccount product);

    public List<ProductAccount> getBalance();
}

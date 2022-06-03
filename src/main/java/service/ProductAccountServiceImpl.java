package service;

import dao.ProductAccountDaoImpl;
import model.ProductAccount;

public class ProductAccountServiceImpl implements ProductAccountService {
    private ProductAccountDaoImpl dao;

    public ProductAccountServiceImpl(ProductAccountDaoImpl dao) {
        this.dao = dao;
    }

    @Override
    public void createNewProduct(String productname) {
        ProductAccount product = new ProductAccount(productname);
        dao.add(product);
    }
}

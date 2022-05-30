package service;

import dao.ProductAccountDaoImpl;
import model.ProductAccount;

public class ShopServiceImpl implements ShopService {
    private ProductAccountDaoImpl dao;
    private AmountStrategy amountStrategy;

    public ShopServiceImpl(ProductAccountDaoImpl dao, AmountStrategy amountStrategy) {
        this.dao = dao;
        this.amountStrategy = amountStrategy;
    }

    @Override
    public void productTransaction(String productname, Double productAmount,Operation operation) {
        ProductAccount productFromDb = dao.get(productname);
        if (productFromDb == null) {
            (new ProductAccountServiceImpl(dao)).createNewProduct(productname);
            productFromDb = dao.get(productname);
        }
        productFromDb.setAmount(productFromDb.getAmount() + productAmount);
        dao.update(productFromDb);
    }

}

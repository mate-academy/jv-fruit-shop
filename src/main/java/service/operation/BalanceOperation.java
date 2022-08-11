package service.operation;

import dao.ProductDao;
import dao.ProductDaoImpl;
import model.Product;
import service.ProductTransaction;

public class BalanceOperation implements Operation {
    private final ProductDao productDao = new ProductDaoImpl();

    @Override
    public void doOperation(ProductTransaction transaction) {
        Product newProduct = new Product(transaction.getProductName(), transaction.getQuantity());
        productDao.add(newProduct);
    }
}

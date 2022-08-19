package services.operation;

import dao.ProductDao;
import model.Product;
import services.transaction.model.ProductTransaction;

public class BalanceOperation implements OperationHandler {
    private final ProductDao productDao;

    public BalanceOperation(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void handle(ProductTransaction transaction) {
        Product newProduct = new Product(transaction.getProductName(), transaction.getQuantity());
        productDao.add(newProduct);
    }
}

package services.operation;

import dao.ProductDao;
import model.Product;
import services.transaction.model.ProductTransaction;

public class PurchaseOperation implements OperationHandler {
    private final ProductDao productDao;

    public PurchaseOperation(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public void handle(ProductTransaction transaction) {
        int newQuantity = productDao.get(transaction.getProductName()).getCount()
                    - transaction.getQuantity();
        productDao.update(new Product(transaction.getProductName(), newQuantity));
    }
}

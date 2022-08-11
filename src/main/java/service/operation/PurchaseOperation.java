package service.operation;

import dao.ProductDao;
import dao.ProductDaoImpl;
import model.Product;
import service.ProductTransaction;

public class PurchaseOperation implements Operation {
    private final ProductDao productDao = new ProductDaoImpl();

    @Override
    public void doOperation(ProductTransaction transaction) {
        int newQuantity = productDao.get(transaction.getProductName()).getCount()
                    - transaction.getQuantity();

        productDao.update(new Product(transaction.getProductName(), newQuantity));
    }
}

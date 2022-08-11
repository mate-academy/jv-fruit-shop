package service.operation;

import dao.ProductDao;
import dao.ProductDaoImpl;
import model.Product;
import service.ProductTransaction;

public class ReturnOperation implements Operation {
    private final ProductDao productDao = new ProductDaoImpl();

    @Override
    public void doOperation(ProductTransaction transaction) {
        int newQuantity = transaction.getQuantity()
                + productDao.get(transaction.getProductName()).getProductCount();

        productDao.update(new Product(transaction.getProductName(), newQuantity));
    }
}

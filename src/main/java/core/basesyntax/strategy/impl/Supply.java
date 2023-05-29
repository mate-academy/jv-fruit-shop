package core.basesyntax.strategy.impl;

import core.basesyntax.dao.ProductDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationAnalysis;

public class Supply implements OperationAnalysis {
    private ProductDaoImpl productDao;

    public Supply (ProductDaoImpl productDao) {
        this.productDao = productDao;
    }
    @Override
    public void processing(FruitTransaction fruitTransaction) {
        int currentQuantity = productDao.calculateAmount(fruitTransaction);
        int newQuantity = currentQuantity + fruitTransaction.getQuantity();
        productDao.update(fruitTransaction, newQuantity);
    }
}

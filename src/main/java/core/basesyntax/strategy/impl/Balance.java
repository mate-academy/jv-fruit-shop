package core.basesyntax.strategy.impl;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.dao.ProductDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationAnalysis;

public class Balance implements OperationAnalysis {
    private ProductDaoImpl productDao;

    public Balance (ProductDaoImpl productDao) {
        this.productDao = productDao;
    }
    @Override
    public void processing(FruitTransaction fruitTransaction) {
        int currentQuantity = productDao.calculateAmount(fruitTransaction);
        int newQuantity = currentQuantity + fruitTransaction.getQuantity();
        productDao.update(fruitTransaction, newQuantity);
    }
}

package core.basesyntax.strategy.impl;

import core.basesyntax.dao.ProductDaoImpl;
import core.basesyntax.exception.InvalidOperatioExeption;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationAnalysis;

public class Purchase implements OperationAnalysis {
    private ProductDaoImpl productDao;

    public Purchase(ProductDaoImpl productDao) {
        this.productDao = productDao;
    }

    @Override
    public void processing(FruitTransaction fruitTransaction) {
        int currentQuantity = productDao.calculateAmount(fruitTransaction);
        if (currentQuantity < fruitTransaction.getQuantity()) {
            throw new InvalidOperatioExeption("Not enough product in stock now. In stock: "
                    + currentQuantity
                    + ", but your want: " + fruitTransaction.getQuantity());
        }
        int newQuantity = currentQuantity - fruitTransaction.getQuantity();
        productDao.update(fruitTransaction, newQuantity);
    }
}

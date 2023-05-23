package core.basesyntax.strategy.impl;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.dao.ProductDaoImpl;
import core.basesyntax.model.Product;
import core.basesyntax.strategy.FruitTransaction;
import core.basesyntax.strategy.OperationProcessor;

public class SupplyProcessor implements OperationProcessor {
    private static final ProductDao<Product, Integer> dao = new ProductDaoImpl();

    @Override
    public void operate(FruitTransaction transaction) {
        transferToDb(transaction, balance(transaction));
    }

    private void transferToDb(FruitTransaction transaction, int balance) {
        dao.put(transaction.getFruit(), balance);
    }

    private int balance(FruitTransaction transaction) {
        return dao.get(transaction.getFruit()) == null
                ? transaction.getQuantity()
                : dao.get(transaction.getFruit()) + transaction.getQuantity();
    }
}

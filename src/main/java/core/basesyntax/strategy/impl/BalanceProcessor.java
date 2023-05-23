package core.basesyntax.strategy.impl;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.dao.ProductDaoImpl;
import core.basesyntax.model.Product;
import core.basesyntax.strategy.FruitTransaction;
import core.basesyntax.strategy.OperationProcessor;

public class BalanceProcessor implements OperationProcessor {
    private static final ProductDao<Product, Integer> dao = new ProductDaoImpl();

    @Override
    public void operate(FruitTransaction transaction) {
        transferToDb(transaction, balance(transaction));
    }

    private void transferToDb(FruitTransaction transaction, int balance) {
        dao.put(transaction.getFruit(), balance);
    }

    private int balance(FruitTransaction transaction) {
        int previousVal = dao.get(transaction.getFruit()) == null
                ? 0 : dao.get(transaction.getFruit());
        checkBalance(transaction, previousVal);
        return previousVal + transaction.getQuantity();
    }

    private void checkBalance(FruitTransaction transaction, int previousVal) {
        if ((previousVal + transaction.getQuantity()) < 0) {
            throw new RuntimeException("That transaction in: "
                    + getClass().getSimpleName()
                    + " with value [" + transaction.getQuantity()
                    + "] provide a negative balance.");
        }
    }
}

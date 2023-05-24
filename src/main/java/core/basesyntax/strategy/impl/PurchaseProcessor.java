package core.basesyntax.strategy.impl;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.dao.ProductDaoImpl;
import core.basesyntax.model.Product;
import core.basesyntax.strategy.FruitTransaction;
import core.basesyntax.strategy.OperationProcessor;

public class PurchaseProcessor implements OperationProcessor {
    private static final ProductDao<Product, Integer> dao = new ProductDaoImpl();

    @Override
    public void operate(FruitTransaction transaction) {
        int previousValue = dao.get(transaction.getFruit()) == null
                ? 0 : dao.get(transaction.getFruit());
        checkBalance(transaction, previousValue);
        dao.put(transaction.getFruit(), previousValue - transaction.getQuantity());
    }

    private void checkBalance(FruitTransaction transaction, int previousValue) {
        if (transaction.getQuantity() < 0) {
            throw new RuntimeException("That transaction with value ["
                    + transaction.getQuantity()
                    + "] invalid, value have to be positive.");
        }
        if ((previousValue - transaction.getQuantity()) < 0) {
            throw new RuntimeException("That transaction with value ["
                    + transaction.getQuantity()
                    + "] provide a negative balance.");
        }
    }
}

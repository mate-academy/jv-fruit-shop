package core.basesyntax.strategy.impl;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.dao.ProductDaoImpl;
import core.basesyntax.model.Product;
import core.basesyntax.strategy.FruitTransaction;
import core.basesyntax.strategy.OperationProcessor;

public class ReturnProcessor implements OperationProcessor {
    private static final ProductDao<Product, Integer> dao = new ProductDaoImpl();

    @Override
    public void operate(FruitTransaction transaction) {
        checkTransactionValue(transaction);
        int previousValue = dao.get(transaction.getFruit()) == null
                ? 0 : dao.get(transaction.getFruit());
        dao.put(transaction.getFruit(), previousValue + transaction.getQuantity());
    }

    private void checkTransactionValue(FruitTransaction transaction) {
        if (transaction.getQuantity() < 0) {
            throw new RuntimeException("That transaction with value ["
                    + transaction.getQuantity()
                    + "] invalid, value have to be positive.");
        }
    }
}

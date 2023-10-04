package core.basesyntax.strategy.impl;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.exeptions.InvalidTransaction;
import core.basesyntax.model.Product;
import core.basesyntax.strategy.FruitTransaction;
import core.basesyntax.strategy.OperationProcessor;

public class ReturnProcessor implements OperationProcessor {
    private final ProductDao<Product, Integer> dao;

    public ReturnProcessor(ProductDao<Product, Integer> dao) {
        this.dao = dao;
    }

    @Override
    public void operate(FruitTransaction transaction) {
        checkTransactionValue(transaction);
        int previousValue = dao.get(transaction.getFruit()) == null
                ? 0 : dao.get(transaction.getFruit());
        dao.put(transaction.getFruit(), previousValue + transaction.getQuantity());
    }

    private void checkTransactionValue(FruitTransaction transaction) {
        if (transaction.getQuantity() < 0) {
            throw new InvalidTransaction("That transaction with value ["
                    + transaction.getQuantity()
                    + "] invalid, value have to be positive.");
        }
    }
}

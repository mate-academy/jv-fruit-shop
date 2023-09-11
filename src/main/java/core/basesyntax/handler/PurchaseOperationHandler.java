package core.basesyntax.handler;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    private final FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void process(FruitTransaction transaction) {
        int amount = fruitDao.get(transaction.getFruit());
        int quantity = transaction.getQuantity();
        if (amount < quantity) {
            throw new RuntimeException(
                    getErrorMessage(transaction.getFruit(), amount, quantity)
            );
        }
        fruitDao.add(transaction.getFruit(), amount - quantity);
    }

    private String getErrorMessage(String fruit, int amount, int quantity) {
        return String.format(
                "The store does not contain enough %s. "
                + "You want to purchase %d and only %d are available in stock.",
                fruit, quantity, amount);
    }
}

package core.basesyntax.handler;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;

public class PurchaseTransaction implements TransactionHandler {
    private final FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public void apply(FruitTransaction transaction) {
        int amount = fruitDao.get(transaction.getFruitName());
        int quantity = transaction.getAmount();

        if (amount < quantity) {
            throw new RuntimeException(
                    getErrorMessage(transaction.getFruitName(), amount, quantity)
            );
        }
        fruitDao.add(transaction.getFruitName(), amount - quantity);
    }

    private String getErrorMessage(String fruit, int amount, int quantity) {
        return String.format(
                "The store does not contain enough %s. "
                        + "You want to purchase %d and only %d are available in stock.",
                fruit, quantity, amount);
    }
}

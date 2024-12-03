package core.basesyntax.operation;

import core.basesyntax.db.FruitDao;
import core.basesyntax.transaction.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    private final FruitDao fruitDao;

    public BalanceOperation(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(FruitTransaction fruitTransaction) {
        InputValidator.unexpectedNullOrEmptyFields(fruitTransaction);
        String fruitName = fruitTransaction.getFruitName();
        int quantityOfFruit = fruitTransaction.getQuantity();
        fruitDao.saveOrUpdate(fruitName, quantityOfFruit);
    }
}

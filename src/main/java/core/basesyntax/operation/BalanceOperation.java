package core.basesyntax.operation;

import static core.basesyntax.operation.InvalidInputFields.invalidInputFields;

import core.basesyntax.db.FruitDao;
import core.basesyntax.transaction.FruitTransaction;

public class BalanceOperation implements OperationHandler {
    private final FruitDao fruitDao;

    public BalanceOperation(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(FruitTransaction fruitTransition) {
        String fruitName = fruitTransition.getFruitName();
        int quantityOfFruit = fruitTransition.getQuantity();
        invalidInputFields(fruitTransition);
        fruitDao.addOrUpdateFruitToStorage(fruitName, quantityOfFruit);
    }
}

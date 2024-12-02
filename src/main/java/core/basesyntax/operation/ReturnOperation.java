package core.basesyntax.operation;

import static core.basesyntax.operation.InvalidInputFields.invalidInputFields;

import core.basesyntax.db.FruitDao;
import core.basesyntax.transaction.FruitTransaction;

public class ReturnOperation implements OperationHandler {
    private final FruitDao fruitDao;

    public ReturnOperation(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void apply(FruitTransaction fruitTransition) {
        invalidInputFields(fruitTransition);
        String fruitName = fruitTransition.getFruitName();
        Integer fruitQuantity = fruitDao.getFruitQuantity(fruitName);
        int fruitTransitionQuantity = fruitTransition.getQuantity();
        Integer returnResult = fruitQuantity + fruitTransitionQuantity;
        fruitDao.addOrUpdateFruitToStorage(fruitName, returnResult);
    }
}

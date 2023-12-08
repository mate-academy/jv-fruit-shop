package core.basesyntax.strategy.operationhandlers;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public record ReturnOperation(FruitDao fruitDao) implements OperationsHandler {
    private static final String RETURN_OPERATION_CANT_GIVE_NEGATIVE_RESULT = "Smt went wrong!"
            + "Return operation can't give negative result";

    @Override
    public void handler(FruitTransaction fruitTransaction) {
        Integer newBalance = calculateReturnResult(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity());
        fruitDao.putToStorage(fruitTransaction.getFruit(), newBalance);
    }

    private int calculateReturnResult(String fruit, int quantity) {
        int currentBalance = fruitDao.getQualityByObjectType(fruit);
        int newBalance = currentBalance + quantity;
        if (newBalance < 0) {
            throw new RuntimeException(RETURN_OPERATION_CANT_GIVE_NEGATIVE_RESULT);
        }
        return newBalance;
    }
}

package core.basesyntax.strategy.operationhandlers;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public record PurchaseOperation(FruitDao fruitDao) implements OperationsHandler {
    private static final String PURSE_OPERATION_CANT_GIVE_NEGATIVE_RESULT = "Smthing went wrong!"
            + "Purse operation can't give negative result";

    @Override
    public void handler(FruitTransaction fruitTransaction) {
        Integer newBalance = calculateNewBalance(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity());
        fruitDao.putToStorage(fruitTransaction.getFruit(), newBalance);
    }

    private int calculateNewBalance(String fruit, int quantity) {
        int currentBalance = fruitDao.getQualityByObjectType(fruit);
        int newBalance = currentBalance - quantity;
        if (newBalance < 0) {
            throw new RuntimeException(PURSE_OPERATION_CANT_GIVE_NEGATIVE_RESULT);
        }
        return newBalance;
    }
}

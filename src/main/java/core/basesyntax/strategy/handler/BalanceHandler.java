package core.basesyntax.strategy.handler;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;

public class BalanceHandler implements OperationHandler {
    private FruitDao dataBase;

    public BalanceHandler(FruitDao fruitDao) {
        this.dataBase = fruitDao;
    }

    @Override
    public boolean handle(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruit();
        int fruitQuantity = fruitTransaction.getQuantity();
        dataBase.getStorage().put(fruitName, fruitQuantity);
        return true;
    }
}

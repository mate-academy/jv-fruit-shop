package homework.strategy.handler;

import static homework.storage.Storage.dataBase;

import homework.model.FruitTransaction;

public class BalanceOperationHandlerImpl implements OperationHandler {
    @Override
    public void apply(FruitTransaction fruitTransaction) {
        dataBase.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}

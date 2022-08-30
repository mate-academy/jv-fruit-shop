package homework.strategy.handler;

import static homework.storage.Storage.dataBase;

import homework.service.impl.FruitTransaction;

public class BalanceOperationHandlerImpl implements OperationHandler {
    @Override
    public void apply(FruitTransaction fruitTransaction) {
        dataBase.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}

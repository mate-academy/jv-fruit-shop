package strategy.handler;

import static storage.Storage.dataBase;

import model.FruitTransaction;

public class BalanceOperationHandlerImpl implements OperationHandler {
    @Override
    public void apply(FruitTransaction fruitTransaction) {
        dataBase.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}

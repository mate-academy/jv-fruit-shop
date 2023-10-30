package operation;

import model.FruitTransaction;

import static storages.FruitStorage.fruitQuantity;

public class BalanceOperationHandlerImpl implements OperationHandler {
    @Override
    public void perform(FruitTransaction fruitTransaction) {
        fruitQuantity.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}

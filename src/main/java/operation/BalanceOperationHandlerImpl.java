package operation;

import static storages.FruitStorage.fruitQuantity;

import model.FruitTransaction;

public class BalanceOperationHandlerImpl implements OperationHandler {
    @Override
    public void perform(FruitTransaction fruitTransaction) {
        fruitQuantity.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
    }
}

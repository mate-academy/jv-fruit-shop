package operation;

import model.FruitTransaction;

import static storages.FruitStorage.fruitQuantity;

public class PurchaseOperationHandlerImpl implements OperationHandler {
    @Override
    public void perform(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int currentQuantity = fruitQuantity.get(fruit);
        fruitQuantity.replace(fruit, currentQuantity - fruitTransaction.getQuantity());
    }
}

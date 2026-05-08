package operation;

import Storage.Storage;

public class BalanceOperation implements OperationHandler {

    @Override
    public void handle(String fruit, int quantity) {
        Storage.getInstance().getFruitStorage().put(fruit, quantity);
    }
}

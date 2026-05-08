package operation;

import Storage.Storage;

public class ReturnOperation implements OperationHandler {

    @Override
    public void handle(String fruit, int quantity) {
            Integer fruitFromStorage = Storage.getInstance().getFruitStorage().get(fruit);
            Integer newFruitQuantity = fruitFromStorage += quantity;
            Storage.getInstance().getFruitStorage().put(fruit, newFruitQuantity);
        }
    }


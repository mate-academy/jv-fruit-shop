package core.basesyntax.service.operation;

import core.basesyntax.Main;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void process(String fruitName, int fruitQuantity) {
        Main.fruitMap.put(
                fruitName, Main.fruitMap.getOrDefault(
                        fruitName, 0) - fruitQuantity);

    }
}

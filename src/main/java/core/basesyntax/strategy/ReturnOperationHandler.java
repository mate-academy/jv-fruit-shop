package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransfer;
import core.basesyntax.storage.Storage;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void process(FruitTransfer fruitTransfer) {
        Integer quantity = Storage.fruits.get(fruitTransfer.getFruit());
        Storage.fruits.put(fruitTransfer.getFruit(), quantity == null
                ? fruitTransfer.getQuantity()
                : fruitTransfer.getQuantity() + quantity);
    }
}

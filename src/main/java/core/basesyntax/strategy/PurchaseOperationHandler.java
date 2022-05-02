package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransfer;
import core.basesyntax.storage.Storage;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void process(FruitTransfer fruitTransfer) {
        Integer quantity = Storage.fruits.get(fruitTransfer.getFruit());
        if (quantity == null || quantity < fruitTransfer.getQuantity()) {
            throw new RuntimeException("Not enough fruit");
        }
        Storage.fruits.put(fruitTransfer.getFruit(), quantity - fruitTransfer.getQuantity());
    }
}

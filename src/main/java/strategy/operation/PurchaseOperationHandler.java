package strategy.operation;

import db.Storage;
import java.util.Optional;
import model.FruitTransaction;
import strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Integer oldSum = Optional.ofNullable(Storage.fruits.get(fruitTransaction.getFruit()))
                .orElseThrow(() -> new RuntimeException("Invalid data. "
                        + fruitTransaction.getFruit().substring(0,1).toUpperCase()
                        + fruitTransaction.getFruit().substring(1)
                        + " is not present in the storage"));
        if (oldSum <= 0) {
            throw new RuntimeException("Invalid data. Quantity can't be " + oldSum);
        } else if (oldSum < fruitTransaction.getQuantity()) {
            throw new RuntimeException("Can't sell " + fruitTransaction.getFruit()
                     + " because quantity of it in the storage equals: " + oldSum);
        }
        Storage.fruits.put(fruitTransaction.getFruit(), oldSum - fruitTransaction.getQuantity());
    }
}

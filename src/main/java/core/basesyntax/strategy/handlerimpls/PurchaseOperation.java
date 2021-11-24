package core.basesyntax.strategy.handlerimpls;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.TransactionDto;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.handler.OperationHandler;

public class PurchaseOperation implements OperationHandler {
    @Override
    public boolean apply(TransactionDto transactionDto) {
        Fruit fruit = new Fruit(transactionDto.getName());
        int currentQuantity = Storage.storage.get(fruit);
        int newQuantity = currentQuantity - transactionDto.getQuantity();
        if (newQuantity < 0) {
            throw new RuntimeException("Fruit shop haven't this amount of: "
                    + transactionDto.getName() + "s");
        }
        Storage.storage.put(fruit, newQuantity);
        return true;
    }
}

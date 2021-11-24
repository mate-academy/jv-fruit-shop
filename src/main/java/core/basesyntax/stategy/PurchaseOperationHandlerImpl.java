package core.basesyntax.stategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;

public class PurchaseOperationHandlerImpl implements OperationHandler {
    @Override
    public void apply(TransactionDto transactionDto) {
        Fruit fruit = new Fruit(transactionDto.getFruitName());
        int quantity = transactionDto.getQuantity();
        Integer oldQuantity = Storage.getDataBase().getOrDefault(fruit, 0);
        if (quantity > oldQuantity) {
            throw new RuntimeException("Sorry you can't buy more fruit than we have");
        }
        int newQuantity = oldQuantity - quantity;
        Storage.getDataBase().put(fruit, newQuantity);
    }
}

package core.basesyntax.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.Transaction;
import core.basesyntax.model.Fruit;

public class RemoveOperationHandler implements OperationHandler {
    @Override
    public int apply(Transaction transactionDto) {
        Fruit fruit = new Fruit(transactionDto.getName());
        int newQuantity = Storage.fruitStorage.getOrDefault(fruit, 0)
                - transactionDto.getQuantity();
        if (newQuantity < 0) {
            throw new RuntimeException("We don't have enough fruit");
        }
        Storage.fruitStorage.put(fruit, newQuantity);
        return newQuantity;
    }
}

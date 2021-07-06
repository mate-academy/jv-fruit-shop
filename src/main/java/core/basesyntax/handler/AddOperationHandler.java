package core.basesyntax.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.Transaction;
import core.basesyntax.model.Fruit;

public class AddOperationHandler implements OperationHandler {
    @Override
    public int apply(Transaction transactionDto) {
        Fruit fruit = new Fruit(transactionDto.getName());
        int newQuantity = Storage.fruitStorage.getOrDefault(fruit, 0)
                + transactionDto.getQuantity();
        Storage.fruitStorage.put(fruit, newQuantity);
        return newQuantity;
    }
}

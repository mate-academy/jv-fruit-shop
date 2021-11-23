package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;

public class AddOperationHandler implements OperationHandler {
    @Override
    public boolean apply(TransactionDto transactionDto) {
        Fruit fruit = new Fruit(transactionDto.getFruit().getName());
        int oldQuantity = Storage.storage.get(fruit) == null ? 0 : Storage.storage.get(fruit);
        int newQuantity = transactionDto.getQuantity() + oldQuantity;
        Storage.storage.put(fruit, newQuantity);
        return true;
    }
}

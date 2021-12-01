package core.basesyntax.strategy.handlerimpls;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.TransactionDto;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.handler.OperationHandler;

public class AddOperation implements OperationHandler {
    @Override
    public boolean apply(TransactionDto transactionDto) {
        Fruit fruit = new Fruit(transactionDto.getName());
        int currentQuantity = Storage.storage.get(fruit);
        int newQuantity = currentQuantity + transactionDto.getQuantity();
        Storage.storage.put(fruit, newQuantity);
        return true;
    }
}

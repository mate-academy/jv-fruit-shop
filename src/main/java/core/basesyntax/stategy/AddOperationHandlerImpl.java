package core.basesyntax.stategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;

public class AddOperationHandlerImpl implements OperationHandler {
    @Override
    public void apply(TransactionDto transactionDto) {
        Fruit fruit = new Fruit(transactionDto.getFruitName());
        int quantity = transactionDto.getQuantity();
        Integer oldQuantity = Storage.getDataBase().get(fruit);
        if (Storage.getDataBase().get(fruit) == null) {
            oldQuantity = 0;
        }
        int newQuantity = quantity + oldQuantity;
        Storage.getDataBase().put(fruit, newQuantity);
    }
}

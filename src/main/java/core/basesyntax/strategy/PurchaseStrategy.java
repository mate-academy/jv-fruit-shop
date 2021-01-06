package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;

public class PurchaseStrategy implements OperationStrategy {
    @Override
    public void apply(TransactionDto transactionDto) {
        Fruit fruit = transactionDto.getFruit();
        int quantity = Storage.fruitReport.get(fruit) == null
                ? -transactionDto.getQuantity()
                : Storage.fruitReport.get(fruit) - transactionDto.getQuantity();
        if (quantity < 0) {
            throw new RuntimeException("Not enough fruit " + fruit);
        }
        Storage.fruitReport.put(fruit, quantity);
    }
}

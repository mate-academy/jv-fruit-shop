package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;

public class ReturnStrategy implements OperationStrategy {
    @Override
    public void apply(TransactionDto transactionDto) {
        Fruit fruit = transactionDto.getFruit();
        int quality = Storage.fruitReport.get(fruit) == null
                ? transactionDto.getQuantity()
                : Storage.fruitReport.get(fruit) + transactionDto.getQuantity();
        Storage.fruitReport.put(fruit, quality);
    }
}

package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void apply(TransactionDto transactionDto) {
        Fruit fruit = new Fruit(transactionDto.getFruit());
        if (Storage.fruitStorage.get(fruit) == null) {
            throw new RuntimeException("Fruit is absent, you cannot make a purchase!");
        }
        if (transactionDto.getAmount() > Storage.fruitStorage.get(fruit)) {
            throw new RuntimeException("Not enough fruit for this operation");
        }
        Storage.fruitStorage.merge(fruit, -transactionDto.getAmount(), Integer::sum);
    }
}

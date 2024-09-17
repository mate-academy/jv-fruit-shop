package core.basesyntax.service.operations.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.operations.OperationHandler;

public class BalanceOperationHandler implements OperationHandler {
    private final Storage storage;

    public BalanceOperationHandler(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void apply(FruitTransactionDto dto) {
        String fruitName = dto.fruitName();
        int quantity = dto.quantity();
        storage.addFruit(new Fruit(fruitName), quantity);
    }
}

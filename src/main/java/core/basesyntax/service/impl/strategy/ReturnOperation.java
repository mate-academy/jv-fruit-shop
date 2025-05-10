package core.basesyntax.service.impl.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.service.OperationHandler;

public class ReturnOperation implements OperationHandler {
    @Override
    public void handle(FruitTransactionDto fruitTransactionDto) {
        String requiredFruit = fruitTransactionDto.fruit();
        int quantity = Storage.fruitStorage.get(requiredFruit);
        Storage.fruitStorage.put(requiredFruit,
                quantity + fruitTransactionDto.quantity());
    }
}

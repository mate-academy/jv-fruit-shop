package core.basesyntax.service.impl.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.service.OperationHandler;

public class SupplyOperation implements OperationHandler {
    @Override
    public void handle(FruitTransactionDto fruitTransactionDto) {
        String requiredFruit = fruitTransactionDto.fruit();
        int quantity = Storage.fruitStorage.get(requiredFruit);

        if (quantity > 0) {
            Storage.fruitStorage.put(requiredFruit,
                    quantity + fruitTransactionDto.quantity());
        } else {
            Storage.fruitStorage.put(requiredFruit, fruitTransactionDto.quantity());
        }
    }
}

package core.basesyntax.operation;

import core.basesyntax.db.FruitsStorage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;

public class SupplyHandler implements ShopOperationHandler {
    @Override
    public Integer getOperationResult(TransactionDto transactionDto) {
        Fruit fruit = transactionDto.getFruitName();
        Integer availableFruits = FruitsStorage.fruitsStorage.get(fruit);
        Integer requiredFruits = transactionDto.getAmount();
        int result = availableFruits + requiredFruits;
        FruitsStorage.fruitsStorage.put(fruit, result);
        return result;
    }
}

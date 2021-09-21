package core.basesyntax.service.operation;

import core.basesyntax.db.FruitsStorage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;
import java.util.Map;

public class PurchaseHandler implements ShopOperationHandler {
    @Override
    public Map<Fruit, Integer> getOperationResult(TransactionDto transactionDto) {
        Fruit fruit = new Fruit(String.valueOf(transactionDto.getFruitName()));
        FruitsStorage.fruitsStorage.put(fruit,
                FruitsStorage.fruitsStorage.getOrDefault(fruit, 0) - transactionDto.getAmount());
        return FruitsStorage.fruitsStorage;
    }
}

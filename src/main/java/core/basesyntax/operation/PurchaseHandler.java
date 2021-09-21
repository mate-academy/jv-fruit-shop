package core.basesyntax.operation;

import core.basesyntax.db.FruitsStorage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;
import java.util.Map;

public class PurchaseHandler implements ShopOperationHandler {
    @Override
    public Map<Fruit, Integer> getOperationResult(TransactionDto transactionDto) {
        Fruit fruit = new Fruit(String.valueOf(transactionDto.getFruitName()));
        Integer requiredFruits = transactionDto.getAmount();
        Integer availableFruits = FruitsStorage.fruitsStorage.get(fruit);
        if (availableFruits < requiredFruits) {
            throw new RuntimeException("There are not enough fruits in storage");
        }
        FruitsStorage.fruitsStorage.put(fruit,
                FruitsStorage.fruitsStorage.getOrDefault(fruit, 0) - transactionDto.getAmount());
        return FruitsStorage.fruitsStorage;
    }
}

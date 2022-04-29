package core.basesyntax.operation;

import core.basesyntax.db.FruitsStorage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;

public class PurchaseHandler implements ShopOperationHandler {
    @Override
    public Integer getOperationResult(TransactionDto transactionDto) {
        Fruit fruit = new Fruit(String.valueOf(transactionDto.getFruitName()));
        Integer requiredFruits = transactionDto.getAmount();
        Integer availableFruits = FruitsStorage.fruitsStorage.get(fruit);
        if (availableFruits < requiredFruits) {
            throw new RuntimeException("There are not enough fruits in storage");
        }
        int result = availableFruits - requiredFruits;
        FruitsStorage.fruitsStorage.put(fruit, result);
        return result;
    }
}

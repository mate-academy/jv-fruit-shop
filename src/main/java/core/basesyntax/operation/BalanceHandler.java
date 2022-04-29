package core.basesyntax.operation;

import core.basesyntax.db.FruitsStorage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;

public class BalanceHandler implements ShopOperationHandler {
    @Override
    public Integer getOperationResult(TransactionDto transactionDto) {
        Fruit fruit = transactionDto.getFruitName();
        FruitsStorage.fruitsStorage.put(fruit, transactionDto.getAmount());
        return transactionDto.getAmount();
    }
}

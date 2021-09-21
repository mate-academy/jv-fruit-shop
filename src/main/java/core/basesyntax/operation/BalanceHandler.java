package core.basesyntax.operation;

import core.basesyntax.db.FruitsStorage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;
import java.util.Map;

public class BalanceHandler implements ShopOperationHandler {
    @Override
    public Map<Fruit, Integer> getOperationResult(TransactionDto transactionDto) {
        Fruit fruit = new Fruit(String.valueOf(transactionDto.getFruitName()));
        FruitsStorage.fruitsStorage.put(fruit, transactionDto.getAmount());
        return FruitsStorage.fruitsStorage;
    }
}

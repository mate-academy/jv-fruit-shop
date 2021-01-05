package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;
import java.util.Map;

public class ReductionStrategy implements OperationStrategy {
    @Override
    public void apply(TransactionDto transactionDto) {
        Integer quantity = transactionDto.getQuantity();
        if (!Storage.fruits.containsKey(transactionDto.getFruit())) {
            throw new RuntimeException("We can't sell a product if we don't have it!");
        }
        for (Map.Entry<Fruit, Integer> fruit: Storage.fruits.entrySet()) {
            if (fruit.getKey().equals(transactionDto.getFruit())) {
                quantity = fruit.getValue() - quantity;
                break;
            }
        }
        if (quantity < 0) {
            throw new RuntimeException("We don't have enough fruit: " + quantity);
        }
        Storage.fruits.put(transactionDto.getFruit(), quantity);
    }
}

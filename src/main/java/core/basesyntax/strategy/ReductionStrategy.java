package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;
import java.util.Optional;

public class ReductionStrategy implements OperationStrategy {
    @Override
    public void apply(TransactionDto transactionDto) {
        Fruit fruit = transactionDto.getFruit();
        Integer amount = Optional.ofNullable(Storage.fruits.get(fruit)).orElse(0);
        int newAmount = amount - transactionDto.getQuantity();
        if (newAmount < 0) {
            throw new RuntimeException("You don't have enough fruit");
        }
        Storage.fruits.put(fruit, newAmount);
    }
}

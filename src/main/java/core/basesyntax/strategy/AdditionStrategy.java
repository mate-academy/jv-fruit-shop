package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;
import java.util.Optional;

public class AdditionStrategy implements OperationStrategy {
    @Override
    public void apply(TransactionDto transactionDto) {
        Fruit fruit = transactionDto.getFruit();
        Integer amount = Optional.ofNullable(Storage.fruits.get(fruit)).orElse(0);
        Storage.fruits.put(fruit, amount + transactionDto.getQuantity());
    }
}

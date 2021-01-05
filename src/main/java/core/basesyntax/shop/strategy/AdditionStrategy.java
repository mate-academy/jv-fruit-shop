package core.basesyntax.shop.strategy;

import core.basesyntax.shop.db.Storage;
import core.basesyntax.shop.model.Fruit;
import core.basesyntax.shop.model.TransactionDto;
import java.util.Optional;

public class AdditionStrategy implements OperationStrategy {
    @Override
    public void apply(TransactionDto transactionDto) {
        Fruit fruit = transactionDto.getFruit();
        Integer quantity = Optional.ofNullable(Storage.fruitBalance.get(fruit)).orElse(0);
        Storage.fruitBalance.put(fruit, quantity + transactionDto.getQuantity());
    }
}

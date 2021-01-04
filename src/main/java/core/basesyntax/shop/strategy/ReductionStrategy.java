package core.basesyntax.shop.strategy;

import core.basesyntax.shop.db.Storage;
import core.basesyntax.shop.model.Fruit;
import core.basesyntax.shop.model.TransactionDto;
import java.util.Optional;

public class ReductionStrategy implements OperationStrategy {
    @Override
    public void apply(TransactionDto transactionDto) {
        Fruit fruit = transactionDto.getFruit();
        Integer quantity = Optional.ofNullable(Storage.fruitBalance.get(fruit)).orElse(0);
        int newQuantity = quantity - transactionDto.getQuantity();
        if (newQuantity < 0) {
            throw new IllegalStateException("You cannot sell more than you have");
        }
        Storage.fruitBalance.put(fruit, newQuantity);
    }
}

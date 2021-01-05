package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.TransactionDto;

public class ReduceStrategy implements OperationStrategy{
    @Override
    public void apply(TransactionDto transactionDto) {
        if (!Storage.fruits.containsKey(transactionDto.getFruit())) {
            throw new RuntimeException("You can't sell fruits what storage don't contains");
        } else {
            Integer oldValue = Storage.fruits.get(transactionDto.getFruit());
            Integer newValue = oldValue - transactionDto.getQuantity();
            if (newValue < 0) {
                throw new RuntimeException("You can't sell more than you have");
            }
            Storage.fruits.put(transactionDto.getFruit(), newValue);
        }
    }
}

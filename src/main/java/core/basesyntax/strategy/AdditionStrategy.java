package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.TransactionDto;

public class AdditionStrategy implements OperationStrategy {
    @Override
    public void apply(TransactionDto transactionDto) {
        if (Storage.fruits.containsKey(transactionDto.getFruit())) {
            Storage.fruits.put(transactionDto.getFruit(), transactionDto.getQuantity()
                    + Storage.fruits.get(transactionDto.getFruit()));
        } else {
            Storage.fruits.put(transactionDto.getFruit(), transactionDto.getQuantity());
        }
    }
}

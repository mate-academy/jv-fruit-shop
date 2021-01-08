package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.TransactionDto;

public class SubtractionStrategy implements OperationStrategy {
    @Override
    public void apply(TransactionDto transactionDto) {
        if (transactionDto.getQuantity() > Storage.fruits.get(transactionDto.getFruit())) {
            throw new RuntimeException("There`s not enough fruits to purchase");
        }
        Storage.fruits.put(transactionDto.getFruit(),
                Storage.fruits.get(transactionDto.getFruit()) - transactionDto.getQuantity());
    }
}

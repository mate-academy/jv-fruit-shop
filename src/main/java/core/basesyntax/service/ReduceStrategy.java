package core.basesyntax.service;

import core.basesyntax.model.Storage;
import core.basesyntax.model.dto.FruitRecordDto;

public class ReduceStrategy implements OperationStrategy {
    @Override
    public void apply(FruitRecordDto transactionDto) {
        if (!Storage.fruits.containsKey(transactionDto.getFruit())) {
            throw new RuntimeException("You can't sell fruits what storage don't contains");
        }
        Integer oldValue = Storage.fruits.get(transactionDto.getFruit());
        Integer newValue = oldValue - transactionDto.getQuantity();
        if (newValue < 0) {
            throw new RuntimeException("You can't sell more than you have");
        }
        Storage.fruits.put(transactionDto.getFruit(), newValue);

    }
}

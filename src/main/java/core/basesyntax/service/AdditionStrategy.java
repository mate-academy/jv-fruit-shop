package core.basesyntax.service;

import core.basesyntax.model.Storage;
import core.basesyntax.model.dto.TransactionDto;

public class AdditionStrategy implements OperationStrategy {
    @Override
    public void apply(TransactionDto transactionDto) {
        if (!Storage.fruits.containsKey(transactionDto.getFruit())) {
            Storage.fruits.put(transactionDto.getFruit(), transactionDto.getQuantity());
        } else {
            Integer oldValue = Storage.fruits.get(transactionDto.getFruit());
            Storage.fruits.put(transactionDto.getFruit(), oldValue + transactionDto.getQuantity());
        }
    }
}

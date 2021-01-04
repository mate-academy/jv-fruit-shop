package core.basesyntax.strategy;

import core.basesyntax.database.Storage;
import core.basesyntax.exception.WrongNumberOfFruitException;
import core.basesyntax.model.TransactionDto;

public class ReductionStrategy implements OperationStrategy {
    @Override
    public void apply(TransactionDto transactionDto) {
        Integer currentNumber = Storage.storage.get(transactionDto.getFruit());
        if (currentNumber == null || transactionDto.getNumber() < 0
                || transactionDto.getNumber() > currentNumber) {
            throw new WrongNumberOfFruitException("Wrong amount of fruit when reducing!");
        }
        Storage.storage.put(transactionDto.getFruit(), currentNumber - transactionDto.getNumber());
    }
}

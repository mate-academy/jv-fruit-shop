package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.TransactionDto;

public class AdditionStrategyImpl implements OperationStrategy {
    @Override
    public void operate(TransactionDto transactionDto) {
        if (Storage.fruitStorage.containsKey(transactionDto.getFruit())) {
            Integer currentFruitInStorage = Storage.fruitStorage.get(transactionDto.getFruit());
            Integer newFruitAmount = transactionDto.getQuantity() + currentFruitInStorage;
            Storage.fruitStorage.put(transactionDto.getFruit(), newFruitAmount);
        } else {
            Storage.fruitStorage.put(transactionDto.getFruit(), transactionDto.getQuantity());
        }
    }
}

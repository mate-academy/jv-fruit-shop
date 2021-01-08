package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.TransactionDto;

public class ReductionStrategyImpl implements OperationStrategy {
    @Override
    public void operate(TransactionDto transactionDto) {
        if (Storage.fruitStorage.containsKey(transactionDto.getFruit())
                && (transactionDto.getQuantity()
                <= Storage.fruitStorage.get(transactionDto.getFruit()))) {
            Integer newFruitAmount = Storage.fruitStorage.get(transactionDto.getFruit())
                    - transactionDto.getQuantity();
            Storage.fruitStorage.put(transactionDto.getFruit(), newFruitAmount);
        } else {
            throw new IllegalArgumentException("Storage has not enough fruit for operation");
        }
    }
}

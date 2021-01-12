package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.strategy.OperationStrategy;

public class ReturnStrategy implements OperationStrategy {
    @Override
    public void apply(TransactionDto transactionDto) {
        Integer amountFruitInStorage = Storage.getFruitsStorage().get(transactionDto.getFruit());
        if (amountFruitInStorage == null) {
            throw new RuntimeException("This fruit is not on the balance sheet: "
                    + transactionDto.getFruit().getName());
        }
        Storage.getFruitsStorage().put(transactionDto.getFruit(), transactionDto.getQuantity()
                + amountFruitInStorage);
    }
}

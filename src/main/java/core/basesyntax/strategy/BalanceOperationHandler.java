package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void apply(TransactionDto transactionDto) {
        Storage.fruitStorage.put(new Fruit(transactionDto.getFruit()),
                transactionDto.getAmount());
    }
}

package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.TransactionDto;

public class SupplyStrategy implements OperationStrategy {
    @Override
    public void apply(TransactionDto transactionDto) {
        int amount;
        if (Storage.fruitsMap.get(transactionDto.getFruit()) == null) {
            amount = transactionDto.getAmount();
        } else {
            amount = Storage.fruitsMap.get(transactionDto.getFruit()) + transactionDto.getAmount();
        }
        Storage.fruitsMap.put(transactionDto.getFruit(), amount);
    }
}

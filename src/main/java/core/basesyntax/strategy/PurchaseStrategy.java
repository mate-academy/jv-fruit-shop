package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.TransactionDto;

public class PurchaseStrategy implements OperationStrategy {
    @Override
    public void apply(TransactionDto transactionDto) {
        int amount;
        if (Storage.fruitsMap.get(transactionDto.getFruit()) == null) {
            amount = -transactionDto.getAmount();
        } else {
            amount = Storage.fruitsMap.get(transactionDto.getFruit())
                    - transactionDto.getAmount();
        }
        if (amount < 0) {
            throw new RuntimeException("Not enough fruit "
                    + transactionDto.getFruit());
        }
        Storage.fruitsMap.put(transactionDto.getFruit(), amount);
    }
}

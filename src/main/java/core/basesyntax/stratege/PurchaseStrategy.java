package core.basesyntax.stratege;

import core.basesyntax.db.Storage;
import core.basesyntax.model.TransactionDto;

public class PurchaseStrategy implements OperationStrategy {
    @Override
    public void doOperation(TransactionDto transactionDto) {
        if (!Storage.fruitsAndAmountsMap.containsKey(transactionDto.getFruit())) {
            throw new IllegalArgumentException("We can't buy fruit because we don't have this fruit"
                    + transactionDto.getFruit());
        }
        if (Storage.fruitsAndAmountsMap.get(transactionDto.getFruit())
                < transactionDto.getQuantity()) {
            throw new IllegalArgumentException("We don't have enough this fruits! You want buy "
                    + transactionDto.getQuantity() + " but we have only "
                    + Storage.fruitsAndAmountsMap.get(transactionDto.getFruit()));
        }
        Storage.fruitsAndAmountsMap.replace(transactionDto.getFruit(),
                Storage.fruitsAndAmountsMap.get(transactionDto.getFruit())
                        - transactionDto.getQuantity());
    }
}

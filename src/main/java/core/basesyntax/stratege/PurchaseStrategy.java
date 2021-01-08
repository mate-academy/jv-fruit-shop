package core.basesyntax.stratege;

import core.basesyntax.db.Storage;
import core.basesyntax.model.TransactionDto;

public class PurchaseStrategy implements OperationStrategy {
    @Override
    public void doOperation(TransactionDto transactionDto) {
        if (transactionDto.getQuantity() < 0) {
            throw new IllegalArgumentException("Purchase can't be negative number "
                    + transactionDto.getQuantity());
        }
        if (!Storage.fruitsAndAmountsMap.containsKey(transactionDto.getFruit())) {
            throw new IllegalArgumentException("We can't buy fruit because we don't have this fruit"
                    + transactionDto.getFruit());
        }
        if (Storage.fruitsAndAmountsMap.get(transactionDto.getFruit())
                < transactionDto.getQuantity()) {
            throw new IllegalArgumentException(String.format(
                    "We don't have enough this fruits! You want buy %d but we have only %s.",
                    transactionDto.getQuantity(),
                    Storage.fruitsAndAmountsMap.get(transactionDto.getFruit())));
        }
        Storage.fruitsAndAmountsMap.replace(transactionDto.getFruit(),
                Storage.fruitsAndAmountsMap.get(transactionDto.getFruit())
                        - transactionDto.getQuantity());
    }
}

package core.basesyntax.stratege;

import core.basesyntax.db.Storage;
import core.basesyntax.model.TransactionDto;

public class ReturnStrategy implements OperationStrategy {
    @Override
    public void doOperation(TransactionDto transactionDto) {
        if (transactionDto.getQuantity() < 0) {
            throw new IllegalArgumentException("We can't return negative number "
                    + transactionDto.getQuantity());
        }
        if (Storage.fruitsAndAmountsMap.containsKey(transactionDto.getFruit())) {
            Storage.fruitsAndAmountsMap.replace(transactionDto.getFruit(),
                    Storage.fruitsAndAmountsMap.get(transactionDto.getFruit())
                            + transactionDto.getQuantity());
            return;
        }
        Storage.fruitsAndAmountsMap.put(transactionDto.getFruit(), transactionDto.getQuantity());
    }
}

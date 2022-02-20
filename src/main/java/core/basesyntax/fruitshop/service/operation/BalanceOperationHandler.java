package core.basesyntax.fruitshop.service.operation;

import core.basesyntax.fruitshop.model.TransactionDto;
import core.basesyntax.fruitshop.storage.Storage;

public class BalanceOperationHandler implements OperationHandler {

    @Override
    public void applyOperation(TransactionDto transactionDto) {
        if (!Storage.fruitBalance.containsKey(transactionDto.getFruit().getName())) {
            Storage.fruitBalance.put(transactionDto.getFruit().getName(),
                    transactionDto.getAmount());
        }
    }
}

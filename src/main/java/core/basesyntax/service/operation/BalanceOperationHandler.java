package core.basesyntax.service.operation;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;
import java.util.Map;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public int changeAmount(TransactionDto transactionDto, Map<Fruit, Integer> storage) {
        storage.put(transactionDto.getFruit(), 0);
        return transactionDto.getAmount();
    }
}

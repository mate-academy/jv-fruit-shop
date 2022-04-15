package core.basesyntax.service.operation;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;
import java.util.Map;

public class BalanceHandler implements OperationHandler {
    @Override
    public int apply(TransactionDto transactionDto, Map<Fruit, Integer> storage) {
        storage.put(transactionDto.getFruit(), transactionDto.getAmount());
        return transactionDto.getAmount();
    }
}

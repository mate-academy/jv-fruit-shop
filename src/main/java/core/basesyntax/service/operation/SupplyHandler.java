package core.basesyntax.service.operation;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;
import java.util.Map;

public class SupplyHandler implements OperationHandler {
    @Override
    public int apply(TransactionDto transactionDto, Map<Fruit, Integer> storage) {
        int oldAmount = storage.get(transactionDto.getFruit());
        int newAmount = oldAmount + transactionDto.getAmount();
        storage.put(transactionDto.getFruit(), newAmount);
        return newAmount;
    }
}

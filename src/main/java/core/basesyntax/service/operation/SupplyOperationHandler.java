package core.basesyntax.service.operation;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;
import java.util.Map;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public int changeAmount(TransactionDto transactionDto, Map<Fruit, Integer> storage) {
        for (Map.Entry<Fruit, Integer> entry : storage.entrySet()) {
            if (entry.getKey().equals(transactionDto.getFruit())) {
                return entry.getValue() + transactionDto.getAmount();
            }
        }
        throw new RuntimeException("Invalid operation type");
    }
}

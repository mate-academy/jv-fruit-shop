package core.basesyntax.service.operation;

import core.basesyntax.model.Operation;
import java.util.Map;
import java.util.Optional;

public class DecreaseOperationHandler implements OperationHandler {
    @Override
    public int getAmount(Operation operation, Map<String, Integer> fruitsStorage) {
        Optional<Integer> amount = Optional.ofNullable(fruitsStorage.get(operation.getFruit()));
        int newAmount = amount.orElseThrow(() -> new RuntimeException("No such fruit found."))
                - operation.getAmount();
        if (newAmount < 0) {
            throw new RuntimeException("Not enough fruits found to sell.");
        }
        return newAmount;
    }
}

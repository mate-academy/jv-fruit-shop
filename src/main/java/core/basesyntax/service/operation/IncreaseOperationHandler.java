package core.basesyntax.service.operation;

import core.basesyntax.model.Operation;
import java.util.Map;
import java.util.Optional;

public class IncreaseOperationHandler implements OperationHandler {
    private static final Integer INITIAL_AMOUNT = 0;

    @Override
    public int getAmount(Operation operation, Map<String, Integer> fruitsStorage) {
        Optional<Integer> amount = Optional.ofNullable(fruitsStorage.get(operation.getFruit()));
        return amount.orElse(INITIAL_AMOUNT) + operation.getAmount();
    }
}

package core.basesyntax.services.operation;

import core.basesyntax.model.Operation;
import java.util.Map;
import java.util.Optional;

public class DecreaseHandler implements Handler {
    @Override
    public int getAmount(Operation operation, Map<String, Integer> fruitsStorage) {
        Optional<Integer> amount = Optional.ofNullable(fruitsStorage.get(operation.getFruit()));
        int newAmount = amount.orElseThrow(() -> new RuntimeException("No such item in store."))
                - operation.getAmount();
        if (newAmount < 0) {
            throw new RuntimeException("Not enough items.");
        }
        return newAmount;
    }
}

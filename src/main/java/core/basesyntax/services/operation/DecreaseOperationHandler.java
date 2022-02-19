package core.basesyntax.services.operation;

import core.basesyntax.model.TransactionDto;
import java.util.Map;
import java.util.Optional;

public class DecreaseOperationHandler implements OperationHandler {
    @Override
    public int apply(TransactionDto transactionDto, Map<String, Integer> fruitsStorage) {
        Optional<Integer> amount =
                Optional.ofNullable(fruitsStorage.get(transactionDto.getFruit()));
        int newAmount = amount.orElseThrow(() -> new RuntimeException("No such item in store."))
                - transactionDto.getAmount();
        if (newAmount < 0) {
            throw new RuntimeException("Not enough items.");
        }
        return newAmount;
    }
}

package core.basesyntax.services.operation;

import core.basesyntax.model.TransactionDto;
import java.util.Map;
import java.util.Optional;

public class IncreaseOperationHandler implements OperationHandler {
    private static final Integer INITIAL_AMOUNT = 0;

    @Override
    public int apply(TransactionDto transactionDto, Map<String, Integer> fruitsStorage) {
        Optional<Integer> amount =
                Optional.ofNullable(fruitsStorage.get(transactionDto.getFruit()));
        return amount.orElse(INITIAL_AMOUNT) + transactionDto.getAmount();
    }
}

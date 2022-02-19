package core.basesyntax.services.operation;

import core.basesyntax.model.TransactionDto;
import java.util.Map;

public interface OperationHandler {
    int apply(TransactionDto transactionDto, Map<String, Integer> fruitsStorage);
}

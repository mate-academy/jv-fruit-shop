package core.basesyntax.service;

import core.basesyntax.model.TransactionDto;
import java.util.List;

public interface OperationHandler {
    void executeTransaction(List<TransactionDto> transactions);
}

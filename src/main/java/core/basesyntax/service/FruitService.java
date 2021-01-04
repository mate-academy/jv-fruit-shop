package core.basesyntax.service;

import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.strategy.OperationStrategy;

import java.util.List;
import java.util.Map;

public interface FruitService {
    void applyOperations(List<TransactionDto> transactionDtos);

    Map<String, Long> getReport();
}

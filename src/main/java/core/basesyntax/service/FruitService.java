package core.basesyntax.service;

import core.basesyntax.model.TransactionDto;
import java.util.List;
import java.util.Map;

public interface FruitService {
    void applyOperations(List<TransactionDto> transactionDtos);

    Map<String, Long> getReport();
}

package core.basesyntax.service;

import core.basesyntax.model.TransactionDto;
import java.util.List;
import java.util.Map;

public interface FruitService {
    void applyAllOperators(List<TransactionDto> transactionDtos);

    Map<String, Long> getReport();
}

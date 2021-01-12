package core.basesyntax.service;

import core.basesyntax.model.TransactionDto;
import java.util.List;
import java.util.Map;

public interface FruitService {
    Map<String, Integer> getFruitReport();

    void applyOperationOnFruitDto(List<TransactionDto> transactionsDto);
}

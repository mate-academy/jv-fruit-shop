package core.basesyntax.service;

import core.basesyntax.model.TransactionDto;

import java.util.List;
import java.util.Map;

public interface FruitService {
    void applyOperation(List<TransactionDto> transation);

    Map<String, Integer> getFruitReporter();

}

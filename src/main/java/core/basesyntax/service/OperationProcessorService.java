package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface OperationProcessorService {
    void process(List<FruitTransaction> transactionList);
}

package core.basesyntax.service;

import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public interface ProcessDataService {
    void processData(List<Transaction> list, OperationStrategy strategy);
}

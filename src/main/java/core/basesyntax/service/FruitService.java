package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationHandler;
import java.util.Map;

public interface FruitService {
    void generateReport(String inputFile,
                         Map<FruitTransaction.Operation, OperationHandler> handler);
}

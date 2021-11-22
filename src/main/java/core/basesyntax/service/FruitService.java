package core.basesyntax.service;

import core.basesyntax.strategy.OperationStrategy;

public interface FruitService {
    String getReportService(String fromFileName,
                            String toFileName,
                            OperationStrategy operationStrategy);
}

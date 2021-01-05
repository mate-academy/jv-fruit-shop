package core.basesyntax.service;

import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;

public interface ReportCheck {
    void readFromReport(String filName, Map<Procedure, OperationStrategy> operationStrategyMap);

    String writeToReport();
}

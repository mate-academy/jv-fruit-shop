package core.basesyntax.operationprovider;

import core.basesyntax.service.operationstrategy.OperationStrategy;
import core.basesyntax.service.reportdb.ReportDataStorage;
import java.util.List;

public interface DataProcessor {
    void handleInput(List<String> input,
                           OperationStrategy operationStrategy,
                           ReportDataStorage reportDataStorage);
}

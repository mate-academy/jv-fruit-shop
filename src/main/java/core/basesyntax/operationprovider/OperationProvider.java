package core.basesyntax.operationprovider;

import core.basesyntax.service.operationstrategy.OperationStrategy;
import core.basesyntax.service.reportdb.ReportDataStorage;

import java.util.List;

public interface OperationProvider {
    void provideOperations(List<String> input,
                           OperationStrategy operationStrategy,
                           ReportDataStorage reportDataStorage);
}

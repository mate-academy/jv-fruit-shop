package core.basesyntax.service.operationHandler;

import core.basesyntax.service.reportdb.ReportDataStorage;
import core.basesyntax.service.reportdb.ReportDataStoragePerMapImpl;

public interface OperationHandler {
    static ReportDataStoragePerMapImpl reportDataStorage = null;

    boolean provideOperation(String fruit, Integer amount);
}

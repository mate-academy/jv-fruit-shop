package core.basesyntax.service.operationHandler;

import core.basesyntax.service.reportdb.ReportDataStorage;
import core.basesyntax.service.reportdb.ReportDataStoragePerMapImpl;

public interface OperationHandler {

    boolean provideOperation(ReportDataStorage reportDataStorage,String fruit, Integer amount);
}

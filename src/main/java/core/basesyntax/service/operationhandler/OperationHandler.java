package core.basesyntax.service.operationhandler;

import core.basesyntax.service.reportdb.ReportDataStorage;

public interface OperationHandler {
    boolean provideOperation(ReportDataStorage reportDataStorage,String fruit, Integer amount);
}

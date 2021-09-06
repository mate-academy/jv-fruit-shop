package core.basesyntax.service.operationhandler;

import core.basesyntax.service.reportdb.ReportDataStorage;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public boolean provideOperation(ReportDataStorage reportDataStorage,
                                    String fruit, Integer amount) {
        return reportDataStorage.acceptData(fruit,
                reportDataStorage.getDataPerFruit(fruit) + amount);
    }
}

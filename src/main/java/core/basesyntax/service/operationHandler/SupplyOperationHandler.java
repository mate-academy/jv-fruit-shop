package core.basesyntax.service.operationHandler;

import core.basesyntax.service.reportdb.ReportDataStorage;
import core.basesyntax.service.reportdb.ReportDataStoragePerMapImpl;

public class SupplyOperationHandler implements OperationHandler {

    @Override
    public boolean provideOperation(String fruit, Integer amount) {
        return reportDataStorage.acceptData(fruit, (reportDataStorage.getDataPerFruit(fruit)) + amount);

    }
}
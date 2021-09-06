package core.basesyntax.service.operationhandler;

import core.basesyntax.service.reportdb.ReportDataStorage;

public class BalanceOperationHandler implements OperationHandler {

    @Override
    public boolean provideOperation(ReportDataStorage reportDataStorage,
                                    String fruit, Integer amount) {
        return reportDataStorage.acceptData(fruit, amount);
    }
}

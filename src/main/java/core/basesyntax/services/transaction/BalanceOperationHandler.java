package core.basesyntax.services.transaction;

import core.basesyntax.dbreport.Report;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void handle(String fruit, int quantity) {
        Report.report.put(fruit, quantity);
    }
}

package core.basesyntax.services.transaction;

import core.basesyntax.dbreport.Report;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void handle(String fruit, int quantity) {
        Report.report.put(fruit, Report.report.get(fruit) - quantity);
    }
}

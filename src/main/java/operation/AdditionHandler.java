package operation;

import model.Record;
import report.Report;

public class AdditionHandler implements OperationHandler {
    @Override
    public void operate(Record record) {
        String fruit = record.getFruit();
        int currentAmount = Report.REPORT.get(fruit) == null ?
                0 : Report.REPORT.get(fruit);
        int newAmount = currentAmount + record.getAmount();
        Report.REPORT.put(fruit, newAmount);
    }
}

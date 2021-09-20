package operation;

import model.Record;
import report.Report;

public class DecreaseHandler implements OperationHandler {
    @Override
    public void operate(Record record) {
        String fruit = record.getFruit();
        int currentAmount = Report.FRUIT_REPORT.get(fruit) == null ?
                0 : Report.FRUIT_REPORT.get(fruit);
        int newAmount = currentAmount - record.getAmount();
        if (newAmount < 0) {
            throw new RuntimeException("Can't buy this amount of fruits: "
                    + record.getAmount());
        }
        Report.FRUIT_REPORT.put(fruit, newAmount);
    }
}

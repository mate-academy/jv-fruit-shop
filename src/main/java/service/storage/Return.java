package service.storage;

import java.util.Map;
import model.FruitTransaction;

public class Return implements PerformingOperation {

    @Override
    public void performToReport(FruitTransaction record, Map<String, Integer> report) {
        int value = record.getQuantity() + report.get(record.getFruit());
        report.put(record.getFruit(),value);
    }
}

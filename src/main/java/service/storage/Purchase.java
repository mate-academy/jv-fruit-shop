package service.storage;

import java.util.Map;
import model.FruitTransaction;

public class Purchase implements PerformingOperation {

    @Override
    public void performToReport(FruitTransaction record, Map<String, Integer> report) {
        int value = report.get(record.getFruit()) - record.getQuantity();
        if (value < 0) {
            throw new RuntimeException("Not enough " + record.getFruit());
        }
        report.put(record.getFruit(),value);
    }
}

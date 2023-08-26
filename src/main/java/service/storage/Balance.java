package service.storage;

import java.util.Map;
import model.FruitTransaction;

public class Balance implements PerformingOperation {

    @Override
    public void performToReport(FruitTransaction record, Map<String, Integer> report) {
        report.put(record.getFruit(),record.getQuantity());
    }
}


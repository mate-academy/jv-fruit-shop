package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    public List<String> generateReport(Storage storage) {
        List<String> report = new ArrayList<>();
        report.add("fruit,quantity");
        for (Map.Entry<String, Integer> entry : storage.getFruitInventory().entrySet()) {
            String fruitName = entry.getKey();
            int quantity = entry.getValue();
            String quantityString = (quantity >= 0) ? String.valueOf(quantity) : "-" + (-quantity);
            String reportLine = fruitName + "," + quantityString;
            report.add(reportLine);
        }
        return report;
    }
}

package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerationService;
import java.util.Map;

public class ReportGenerationServiceImpl implements ReportGenerationService {
    @Override
    public String generateReport(Storage storage) {
        Map<String, Integer> fruitsInStorage = storage.getFruits();
        StringBuilder report = new StringBuilder("fruit,quantity\n");
        for (Map.Entry<String, Integer> entry : fruitsInStorage.entrySet()) {
            String fruitName = entry.getKey();
            Integer fruitQuantity = entry.getValue();
            String reportLine = fruitName + "," + String.valueOf(fruitQuantity) + "\n";
            report.append(reportLine);
        }
        return report.toString();
    }
}

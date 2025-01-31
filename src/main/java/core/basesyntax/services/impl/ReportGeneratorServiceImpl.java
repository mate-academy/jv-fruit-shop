package core.basesyntax.services.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.services.ReportGeneratorService;
import java.util.Map;

public class ReportGeneratorServiceImpl implements ReportGeneratorService {
    private final Storage storage;

    public ReportGeneratorServiceImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String generateReport() {
        Map<String, Integer> inventory = storage.getInventory();
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity\n");
        for (Map.Entry<String,Integer> entry : inventory.entrySet()) {
            report.append(entry.getKey()).append(",").append(entry.getValue()).append("\n");
        }
        return report.toString();
    }
}

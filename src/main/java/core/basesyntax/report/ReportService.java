package core.basesyntax.report;

import core.basesyntax.db.FruitStorage;
import java.util.Map;

public class ReportService {
    private final FruitStorage fruitStorage;

    public ReportService(FruitStorage fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    public String generateReport() {
        Map<String, Integer> fruitInventory = fruitStorage.getFruitInventory();
        StringBuilder report = new StringBuilder("fruit,quantity\n");

        for (Map.Entry<String, Integer> entry : fruitInventory.entrySet()) {
            report.append(entry.getKey()).append(",").append(entry.getValue()).append("\n");
        }

        return report.toString();
    }
}

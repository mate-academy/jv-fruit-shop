package fruitshop.service.impl;

import fruitshop.db.Storage;
import fruitshop.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    public static final String HEADER = "fruit,quantity";
    public static final String COMA = ",";
    private final Storage storage = new Storage();

    @Override
    public String getReport() {
        Map<String, Integer> fruitStorage = storage.getStorage();
        StringBuilder report = new StringBuilder(HEADER).append(System.lineSeparator());
        for (Map.Entry<String, Integer> fruit : fruitStorage.entrySet()) {
            report.append(fruit.getKey()).append(COMA).append(fruit.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString().trim();
    }
}

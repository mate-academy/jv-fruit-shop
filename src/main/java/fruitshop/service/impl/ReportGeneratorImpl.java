package fruitshop.service.impl;

import fruitshop.db.Storage;
import fruitshop.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    public static final String HEADER = "fruit,quantity";
    public static final String COMA = ",";

    @Override
    public String getReport() {
        Storage storage = new Storage();
        Map<String, Integer> fruitStorage = storage.returnStorage();
        StringBuilder report = new StringBuilder(HEADER).append(System.lineSeparator());
        for (Map.Entry<String, Integer> fruit : fruitStorage.entrySet()) {
            report.append(fruit.getKey()).append(COMA).append(fruit.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString().trim();
    }
}

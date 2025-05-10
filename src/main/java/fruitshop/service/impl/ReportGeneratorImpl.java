package fruitshop.service.impl;

import fruitshop.db.Storage;
import fruitshop.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String generate() {
        StringBuilder report = new StringBuilder("fruit,quantity\n");
        for (Map.Entry<String, Integer> entry : Storage.fruits.entrySet()) {
            report.append(entry.getKey()).append(",").append(entry.getValue()).append("\n");
        }
        return report.toString();
    }
}

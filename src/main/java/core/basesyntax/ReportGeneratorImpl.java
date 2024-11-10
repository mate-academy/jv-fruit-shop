package core.basesyntax;

import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity\n");

        ShopStorage storage = ShopStorage.getInstance();
        for (Map.Entry<String, Integer> entry : storage.getAllFruits().entrySet()) {
            report.append(entry.getKey()).append(",").append(entry.getValue()).append("\n");
        }
        return report.toString();
    }
}

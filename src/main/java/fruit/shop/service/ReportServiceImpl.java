package fruit.shop.service;

import fruit.shop.db.Storage;
import fruit.shop.model.Fruit;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    @Override
    public String generateReport() {
        StringBuilder reportBuilder = new StringBuilder("fruit,quantity")
                .append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> entry : Storage.entrySet()) {
            reportBuilder.append(entry.getKey().toString())
                    .append(",")
                    .append(entry.getValue().toString())
                    .append(System.lineSeparator());
        }
        return reportBuilder.toString();
    }
}

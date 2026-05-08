package service.impl;

import db.Storage;
import java.util.Map;
import service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport() {
        StringBuilder builder = new StringBuilder();
        Map<String, Integer> fruitStorage = Storage.getInstance().getFruitStorage();
        builder.append("fruit,quantity\n");
        for (Map.Entry<String, Integer> entry : fruitStorage.entrySet()) {
            builder.append(entry.getKey()).append(",").append(entry.getValue()).append("\n");
        }
        return builder.toString();
    }
}

package service;

import db.Storage;
import java.util.Map;
import model.Fruit;

public class FruitReportService implements ReportService {
    @Override
    public String getReport() {
        StringBuilder reportStringBuilder = new StringBuilder().append("fruit,quantity");
        for (Map.Entry<Fruit, Integer> map : Storage.getStorage().entrySet()) {
            reportStringBuilder.append(System.lineSeparator())
                    .append(map.getKey().getFruitName())
                    .append(",")
                    .append(map.getValue());
        }
        return reportStringBuilder.toString();
    }
}

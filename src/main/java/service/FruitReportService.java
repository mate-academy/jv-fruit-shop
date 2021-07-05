package service;

import db.Storage;
import java.util.Map;
import model.Fruit;

public class FruitReportService implements ReportService {
    private static final String SEPARATOR = ",";
    private static final String HEADER = "fruit,quantity";

    @Override
    public String getReport() {
        StringBuilder reportStringBuilder = new StringBuilder().append(HEADER);
        for (Map.Entry<Fruit, Integer> map : Storage.getStorage().entrySet()) {
            reportStringBuilder.append(System.lineSeparator())
                    .append(map.getKey().getFruitName())
                    .append(SEPARATOR)
                    .append(map.getValue());
        }
        return reportStringBuilder.toString();
    }
}

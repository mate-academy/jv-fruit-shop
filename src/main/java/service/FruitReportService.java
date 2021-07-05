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
        for (Map.Entry<Fruit, Integer> entry : Storage.getStorage().entrySet()) {
            reportStringBuilder.append(System.lineSeparator())
                    .append(entry.getKey().getFruitName())
                    .append(SEPARATOR)
                    .append(entry.getValue());
        }
        return reportStringBuilder.toString();
    }
}

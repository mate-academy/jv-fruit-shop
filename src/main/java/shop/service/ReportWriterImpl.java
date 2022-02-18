package shop.service;

import java.util.Map;
import shop.db.Storage;
import shop.model.Fruit;

public class ReportWriterImpl implements ReportWriter {
    private static final String HEADER = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String makeReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(HEADER);
        for (Map.Entry<Fruit, Integer> entry : Storage.fruitsCount.entrySet()) {
            stringBuilder.append(System.lineSeparator())
                    .append(entry.getKey().getName())
                    .append(SEPARATOR)
                    .append(entry.getValue());
        }
        return stringBuilder.toString();
    }
}

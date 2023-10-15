package fruit.shop.service.impl;

import fruit.shop.db.Storage;
import fruit.shop.service.ReportCreator;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    private static final String HEADER = "fruit,quantity";

    @Override
    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder(HEADER);
        StringBuilder resultString = stringBuilder.append(System.lineSeparator());
        if (Storage.DB.isEmpty()) {
            throw new RuntimeException("DB is Empty nothing to write");
        }
        for (Map.Entry<String,Integer> entry : Storage.DB.entrySet()) {
            resultString.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return resultString.toString();
    }
}

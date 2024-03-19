package core.basesyntax.service.filehandler;

import core.basesyntax.db.ChangedData;
import java.util.Map;

public class Report {
    public String createReport(ChangedData changedData) {
        StringBuilder builder = new StringBuilder();
        builder.append("fruit,quantity").append(System.lineSeparator());

        for (Map.Entry<String, Integer> entry : changedData.getChangedData().entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            builder.append(key).append(",").append(value).append(System.lineSeparator());
            System.out.println(key + ": " + value);
        }
        return builder.toString();
    }
}

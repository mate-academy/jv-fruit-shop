package core.basesyntax.service.filehandler;

import core.basesyntax.db.CurrentData;
import java.util.Map;

public class ReportGenerate {
    public String createReport(CurrentData currentData) {
        StringBuilder builder = new StringBuilder();
        builder.append("fruit,quantity").append(System.lineSeparator());

        for (Map.Entry<String, Integer> entry : currentData.getChangedData().entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            builder.append(key).append(",").append(value).append(System.lineSeparator());
            System.out.println(key + ": " + value);
        }
        return builder.toString();
    }
}

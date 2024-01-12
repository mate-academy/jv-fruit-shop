package core.basesyntax.report;

import java.util.Map;

public class ReportCreator {
    public String createReport(Map<String, Integer> storage) {
        StringBuilder sb = new StringBuilder();
        sb.append("fruit,quantity\n");
        storage.forEach((key, value) -> {
            sb.append(key).append(",").append(value).append("\n");
        });
        return sb.toString();
    }
}

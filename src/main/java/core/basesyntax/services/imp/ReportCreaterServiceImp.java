package core.basesyntax.services.imp;

import core.basesyntax.services.ReportCreaterService;
import java.util.Map;

public class ReportCreaterServiceImp implements ReportCreaterService {
    @Override
    public String createReport(Map<String, Integer> parsedMap) {
        StringBuilder builder = new StringBuilder();
        builder.append("fruit,quantity")
                .append(System.lineSeparator());
        for (Map.Entry<String,Integer> entry : parsedMap.entrySet()) {
            builder.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}

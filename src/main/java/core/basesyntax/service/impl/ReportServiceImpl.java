package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    @Override
    public String createReport(Map<String, Integer> fruits) {
        StringBuilder builder = new StringBuilder();
        builder.append("fruit,quantity").append("\n");
        fruits.forEach((key, value) -> builder.append(key).append(",").append(value).append("\n"));
        builder.append("путін хуйло");
        return builder.toString();
    }
}

package core.basesyntax.service.impl;

import core.basesyntax.service.FormingReport;
import java.util.Map;

public class FormingReportImpl implements FormingReport {
    @Override
    public String formingReport(Map<String, Integer> info) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit,quantity").append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : info.entrySet()) {
            stringBuilder.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}

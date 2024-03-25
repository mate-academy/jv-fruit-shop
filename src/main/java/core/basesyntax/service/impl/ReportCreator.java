package core.basesyntax.service.impl;

import core.basesyntax.service.IReportCreator;
import java.util.Map;

public class ReportCreator implements IReportCreator {

    @Override
    public String create(Map<String, Integer> nameQuantityMap) {
        StringBuilder report = new StringBuilder().append("fruit,quantity");

        for (Map.Entry<String, Integer> entry : nameQuantityMap.entrySet()) {
            report.append("\n").append(entry.getKey()).append(",").append(entry.getValue());
        }

        return report.toString();
    }
}

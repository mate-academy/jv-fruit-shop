package core.basesyntax.service.createreportservice.impl;

import core.basesyntax.service.createreportservice.CreateReportService;
import java.util.Map;

public class CreateReportServiceImpl implements CreateReportService {
    @Override
    public String getReport(Map<String, Integer> map) {
        StringBuilder builderReport = new StringBuilder("fruit,quantity"
                + System.lineSeparator());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            builderReport.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return builderReport.toString();
    }
}

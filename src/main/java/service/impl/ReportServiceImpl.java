package service.impl;

import java.util.Map;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String SPLIT_SYMBOL = ",";
    private static final String NEXT_LINE = System.lineSeparator();

    @Override
    public String generateReport(Map<String, Integer> reportDataMap) {
        StringBuilder reportResult = new StringBuilder();
        reportResult.append("fruit").append(SPLIT_SYMBOL).append("quantity").append(NEXT_LINE);
        for (String e : reportDataMap.keySet()) {
            reportResult.append(e)
                    .append(SPLIT_SYMBOL)
                    .append(reportDataMap.get(e))
                    .append(NEXT_LINE);
        }
        return reportResult.toString().trim();
    }
}

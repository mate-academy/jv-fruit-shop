package service;

import java.util.Map;

public class TransactionGenerateReportServiceImpl implements TransactionGenerateReportService {
    private static final String SIGN_SEPARATOR = ",";

    @Override
    public String generateReport(Map<String, Integer> fruitsCount) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> line : fruitsCount.entrySet()) {
            stringBuilder.append(line.getKey())
                    .append(SIGN_SEPARATOR)
                    .append(line.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}

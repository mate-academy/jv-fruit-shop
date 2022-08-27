package service.impl;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String TITLE_FOR_REPORT = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String createReport(Map<String, Integer> storage) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TITLE_FOR_REPORT).append(System.lineSeparator());
        Set<Map.Entry<String, Integer>> entries = storage.entrySet();
        String dataReport = entries.stream()
                .map(e -> e.getKey() + SEPARATOR + e.getValue().toString())
                .collect(Collectors.joining(System.lineSeparator()));
        return stringBuilder.append(dataReport).toString();
    }
}

package service.impl;

import java.util.Map;
import java.util.stream.Collectors;
import service.ReportData;

public class ReportDataImpl implements ReportData {
    private static final String TITLE_FOR_RESIT = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String creatReport(Map<String, Integer> storage) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(TITLE_FOR_RESIT).append(System.lineSeparator());
        storage
                .entrySet()
                .stream()
                .map(e -> stringBuilder.append(e.getKey())
                        .append(SEPARATOR)
                        .append(e.getValue())
                        .append(System.lineSeparator()))
                .collect(Collectors.joining());
        return stringBuilder.toString();
    }
}

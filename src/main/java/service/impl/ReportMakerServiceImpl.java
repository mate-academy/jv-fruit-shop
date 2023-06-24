package service.impl;

import java.util.Map;
import java.util.stream.Collectors;
import service.ReportMakerService;

public class ReportMakerServiceImpl implements ReportMakerService {
    private static final String COLUMNS_SEPARATOR = ",";
    private static final String COLUMNS_NAMES = "fruits,quantity";

    @Override
    public String makeReport(Map<String, Integer> fruitsMap) {
        if (fruitsMap == null) {
            throw new RuntimeException("Arguments can't be null");
        }
        return COLUMNS_NAMES + System.lineSeparator() + fruitsMap.entrySet().stream()
                .map(f -> f.getKey() + COLUMNS_SEPARATOR + f.getValue() + System.lineSeparator())
                .collect(Collectors.joining());
    }
}

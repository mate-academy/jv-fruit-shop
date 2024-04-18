package core.basesyntax.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportCreator {
    public String createReport(Map<String, Integer> storageForReport) {
        List<String> lines = storageForReport.entrySet().stream()
                .map(entry -> entry.getKey() + "," + entry.getValue())
                .collect(Collectors.toList());
        return String.join(System.lineSeparator(), lines);
    }
}

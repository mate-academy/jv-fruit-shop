package core.basesyntax.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportCreator {

    public static final Map<String, Integer> storageForReport = new HashMap<>();

    public List<String> constructingLines(Map<String, Integer> storageForReport) {
        return storageForReport.entrySet().stream()
                .map(entry -> entry.getKey() + "," + entry.getValue())
                .collect(Collectors.toList());
    }

}

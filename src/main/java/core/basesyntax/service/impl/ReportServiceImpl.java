package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {

    @Override
    public String getReport(Map<String, Integer> storage) {
        StringBuilder builder = new StringBuilder("fruit,quantity");
        String infoForRepo = getInfoForReport(storage);
        builder.append(System.lineSeparator()).append(infoForRepo);
        return builder.toString();
    }

    private String getInfoForReport(Map<String, Integer> storage) {
        return storage.entrySet().stream()
                .map(e -> {
                    StringBuilder builder = new StringBuilder();
                    builder.append(e.getKey()).append(",").append(e.getValue());
                    return builder.toString();
                }).collect(Collectors.joining(System.lineSeparator()));
    }
}

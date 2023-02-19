package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    @Override
    public String getReportFruitStorage(Map<String, Integer> mapHandler) {
        StringBuilder builder = new StringBuilder("fruit,quantity");
        String infoForRepo = getInfoForReport(mapHandler);
        builder.append(System.lineSeparator()).append(infoForRepo);
        return builder.toString();
    }

    private String getInfoForReport(Map<String, Integer> mapHandler) {
        return mapHandler.entrySet().stream()
                .map(e -> {
                    StringBuilder builder = new StringBuilder();
                    builder.append(e.getKey()).append(",").append(e.getValue());
                    return builder.toString();
                }).collect(Collectors.joining(System.lineSeparator()));
    }
}

package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    @Override
    public String getReportFruitStorage(String information) {
        StringBuilder builder = new StringBuilder("fruit,quantity");
        builder.append(System.lineSeparator()).append(information);
        return builder.toString();
    }

    @Override
    public String getInfoForReport(Map<String, Integer> mapHandler) {
        return mapHandler.entrySet().stream()
                .map(e -> {
                    StringBuilder builder = new StringBuilder();
                    builder.append(e.getKey()).append(",").append(e.getValue());
                    return builder.toString();
                }).collect(Collectors.joining(System.lineSeparator()));
    }
}

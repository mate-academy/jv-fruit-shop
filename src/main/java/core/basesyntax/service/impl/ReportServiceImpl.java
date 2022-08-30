package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import core.basesyntax.storage.Storage;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    @Override
    public String getReport() {
        StringBuilder builder = new StringBuilder("fruit,quantity").append(System.lineSeparator());
        String collect = Storage.storage.entrySet().stream()
                .map(m -> new StringBuilder()
                        .append(m.getKey().getName())
                        .append(",")
                        .append(m.getValue()))
                .collect(Collectors.joining(System.lineSeparator()));
        return builder.append(collect).toString();
    }
}

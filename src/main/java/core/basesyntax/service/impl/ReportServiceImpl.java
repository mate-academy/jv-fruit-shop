package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import core.basesyntax.storage.Storage;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    public static final String TITLE = "fruit,quantity";

    @Override
    public String getReport() {
        StringBuilder builder = new StringBuilder(TITLE).append(System.lineSeparator());
        String collect = Storage.storage.entrySet().stream()
                .map(m -> new StringBuilder()
                        .append(m.getKey().getName())
                        .append(",")
                        .append(m.getValue()))
                .collect(Collectors.joining(System.lineSeparator()));
        return builder.append(collect).toString();
    }
}

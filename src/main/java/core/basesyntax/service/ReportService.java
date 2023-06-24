package core.basesyntax.service;

import core.basesyntax.db.Storage;
import java.util.stream.Collectors;

public class ReportService {
    private static final String TITLE_STRING_REPORT = "fruit,quantity";

    public String getReport() {
        return TITLE_STRING_REPORT + System.lineSeparator()
                + Storage.remnantsOfGoods.entrySet().stream()
                .map(entry -> entry.getKey() + "," + entry.getValue())
                .collect(Collectors.joining(System.lineSeparator()));
    }
}

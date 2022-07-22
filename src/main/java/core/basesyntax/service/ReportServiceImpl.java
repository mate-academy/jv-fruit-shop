package core.basesyntax.service;

import core.basesyntax.db.Storage;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER = "fruit,quantity";

    @Override
    public String makeReport() {
        String fruitsInfo = Storage.fruits.entrySet().stream()
                .map(f -> f.getKey().getName() + "," + f.getValue())
                .collect(Collectors.joining(System.lineSeparator()));
        return HEADER + System.lineSeparator() + fruitsInfo;
    }
}

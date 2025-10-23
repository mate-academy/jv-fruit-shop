package core.basesyntax.service.report;

import core.basesyntax.db.Storage;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String COMMA = ",";
    private static final String HEAD_TITLE = "fruit,quantity";
    private final Storage storage;

    public ReportGeneratorImpl(Storage storage) {
        if (storage == null) {
            throw new RuntimeException("Error: ReportGenerator storage must not be null");
        }
        this.storage = storage;
    }

    @Override
    public String getReport() {
        Map<String, Integer> map = storage.getSnapshot();
        return map.entrySet().stream()
                .map(fr -> fr.getKey() + COMMA + fr.getValue())
                .collect(Collectors.joining(System.lineSeparator(),
                        HEAD_TITLE + System.lineSeparator(), ""));
    }
}

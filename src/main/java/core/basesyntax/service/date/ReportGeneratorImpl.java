package core.basesyntax.service.date;

import java.util.Map;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    private Map<String, Integer> storage;

    public ReportGeneratorImpl(Map<String, Integer> storage) {
        this.storage = storage;
    }

    public ReportGeneratorImpl() {
    }

    @Override
    public String getReport() {
        return storage.entrySet()
                .stream()
                .map(entry -> entry.getKey() + "," + entry.getValue())
                .collect(Collectors.joining("\n"));
    }
}

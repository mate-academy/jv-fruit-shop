package report;

import java.util.Map;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit,quantity";
    private final Map<String, Integer> storage;

    public ReportGeneratorImpl(Map<String, Integer> storage) {
        this.storage = storage;
    }

    @Override
    public String getReport() {
        return HEADER + System.lineSeparator() + storage.entrySet().stream()
                .map(entry -> entry.getKey() + "," + entry.getValue())
                .collect(Collectors.joining(System.lineSeparator()));
    }
}


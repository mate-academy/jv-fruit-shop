package report;

import java.util.Map;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    private final Map<String, Integer> storage;

    public ReportGeneratorImpl(Map<String, Integer> storage) {
        this.storage = storage;
    }

    @Override
    public String getReport() {
        return "fruit,quantity\n" + storage.entrySet().stream()
                        .map(entry -> entry.getKey() + "," + entry.getValue())
                        .collect(Collectors.joining("\n"));
    }
}

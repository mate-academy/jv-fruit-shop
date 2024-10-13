package core.basesyntax.service.date;

import java.util.Map;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport(Map<String, Integer> storage) {
        return storage.entrySet()
                .stream()
                .map(entry -> entry.getKey() + "," + entry.getValue())
                .collect(Collectors.joining("\n"));
    }
}

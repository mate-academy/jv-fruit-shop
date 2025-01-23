package core.basesyntax.reportgenerator;

import core.basesyntax.storage.Storage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String DEFAULT_START_STRING = "fruit,quantity";
    private static final String STRING_SEPARATOR = ",";
    private Map<String, Integer> storage = Storage.storage;

    @Override
    public String getReport() {
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(storage.entrySet());
        entries.sort(Map.Entry.comparingByKey());
        List<String> report = new ArrayList<>();
        report.add(DEFAULT_START_STRING);
        for (Map.Entry<String, Integer> entry : entries) {
            report.add(entry.getKey() + STRING_SEPARATOR + entry.getValue());
        }
        return String.join(System.lineSeparator(), report);
    }
}

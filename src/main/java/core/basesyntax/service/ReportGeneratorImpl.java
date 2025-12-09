package core.basesyntax.service;

import core.basesyntax.db.Storage;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEADER = "fruit quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String getReport() {

        Map<String, Integer> inventory = Storage.getFruitStorage();

        String reportBody = inventory.entrySet().stream()
                .map(entry -> entry.getKey() + SEPARATOR + entry.getValue())
                .collect(Collectors.joining(System.lineSeparator()));

        return HEADER + System.lineSeparator() + reportBody;
    }
}

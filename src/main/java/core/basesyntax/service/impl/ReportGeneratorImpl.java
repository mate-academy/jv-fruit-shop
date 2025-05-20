package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {

    private static final String HEADLINE = "fruit,quantity";
    private static final String SEPARATOR = System.lineSeparator();


    @Override
    public String getReport() {
        if (Storage.storage.isEmpty()) {
            return HEADLINE;
        }
        for (Map.Entry<String, Integer> tempMap : Storage.storage.entrySet()) {
            if (tempMap.getValue() < 0) {
                throw new RuntimeException("Quantity can not be less than 0!");
            }
        }
        String report = Storage.storage.entrySet().stream()
                .map(entry -> entry.getKey() + "," + entry.getValue().toString())
                .collect(Collectors.joining(SEPARATOR));

        return HEADLINE + SEPARATOR + report;
    }
}

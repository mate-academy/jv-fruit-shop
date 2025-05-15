package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport() {
        String headline = "fruit,quantity";
        if (Storage.storage.isEmpty()) {
            return headline;
        }
        for (Map.Entry<String, Integer> tempMap : Storage.storage.entrySet()) {
            if (tempMap.getValue() < 0) {
                throw new RuntimeException("Quantity can not be less than 0!");
            }
        }
        String report = Storage.storage.entrySet().stream()
                .map(entry -> entry.getKey() + "," + entry.getValue().toString())
                .collect(Collectors.joining("\n"));

        return headline + System.lineSeparator() + report;
    }
}

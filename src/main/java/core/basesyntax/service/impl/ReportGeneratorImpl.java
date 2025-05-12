package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport() {

        if (Storage.fruits.isEmpty()) {
            throw new RuntimeException("Empty list");
        }
        for (Map.Entry<String, Integer> tempMap : Storage.fruits.entrySet()) {
            if (tempMap.getValue() < 0) {
                throw new RuntimeException("Quantity can not be less than 0!");
            }
        }
        String report = Storage.fruits.entrySet().stream()
                .map(entry -> entry.getKey() + "," + entry.getValue().toString())
                .collect(Collectors.joining("\n"));
        return "Fruit,quantity\n" + report;
    }
}

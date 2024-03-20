package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportGeneratorImpl implements ReportGenerator {
    private Storage storage;

    public ReportGeneratorImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public List<String> generate() {
        Map<String,Integer> fruits = storage.getFruits();
        List<String> formattedList = fruits.entrySet().stream()
                .map(entry -> entry.getKey() + "," + entry.getValue())
                .collect(Collectors.toList());
        formattedList.add(0, "fruit,quantity");
        return formattedList;
    }
}

package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.ArrayList;
import java.util.List;

public class ReportGeneratorImpl implements ReportGenerator {
    private Storage storage;

    public ReportGeneratorImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public List<String> generate() {
        List<String> formattedList = new ArrayList<>();
        formattedList.add("fruit,quantity");
        storage.getFruits().forEach((fruit, quantity) -> formattedList.add(fruit + "," + quantity));
        return formattedList;
    }
}

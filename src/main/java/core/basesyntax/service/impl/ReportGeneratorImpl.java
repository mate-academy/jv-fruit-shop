package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.ArrayList;
import java.util.List;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String SEPARATOR = ",";
    private static final String TITLE = "fruit,quantity";
    private Storage storage;

    public ReportGeneratorImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public List<String> generate() {
        List<String> formattedList = new ArrayList<>();
        formattedList.add(TITLE);
        storage.getFruits().forEach((fruit, quantity) -> formattedList.add(fruit + SEPARATOR + quantity));
        return formattedList;
    }
}

package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER = "fruit,quantity";
    private Storage storage;

    public ReportServiceImpl(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder(HEADER).append(System.lineSeparator());
        for (Fruit fruit : storage.getAllFruits().keySet()) {
            report = report.append(fruit.getName() + ","
                    + storage.getFruitQuantity(fruit)
                    + System.lineSeparator());
        }
        return report.toString();
    }
}

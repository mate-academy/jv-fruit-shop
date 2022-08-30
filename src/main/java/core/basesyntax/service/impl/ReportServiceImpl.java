package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String DIVIDER = ",";
    private static final String HEADER = "fruit,quantity" + System.lineSeparator();

    @Override
    public String report() {
        StringBuilder report = new StringBuilder(HEADER);
        for (Fruit fruitLine : Storage.fruits) {
            report.append(fruitLine.getName())
                    .append(DIVIDER)
                    .append(fruitLine.getAmount())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}

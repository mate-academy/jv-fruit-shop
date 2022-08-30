package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;

public class ReportServiceImpl implements ReportService {
    @Override
    public String report(String header, String divider) {
        StringBuilder report = new StringBuilder(header);
        for (Fruit fruitLine : Storage.fruits) {
            report.append(fruitLine.getName())
                    .append(divider)
                    .append(fruitLine.getAmount())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}

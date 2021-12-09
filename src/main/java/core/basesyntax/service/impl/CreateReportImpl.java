package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportCreator;

public class CreateReportImpl implements ReportCreator {
    @Override
    public String reportCreator() {
        StringBuilder reportString = new StringBuilder();
        reportString.append("fruit,quantity").append("\n");

        for (Fruit fruitOperation : Storage.fruits) {
            reportString.append(fruitOperation.getNameFruit()).append(",")
                    .append(fruitOperation.getQuantityFruit()).append("\n");
        }
        return String.valueOf(reportString);
    }
}

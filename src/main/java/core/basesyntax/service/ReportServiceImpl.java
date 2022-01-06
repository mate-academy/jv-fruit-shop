package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;

public class ReportServiceImpl implements ReportService {
    @Override
    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit,quantity").append("\n");
        for (Fruit fruits : Storage.fruits) {
            stringBuilder.append(fruits.getName()).append(",")
                    .append(fruits.getQuantity()).append("\n");
        }
        return stringBuilder.toString();
    }
}

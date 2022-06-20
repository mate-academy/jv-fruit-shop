package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportCreator;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    @Override
    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder("fruit,quantity")
                .append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> record : Storage.storage.entrySet()) {
            stringBuilder.append(record.getKey())
                    .append(",")
                    .append(record.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}

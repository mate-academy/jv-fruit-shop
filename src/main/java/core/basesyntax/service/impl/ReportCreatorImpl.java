package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportCreator;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    @Override
    public String create() {
        StringBuilder builder = new StringBuilder();
        builder.append("fruit, quantity").append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : Storage.storage.entrySet()) {
            String fruit = entry.getKey();
            int quantity = entry.getValue();
            builder.append(fruit).append(",").append(quantity).append(System.lineSeparator());
        }
        return builder.toString();
    }
}

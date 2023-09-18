package core.basesyntax.service.impl;

import core.basesyntax.service.service.Report;
import core.basesyntax.storage.Storage;
import java.util.Map;

public class ReportImpl implements Report {
    private static final String FIRST_STRING = "fruit,quantity" + System.lineSeparator();
    private static final String COMMA = ",";

    @Override
    public String report() {
        StringBuilder builder = new StringBuilder(FIRST_STRING);
        builder.append(System.lineSeparator());
        for (Map.Entry<String,Integer> fruits : Storage.getStorage().entrySet()) {
            builder.append(fruits.getKey()).append(COMMA).append(fruits.getValue())
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}

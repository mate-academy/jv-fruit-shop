package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.WriteParser;
import java.util.Map;
import java.util.Set;

public class WriteParserImpl implements WriteParser {
    private static final String COMMA = ",";
    private static final String LINE = System.lineSeparator();

    @Override
    public String parse() {
        StringBuilder builder = new StringBuilder();
        builder.append("fruit")
                .append(COMMA)
                .append("quantity")
                .append(LINE);
        Set<Map.Entry<String, Integer>> entries = Storage.storageMap.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            builder.append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue())
                    .append(LINE);
        }
        return builder.toString();
    }
}

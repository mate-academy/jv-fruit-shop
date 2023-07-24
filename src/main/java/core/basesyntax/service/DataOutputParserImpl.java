package core.basesyntax.service;

import core.basesyntax.db.Storage;
import java.util.Map;
import java.util.Set;

public class DataOutputParserImpl implements DataOutputParser {
    private static final String COMMA = ",";
    private static final String LINE = System.lineSeparator();

    @Override
    public String parseData() {
        StringBuilder builder = new StringBuilder();
        builder.append("fruit")
                .append(COMMA)
                .append("quantity")
                .append(LINE);
        Set<Map.Entry<String, Integer>> entrySet = Storage.storage.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet) {
            builder.append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue())
                    .append(LINE);
        }
        return builder.toString();
    }
}

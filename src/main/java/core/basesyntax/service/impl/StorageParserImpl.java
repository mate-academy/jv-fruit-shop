package core.basesyntax.service.impl;

import core.basesyntax.service.StorageParser;
import java.util.Map;

public class StorageParserImpl implements StorageParser {
    private static final String WORDS_SEPARATOR = ",";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Override
    public String parseStorage(Map<String, Integer> storage) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : storage.entrySet()) {
            stringBuilder.append(entry.getKey())
                    .append(WORDS_SEPARATOR)
                    .append(entry.getValue())
                    .append(LINE_SEPARATOR);
        }
        return stringBuilder.toString().trim();
    }
}

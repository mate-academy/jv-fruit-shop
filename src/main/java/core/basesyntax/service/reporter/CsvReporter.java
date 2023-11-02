package core.basesyntax.service.reporter;

import core.basesyntax.db.Storage;

import java.util.Map;

public class CsvReporter implements Reporter {
    private static final String FIRST_LINE = "fruit,quantity";
    private static final String COMMA = ",";
    @Override
    public String makeReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(FIRST_LINE).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : Storage.fruits.entrySet()) {
            stringBuilder.append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}

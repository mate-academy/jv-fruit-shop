package core.basesyntax.services.implementation;

import core.basesyntax.db.Storage;
import core.basesyntax.services.Report;

public class ReportImpl implements Report {
    private static final String TITLE_ROW = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String makeReport() {
        StringBuilder builder = new StringBuilder(TITLE_ROW).append(System.lineSeparator());
        Storage.fruitRecordDto.forEach((key, value) -> builder.append(key.getName())
                .append(SEPARATOR)
                .append(value).append(System.lineSeparator()));
        return builder.toString();
    }
}

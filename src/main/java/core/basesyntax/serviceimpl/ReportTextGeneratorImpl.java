package core.basesyntax.serviceimpl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportTextGenerator;

import java.util.List;

public class ReportTextGeneratorImpl implements ReportTextGenerator {
    private static final String COMA = ",";

    @Override
    public List<String> generateTextReport() {
        return Storage.STORAGE
                .entrySet()
                .stream()
                .map(stringIntegerEntry -> stringIntegerEntry.getKey() + COMA
                        + stringIntegerEntry.getValue() + System.lineSeparator())
                .toList();
    }
}

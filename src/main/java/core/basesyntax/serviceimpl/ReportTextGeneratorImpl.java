package core.basesyntax.serviceimpl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportTextGenerator;
import java.util.stream.Collectors;

public class ReportTextGeneratorImpl implements ReportTextGenerator {
    private static final String COMA = ",";

    @Override
    public String generateTextReport() {
        return "fruit,quantity" + System.lineSeparator() + Storage.STORAGE
                .entrySet()
                .stream()
                .map(stringIntegerEntry -> stringIntegerEntry.getKey() + COMA
                        + stringIntegerEntry.getValue() + System.lineSeparator())
                .collect(Collectors.joining());
    }
}

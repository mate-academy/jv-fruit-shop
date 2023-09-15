package core.basesyntax.serviceimpl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportTextGeneratorService;
import java.util.stream.Collectors;

public class ReportTextGeneratorServiceImpl implements ReportTextGeneratorService {
    private static final String COMA = ",";
    private static final String DEFAULT_TEXT = "fruit,quantity" + System.lineSeparator();

    @Override
    public String generateTextReport() {
        return DEFAULT_TEXT + Storage.STORAGE
                .entrySet()
                .stream()
                .map(stringIntegerEntry -> stringIntegerEntry.getKey() + COMA
                        + stringIntegerEntry.getValue() + System.lineSeparator())
                .collect(Collectors.joining());
    }
}

package core.basesyntax.impl;

import static core.basesyntax.model.FruitStorage.STORAGE;

import core.basesyntax.service.ReportCreatorService;
import java.util.stream.Collectors;

public class ReportCreatorServiceImpl implements ReportCreatorService {
    private static final String FIRST_STRING = "fruit,quantity" + System.lineSeparator();
    private static final String COMMA = ",";

    @Override
    public String createReport() {
        String report = STORAGE.entrySet().stream()
                .map(entry -> entry.getKey() + COMMA + entry.getValue())
                .collect(Collectors.joining(System.lineSeparator()));
        return FIRST_STRING + report;
    }
}

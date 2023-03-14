package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportMakerService;

import java.util.stream.Collectors;

public class ReportMakerServiceImpl implements ReportMakerService {
    private static final String SEPARATOR = ",";
    private static final String HEAD_STRING = "fruit,quantity";

    @Override
    public String report() {
        return HEAD_STRING + System.lineSeparator() +
                Storage.STORAGE.entrySet().stream()
                        .map(entry -> entry.getKey() + SEPARATOR + entry.getValue())
                        .collect(Collectors.joining(System.lineSeparator()));
    }
}

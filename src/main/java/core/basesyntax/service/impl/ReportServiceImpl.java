package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReportServiceImpl implements ReportService {
    private static final String TITLE_INFORMATION = "fruit,quantity";
    private static final String JOINING_SYMBOL = ",";

    @Override
    public List<String> createReport() {
        return Stream.concat(Stream.of(TITLE_INFORMATION), getAll().stream())
                .collect(Collectors.toList());
    }

    private List<String> getAll() {
        return Storage.storage.entrySet().stream()
                .map(entry -> entry.getKey() + JOINING_SYMBOL + entry.getValue())
                .collect(Collectors.toList());
    }
}

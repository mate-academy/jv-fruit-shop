package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.CreateReportService;
import java.util.stream.Collectors;

public class CreateReportServiceImpl implements CreateReportService {
    private static final String DESCRIPTION = "fruit,quantity";

    @Override
    public String createReport() {
        String report = Storage.warehouse.stream()
                .distinct()
                .map(f -> System.lineSeparator() + f.getFruit()
                        + "," + f.getQuantity())
                .collect(Collectors.joining());
        return DESCRIPTION + report;
    }
}

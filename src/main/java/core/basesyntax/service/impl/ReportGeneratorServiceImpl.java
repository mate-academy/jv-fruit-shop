package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageAccess;
import core.basesyntax.service.ReportGeneratorService;
import java.util.stream.Collectors;

public class ReportGeneratorServiceImpl extends StorageAccess implements ReportGeneratorService {
    private static final String REPORT_HEADER = "fruit,quantity" + System.lineSeparator();
    private static final String JOINER = ",";

    @Override
    public String generateReport() {
        return REPORT_HEADER + storage.getStorage().entrySet().stream()
                                        .map(i -> i.getKey() + JOINER + i.getValue())
                                        .collect(Collectors.joining(System.lineSeparator()));
    }
}

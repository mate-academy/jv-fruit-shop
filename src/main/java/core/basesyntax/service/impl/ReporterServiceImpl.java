package core.basesyntax.service.impl;

import core.basesyntax.service.ReporterService;
import core.basesyntax.service.StorageService;
import java.util.Map;

public class ReporterServiceImpl implements ReporterService {
    private static final String SEPARATOR = ",";
    private static final String REPORT_HEADER = "fruit,quantity" + System.lineSeparator();
    private final StorageService storageService;

    public ReporterServiceImpl(StorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public String createReport() {
        StringBuilder builder = new StringBuilder(REPORT_HEADER);
        for (Map.Entry<String, Integer> entry : storageService.getAll().entrySet()) {
            builder.append(entry.getKey() + SEPARATOR + entry.getValue() + System.lineSeparator());
        }
        return builder.toString();
    }
}

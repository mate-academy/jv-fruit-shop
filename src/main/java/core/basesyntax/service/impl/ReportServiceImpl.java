package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import core.basesyntax.service.StorageService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String SEPARATOR = ",";
    private static final String REPORT_HEADER = "fruit,quantity";
    private final StorageService storageService;

    public ReportServiceImpl(StorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public List<String> createReport() {
        List<String> report = new ArrayList<>();
        report.add(REPORT_HEADER);
        for (Map.Entry<String, Integer> entry : storageService.getAll().entrySet()) {
            report.add(entry.getKey() + SEPARATOR + entry.getValue());
        }
        return report;
    }
}

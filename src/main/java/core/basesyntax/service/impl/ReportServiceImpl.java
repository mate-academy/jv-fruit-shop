package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import core.basesyntax.service.StorageService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String REPORT_HEADER = "fruit,quantity";
    private static final String DIVIDER = ",";
    private final StorageService storageService;

    public ReportServiceImpl(StorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public List<String> generateReport() {
        List<String> reportData = new ArrayList<>();
        reportData.add(REPORT_HEADER);

        for (Map.Entry<String, Integer> entry : storageService.getAll().entrySet()) {
            reportData.add(entry.getKey() + DIVIDER + entry.getValue());
        }
        return reportData;
    }
}

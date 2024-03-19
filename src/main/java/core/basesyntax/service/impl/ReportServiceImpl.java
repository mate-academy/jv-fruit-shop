package core.basesyntax.service.impl;

import core.basesyntax.service.ReportService;
import core.basesyntax.service.StorageService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private final StorageService storageService;

    public ReportServiceImpl() {
        storageService = new StorageServiceImpl();
    }

    @Override
    public List<String> generateReport() {
        List<String> reportData = new ArrayList<>();
        reportData.add("fruit,quantity");

        for (Map.Entry<String, Integer> entry : storageService.getAll().entrySet()) {
            reportData.add(entry.getKey() + "," + entry.getValue());
        }
        return reportData;
    }
}

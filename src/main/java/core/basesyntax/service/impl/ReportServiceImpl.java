package core.basesyntax.service.impl;

import core.basesyntax.repository.StorageRepository;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER = "fruit,quantity" + System.lineSeparator();
    private static final String DELIMITER = ",";
    private final StorageRepository repository;

    public ReportServiceImpl(StorageRepository repository) {
        this.repository = repository;
    }

    @Override
    public String generateReport() {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(HEADER);
        for (Map.Entry<String, Integer> entry : repository.getProducts().entrySet()) {
            reportBuilder.append(entry.getKey()).append(DELIMITER)
                    .append(entry.getValue()).append(System.lineSeparator());
        }
        return reportBuilder.toString();
    }
}

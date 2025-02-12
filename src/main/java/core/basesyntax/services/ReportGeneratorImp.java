package core.basesyntax.services;

import java.util.Map;

public class ReportGeneratorImp implements ReportGenerator {
    private static final String COMMA = ",";
    private final StorageService storageService;

    public ReportGeneratorImp(StorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public String generateReport() {
        Map<String, Integer> fruits = storageService.getAll();
        StringBuilder report = new StringBuilder();
        for (Map.Entry<String, Integer> entry : fruits.entrySet()) {
            report.append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}

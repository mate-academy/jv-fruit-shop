package core.basesyntax.service.implemantation;

import core.basesyntax.service.ReportGenerationService;
import java.util.Map;
import java.util.Map.Entry;

public class ReportGenerationServiceImpl implements ReportGenerationService {
    public static final String COMA_SEPARATOR = ",";
    public static final String REPORT_FILE_HEADER = "fruit, quantity";

    @Override
  public String generateReport(Map<String, Integer> storage) {
        StringBuilder builder = new StringBuilder();
        builder.append(REPORT_FILE_HEADER).append(System.lineSeparator());
        for (Entry<String, Integer> storageElements : storage.entrySet()) {
            builder.append(storageElements.getKey()).append(COMA_SEPARATOR)
                .append(storageElements.getValue())
            .append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}

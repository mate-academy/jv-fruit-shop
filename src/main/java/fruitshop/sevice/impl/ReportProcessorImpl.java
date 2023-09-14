package fruitshop.sevice.impl;

import fruitshop.db.Storage;
import fruitshop.sevice.ReportProcessorService;
import java.util.Map;

public class ReportProcessorImpl implements ReportProcessorService {
    private static final String COMMA = ",";
    private static final String DEFAULT_FIRST_LINE = "fruit,quantity";

    @Override
    public String generateReport() {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(DEFAULT_FIRST_LINE).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : Storage.getStorage().entrySet()) {
            reportBuilder.append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return reportBuilder.toString();
    }
}

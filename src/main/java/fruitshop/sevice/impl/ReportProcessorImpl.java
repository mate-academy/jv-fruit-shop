package fruitshop.sevice.impl;

import fruitshop.db.Storage;
import fruitshop.sevice.ReportProcessorService;
import java.util.Map;

public class ReportProcessorImpl implements ReportProcessorService {
    @Override
    public String generateReport() {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("fruit,quantity").append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : Storage.getStorage().entrySet()) {
            reportBuilder.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return reportBuilder.toString();

    }
}

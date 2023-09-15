package core.basesyntax.service.serviceimpl;

import core.basesyntax.service.CreateReportService;
import core.basesyntax.storage.Storage;
import java.util.Map;

public class CreateReportServiceImpl implements CreateReportService {
    private static final String FIRST_LINE = "fruit,quantity";
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String DATA_SEPARATOR = ",";

    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder(FIRST_LINE).append(LINE_SEPARATOR);
        for (Map.Entry entry : Storage.getFruits().entrySet()) {
            report.append(entry.getKey()).append(DATA_SEPARATOR)
                    .append(entry.getValue()).append(LINE_SEPARATOR);
        }
        return report.toString().trim();
    }
}

package core.basesyntax.service.impl;

import core.basesyntax.service.impl.service.ReportService;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    private static final String COMA_DELIMITER = ",";
    private static final String INVALID_INPUT_PARAMETER = "Invalid input parameter in getReport()";

    @Override
    public String getReport(List<String> fruitsList, List<Integer> amounts) {
        if (fruitsList == null || amounts == null) {
            throw new RuntimeException(INVALID_INPUT_PARAMETER);
        }
        StringBuilder report = new StringBuilder();
        for (int i = 0; i < fruitsList.size(); i++) {
            report.append(fruitsList.get(i)).append(COMA_DELIMITER)
                    .append(amounts.get(i)).append(System.lineSeparator());
        }
        return report.toString();
    }
}

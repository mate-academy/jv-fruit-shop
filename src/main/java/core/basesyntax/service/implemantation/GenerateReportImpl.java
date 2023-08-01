package core.basesyntax.service.implemantation;

import core.basesyntax.service.GenerateReport;
import core.basesyntax.storage.Storage;

import java.util.Map;

public class GenerateReportImpl implements GenerateReport {
    private static final String INFORMATION_LINE = "fruit,quantity\n";
    private static final String PUNCTUATION_MARK = ",";
    private static final int NUMBER_TO_REMOVE_LAST_SEPARATOR = 1;

    @Override
    public String generateReport() {
        StringBuilder report = new StringBuilder();
        report.append(INFORMATION_LINE);
        for (Map.Entry<String, Integer> entry : Storage.storage.entrySet()) {
            report.append(entry.getKey())
                    .append(PUNCTUATION_MARK)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.substring(0, report.length() - NUMBER_TO_REMOVE_LAST_SEPARATOR);
    }
}

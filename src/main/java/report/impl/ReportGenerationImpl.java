package report.impl;

import java.util.Map;
import report.ReportFormatter;
import report.ReportGenerator;

public class ReportGenerationImpl implements ReportGenerator {

    @Override
    public String generateReport(Map<String, Integer> storage, ReportFormatter formatter) {
        return formatter.format(storage);
    }
}

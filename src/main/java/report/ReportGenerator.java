package report;

import java.util.Map;

public interface ReportGenerator {

    String generateReport(Map<String, Integer> storage, ReportFormatter reportFormatter);
}

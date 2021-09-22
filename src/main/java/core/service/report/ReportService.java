package core.service.report;

import java.util.List;

public interface ReportService {
    String PATH_OUTPUT = "src/main/resources/report_output.csv";

    List<String> createReport();

    void writeReport(List<String> report, String path);
}

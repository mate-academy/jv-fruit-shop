package core.service.report;

import java.util.List;

public interface ReportGenerator {
    List<String> createReport(List<String> strings);
}

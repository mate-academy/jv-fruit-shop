package core.basesyntax.service;

import java.util.List;

public interface ReportService {
    String HEAD_OF_REPORT_TABLE = "fruit,quantity";
    List<String> createReport(List<String> dailyBalanceList);
}

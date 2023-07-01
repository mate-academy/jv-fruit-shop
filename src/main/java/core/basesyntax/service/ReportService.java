package core.basesyntax.service;

import java.util.List;

public interface ReportService {
    String HEAD_OF_REPORT_TABLE = "fruit,quantity";
    default List<String> createReport(List<String> dailyBalanceList) {
        dailyBalanceList.add(0, HEAD_OF_REPORT_TABLE);
        return dailyBalanceList;
    }
}

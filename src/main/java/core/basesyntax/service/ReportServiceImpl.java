package core.basesyntax.service;

import java.util.List;

public class ReportServiceImpl implements ReportService {

    @Override
    public List<String> createReport(List<String> dailyBalanceList) {
        dailyBalanceList.add(0, HEAD_OF_REPORT_TABLE);
        return dailyBalanceList;
    }
}

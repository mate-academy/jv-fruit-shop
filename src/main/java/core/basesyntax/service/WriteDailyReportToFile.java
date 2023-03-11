package core.basesyntax.service;

import core.basesyntax.db.Dao;
import core.basesyntax.db.DaoCsvImpl;
import java.util.List;

public class WriteDailyReportToFile {
    public static final String REPORT_0FULL_PATH = "src/main/resources/report.csv";

    public WriteDailyReportToFile() {

    }

    public void writeReportToFile(List<String> dailyTransactionsStringList) {
        Dao reportDao = new DaoCsvImpl(REPORT_0FULL_PATH);
        reportDao.writeDataToFile(dailyTransactionsStringList);
    }
}

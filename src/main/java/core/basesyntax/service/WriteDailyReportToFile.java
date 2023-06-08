package core.basesyntax.service;

import core.basesyntax.db.DataBase;
import core.basesyntax.db.DataBaseCsvImpl;
import java.util.List;

public class WriteDailyReportToFile {
    public static final String REPORT_FULL_PATH = "src/main/resources/report.csv";

    public WriteDailyReportToFile() {

    }

    public void writeReportToFile(List<String> dailyTransactionsStringList) {
        DataBase reportDataBase = new DataBaseCsvImpl(REPORT_FULL_PATH);
        reportDataBase.writeDataToFile(dailyTransactionsStringList);
    }
}

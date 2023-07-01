package core.basesyntax.service;

import core.basesyntax.db.DataBase;
import core.basesyntax.db.DataBaseCsvImpl;
import java.util.List;

public class FileWriterImpl implements FileWriter {
    private final String reportFullPath;

    public FileWriterImpl(String reportFullPath) {
        this.reportFullPath = reportFullPath;
    }

    public void writeToFile(List<String> dailyTransactionsStringList) {
        DataBase reportDataBase = new DataBaseCsvImpl(reportFullPath);
        reportDataBase.writeDataToFile(dailyTransactionsStringList);
    }
}

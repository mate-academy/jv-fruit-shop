package core.basesyntax.service;

import core.basesyntax.db.DataBase;
import core.basesyntax.db.DataBaseCsvImpl;
import java.util.List;

public class FileWriterImpl implements FileWriter {

    public void writeToFile(List<String> dailyTransactionsStringList, String reportFullPath) {
        DataBase reportDataBase = new DataBaseCsvImpl(reportFullPath);
        reportDataBase.writeDataToFile(dailyTransactionsStringList);
    }
}

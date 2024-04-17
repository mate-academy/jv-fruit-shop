package core.basesyntax.service;

import core.basesyntax.db.DataBase;

public interface ReportWriterToFile {

    void getReport(String filePath, DataBase reportCreator);
}

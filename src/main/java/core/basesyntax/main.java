package core.basesyntax;

import core.basesyntax.dao.ReadFileDao;
import core.basesyntax.dao.ReadFileDaoImpl;
import core.basesyntax.process.DataProcess;
import core.basesyntax.report.ReportCreator;
import core.basesyntax.storage.FruitStorage;
import core.basesyntax.writeReport.WriteReport;
import core.basesyntax.writeReport.WriteReportImpl;

public class main {
    public static void main(String[] args) {
        FruitStorage fruitStorage = new FruitStorage();
        ReadFileDao readFileDao = new ReadFileDaoImpl();
        DataProcess dataProcess = new DataProcess();
        dataProcess.addDataToStorage(readFileDao.data(), fruitStorage);
        ReportCreator reportCreator = new ReportCreator();
        String report = reportCreator.createReport(fruitStorage.getStorage());
        WriteReport writeReport = new WriteReportImpl();
        writeReport.writeReportToFile(report);
    }
}

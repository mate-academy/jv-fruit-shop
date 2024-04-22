package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ReportServiceImpl;
import core.basesyntax.service.WriteReport;
import core.basesyntax.service.WriteReportImpl;

public class HelloWorld {
    public static void main(String[] args) {
        ReportService reportService = new ReportServiceImpl();
        String filePath = "src/main/java/core/basesyntax/db/storageInputFile.csv";
        reportService.solveReport(filePath);
        FruitDao fruitDao = new FruitDaoImpl();
        WriteReport writeReport = new WriteReportImpl();
        writeReport.writeReport(fruitDao.getFruitList());
    }
}

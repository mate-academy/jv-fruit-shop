package core.basesyntax.service;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.dao.FruitTransactionDaoIml;

public class ReportServiceImpl implements ReportService{
   private FruitTransactionDao fruitTransactionDao = new FruitTransactionDaoIml();
   private WriteScvService writeScvService = new WriteScvServiceIml();

   private String nameReportFile = "report.csv";

    @Override
    public void createReport() {
        writeScvService.writeDataScvFile(fruitTransactionDao.getAllListDb(),nameReportFile );
    }
}

package core.basesyntax;

import core.basesyntax.dao.FruitShopDao;
import core.basesyntax.dao.FruitShopDaoImpl;
import core.basesyntax.service.file.FileReaderService;
import core.basesyntax.service.report.DailyReport;
import core.basesyntax.service.report.ReportMaker;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        File incomeFile = new File("income.csv");
        FruitShopDao fruitShopDao = new FruitShopDaoImpl();
        ReportMaker reportMaker = new DailyReport();
        String data = FileReaderService.getFromFile(incomeFile);
        fruitShopDao.updateStorage(data);
        String dataFromStorage = fruitShopDao.getDataFromStorage();
        reportMaker.makeReport(dataFromStorage);
    }
}

package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.service.file.FileReaderService;
import core.basesyntax.service.parser.ParseData;
import core.basesyntax.service.parser.ParseDataImpl;
import core.basesyntax.service.report.ReportMaker;
import core.basesyntax.service.report.ReportMakerImpl;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        File incomeFile = new File("income.csv");
        FruitDao fruitShopDao = new FruitDaoImpl();
        ReportMaker reportMaker = new ReportMakerImpl();
        ParseData dataParser = new ParseDataImpl();
        String data = FileReaderService.getFromFile(incomeFile);
        fruitShopDao.updateStorage(dataParser.parse(data));
        String dataFromStorage = fruitShopDao.getDataFromStorage();
        reportMaker.makeReport(dataFromStorage);
    }
}

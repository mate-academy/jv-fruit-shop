package core.basesyntax;

import core.basesyntax.dao.FruitShopDao;
import core.basesyntax.dao.FruitShopDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import java.util.List;

public class Main {
    private static final String FILE_FROM_NAME = "src/main/java/core/basesyntax/FruitShopInfo.csv";
    private static final String FILE_TO_NAME = "src/main/java/core/basesyntax/FruitShopReport.csv";

    public static void main(String[] args) {
        FruitShopDao fruitShopDao = new FruitShopDaoImpl();
        ShopService shopService = new ShopServiceImpl();
        ReportService reportService = new ReportServiceImpl();
        WriterService writerService = new WriterServiceImpl();
        String dataFromFile = fruitShopDao.getFromFile(FILE_FROM_NAME);
        List<FruitTransaction> fruits = fruitShopDao.fruitFromString(dataFromFile);
        for (FruitTransaction fruit : fruits) {
            shopService.transaction(fruit);
        }
        String report = reportService.report();
        writerService.writeToFile(FILE_TO_NAME, report);
    }
}

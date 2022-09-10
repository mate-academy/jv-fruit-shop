package core.basesyntax;

import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.ConvertWriteDataService;
import core.basesyntax.service.FileWriteService;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.FileReadService;
import core.basesyntax.service.impl.ConvertReadDataServiceImpl;
import core.basesyntax.service.impl.ConvertWriteDataServiceImpl;
import core.basesyntax.service.impl.FileReadServiceImpl;
import core.basesyntax.service.impl.FileWriteServiceImpl;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import java.util.List;

public class FruitShop {
    private static final String PATH_TO_DATA_FILE = "src/main/resources/";
    private static final String STORAGE_FILE_NAME = "storage.csv";
    private static final String REPORT_FILE_NAME = "report.csv";

    public static void main(String[] args) {
        FileReadService reader = new FileReadServiceImpl();
        List<String> dataFromFile = reader.readDataFromFile(PATH_TO_DATA_FILE
                + STORAGE_FILE_NAME);
        List<Transaction> transactions = new ConvertReadDataServiceImpl()
                .convertDataFromFile(dataFromFile);
        FruitShopService fruitShopService = new FruitShopServiceImpl(new OperationStrategyImpl());
        fruitShopService.doTransaction(transactions);
        ConvertWriteDataService convertWriteDataService = new ConvertWriteDataServiceImpl();
        String report
                = convertWriteDataService.convertDataToFile(new FruitDaoImpl()
                .getStorageState());
        FileWriteService fileWriteService = new FileWriteServiceImpl();
        fileWriteService.writeDataToFile(report, PATH_TO_DATA_FILE + REPORT_FILE_NAME);
    }
}

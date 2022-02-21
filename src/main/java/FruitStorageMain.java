import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.sevice.ConvertReadedDataServiceImpl;
import core.basesyntax.sevice.ConvertWriteDataService;
import core.basesyntax.sevice.ConvertWriteDataServiceImpl;
import core.basesyntax.sevice.FileReadServiceImpl;
import core.basesyntax.sevice.FileWriteService;
import core.basesyntax.sevice.FileWriteServiceImpl;
import core.basesyntax.sevice.FruitShopService;
import core.basesyntax.sevice.FruitShopServiceImpl;
import core.basesyntax.strategy.OperationStrategyImpl;

import java.util.List;

public class FruitStorageMain {
    private static final String SOURCE_FILE_NAME = "src/main/resources/InputData.csv";
    private static final String REPORT_FILE_NAME = "src/main/resources/Report.csv";

    public static void main(String[] args) {
/*
        Storage.fruitStorage.put("banana", 20);
        Storage.fruitStorage.put("apple", 20);
        Storage.fruitStorage.put("orange", 30);
        System.out.println(Storage.fruitStorage.get("orange"));
        System.out.println(Storage.fruitStorage.get("x"));

        FruitDaoImpl fruitDao = new FruitDaoImpl();
        System.out.println(fruitDao.get("apple"));
        System.out.println(fruitDao.get("Y"));

 */


        List<String> dataFromFile = new FileReadServiceImpl().readDataFromFile(SOURCE_FILE_NAME);
        List<FruitTransaction> convertedData = new ConvertReadedDataServiceImpl()
                .convertDataFromFile(dataFromFile);
        FruitShopService fruitShopService = new FruitShopServiceImpl(new OperationStrategyImpl());
        fruitShopService.doFruitShopOperation(convertedData);
        ConvertWriteDataService convertWriteDataService = new ConvertWriteDataServiceImpl();
        String report
                = convertWriteDataService.convertDataToFile(new FruitDaoImpl()
                        .getStorageState());
        FileWriteService fileWriteService = new FileWriteServiceImpl();
        fileWriteService.writeDataToFile(report, REPORT_FILE_NAME);
    }
}

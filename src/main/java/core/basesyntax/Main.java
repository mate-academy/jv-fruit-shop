package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileService;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.StorageDao;
import core.basesyntax.service.impl.FileServiceImpl;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import java.util.List;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {

    private static final String SOURCE_FILE_PATH = "src/main/resources/data.csv";
    private static final String RESULT_FILE_PATH = "src/main/resources/result.csv";

    public static void main(String[] args) {
        FruitShopService fruitShopService = new FruitShopServiceImpl();

        FileService fileService = new FileServiceImpl();
        List<FruitTransaction> fruitTransactionList = fileService.getData(SOURCE_FILE_PATH);

        StorageDao fruitStorage = fruitShopService.processOperations(fruitTransactionList);
        ReportService reportService = new ReportServiceImpl();
        List<String> fruitReport = reportService.makeReport(fruitStorage);

        fileService.writeData(RESULT_FILE_PATH, fruitReport);
    }
}

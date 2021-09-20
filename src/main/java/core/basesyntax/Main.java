package core.basesyntax;

import static core.basesyntax.OperationType.BALANCE;
import static core.basesyntax.OperationType.PURCHASE;
import static core.basesyntax.OperationType.RETURN;
import static core.basesyntax.OperationType.SUPPLY;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.fileservice.FileService;
import core.basesyntax.fileservice.FileServiceImpl;
import core.basesyntax.operationstrategy.BalanceOperationHandler;
import core.basesyntax.operationstrategy.OperationHandler;
import core.basesyntax.operationstrategy.OperationStrategy;
import core.basesyntax.operationstrategy.OperationStrategyImpl;
import core.basesyntax.operationstrategy.PurchaseOperationHandler;
import core.basesyntax.operationstrategy.ReturnOperationHandler;
import core.basesyntax.operationstrategy.SupplyOperationHandler;
import core.basesyntax.parser.FruitRecordParser;
import core.basesyntax.parser.FruitRecordParserImpl;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitServiceImpl;
import core.basesyntax.service.ReportBuilderService;
import core.basesyntax.service.ReportBuilderServiceImpl;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String[] TEST_ARRAY = new String[] {"type,fruit,quantity",
            "b,banana,20",
            "b,apple,100",
            "s,banana,100",
            "p,banana,13",
            "r,apple,10",
            "p,apple,20",
            "p,banana,5",
            "s,banana,50"};
    private static final Path TEST_FRUIT_SHOP_CSV = Path.of("src/main/resources/fruitShopCSV.csv");
    private static final Path TEST_CSV_REPORT = Path.of("src/main/resources/CSVReport.csv");

    public static void main(String[] args) {
        Map<OperationType, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(SUPPLY, new SupplyOperationHandler());
        operationHandlerMap.put(PURCHASE, new PurchaseOperationHandler());
        operationHandlerMap.put(RETURN, new ReturnOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        List<String> listOfCsvRecords = Arrays.asList(TEST_ARRAY);
        FileService fileService = new FileServiceImpl();
        fileService.writeToFile(listOfCsvRecords, TEST_FRUIT_SHOP_CSV);
        FruitRecordParser fruitRecordParser = new FruitRecordParserImpl();
        FruitStorageDao fruitStorageDao = new FruitStorageDaoImpl();
        FruitService fruitService = new FruitServiceImpl(fileService, fruitRecordParser,
                operationStrategy, fruitStorageDao);
        fruitService.saveFruitRecordsFromFile(TEST_FRUIT_SHOP_CSV);
        ReportBuilderService reportBuilderService = new ReportBuilderServiceImpl(fruitStorageDao,
                fileService);
        reportBuilderService.buildReport(TEST_CSV_REPORT);
    }
}

package core.basesyntax;

import static core.basesyntax.OperationType.BALANCE;
import static core.basesyntax.OperationType.PURCHASE;
import static core.basesyntax.OperationType.RETURN;
import static core.basesyntax.OperationType.SUPPLY;

import core.basesyntax.dao.FruitRecordsDao;
import core.basesyntax.dao.FruitRecordsDaoImpl;
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
import core.basesyntax.validator.Validator;
import core.basesyntax.validator.ValidatorImpl;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Path TEST_FRUIT_SHOP_CSV = Path.of("src/main/resources/fruitShopCSV.csv");
    private static final Path TEST_CSV_REPORT = Path.of("src/main/resources/CSVReport.csv");

    public static void main(String[] args) throws ValidatorException {
        Map<OperationType, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(SUPPLY, new SupplyOperationHandler());
        operationHandlerMap.put(PURCHASE, new PurchaseOperationHandler());
        operationHandlerMap.put(RETURN, new ReturnOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FileService fileService = new FileServiceImpl();
        FruitRecordParser fruitRecordParser = new FruitRecordParserImpl();
        FruitRecordsDao fruitRecordsDao = new FruitRecordsDaoImpl();
        Validator<String> validator = new ValidatorImpl();
        for (String record : fileService.readFromFile(TEST_FRUIT_SHOP_CSV)) {
            validator.validate(record);
        }
        FruitService fruitService = new FruitServiceImpl(fileService, fruitRecordParser,
                operationStrategy, fruitRecordsDao);
        fruitService.saveFruitRecordsFromFile(TEST_FRUIT_SHOP_CSV);
        ReportBuilderService reportBuilderService = new ReportBuilderServiceImpl(fruitRecordsDao,
                fileService);
        reportBuilderService.buildReport(TEST_CSV_REPORT);
    }
}

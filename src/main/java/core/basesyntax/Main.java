package core.basesyntax;

import static core.basesyntax.model.OperationType.BALANCE;
import static core.basesyntax.model.OperationType.PURCHASE;
import static core.basesyntax.model.OperationType.RETURN;
import static core.basesyntax.model.OperationType.SUPPLY;

import core.basesyntax.db.FruitRecordsDao;
import core.basesyntax.db.FruitRecordsDaoImpl;
import core.basesyntax.exception.ValidatorException;
import core.basesyntax.fileservice.FileService;
import core.basesyntax.fileservice.FileServiceImpl;
import core.basesyntax.model.OperationType;
import core.basesyntax.model.TransactionDto;
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
import core.basesyntax.validator.Validator;
import core.basesyntax.validator.ValidatorImpl;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
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
        Validator<String> validator = new ValidatorImpl();
        List<String> lines = fileService.readFromFile(TEST_FRUIT_SHOP_CSV);
        for (String record : lines) {
            validator.validate(record);
        }
        FruitRecordParser fruitRecordParser = new FruitRecordParserImpl();
        List<TransactionDto> fruitRecordsList = fruitRecordParser.parse(lines);
        FruitRecordsDao fruitRecordsDao = new FruitRecordsDaoImpl();
        FruitService fruitService = new FruitServiceImpl(operationStrategy, fruitRecordsDao);
        fruitService.saveFruitRecordsFromFile(fruitRecordsList);
        fileService.writeToFile(fruitService.buildReportToList(), TEST_CSV_REPORT);
    }
}

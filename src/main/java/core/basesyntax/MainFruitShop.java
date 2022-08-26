package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.FruitOperation;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.impl.BalanceOperationHandlerImpl;
import core.basesyntax.service.impl.CsvReportCreatorImpl;
import core.basesyntax.service.impl.CsvTransactionParserImpl;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.PurchaseOperationHandlerImpl;
import core.basesyntax.service.impl.ReturnOperationHandlerImpl;
import core.basesyntax.service.impl.SupplyOperationHandlerImpl;
import core.basesyntax.strategy.Strategy;
import core.basesyntax.strategy.StrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainFruitShop {
    private static final String INPUT_DATA_FILE = "src/main/resources/input_data.csv";
    private static final String OUTPUT_DATA_FILE = "src/main/resources/output_data.csv";

    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        StorageDao storageDao = new StorageDaoImpl();
        FruitService fruitService = new FruitServiceImpl(storageDao);

        Map<FruitOperation.Operation, OperationHandler> operationCalculateMap = new HashMap<>();
        operationCalculateMap.put(FruitOperation.Operation.SUPPLY,
                new SupplyOperationHandlerImpl(fruitService));
        operationCalculateMap.put(FruitOperation.Operation.PURCHASE,
                new PurchaseOperationHandlerImpl(fruitService));
        operationCalculateMap.put(FruitOperation.Operation.RETURN,
                new ReturnOperationHandlerImpl(fruitService));
        operationCalculateMap.put(FruitOperation.Operation.BALANCE,
                new BalanceOperationHandlerImpl(fruitService));

        Strategy strategy = new StrategyImpl(operationCalculateMap);
        TransactionParser operationDataFileParser = new CsvTransactionParserImpl();

        List<String> data = fileReaderService.readFromFile(INPUT_DATA_FILE);
        List<FruitOperation> fruitOperations = operationDataFileParser.parseDataFile(data);

        for (FruitOperation fruitOperation : fruitOperations) {
            strategy.get(fruitOperation.getOperation()).handle(fruitOperation);
        }

        ReportCreator report = new CsvReportCreatorImpl(fruitService);
        String reportByDay = report.makeReport();
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(OUTPUT_DATA_FILE,reportByDay);
    }
}

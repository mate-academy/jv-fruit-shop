package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParserService;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.GenerateReportService;
import core.basesyntax.service.impl.DataParserServiceImpl;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.service.impl.GenerateReportServiceImpl;
import core.basesyntax.service.operation.BalanceOperationHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseOperationHandler;
import core.basesyntax.service.operation.ReturnHandlerOperation;
import core.basesyntax.service.operation.SupplyOperationHandler;
import core.basesyntax.service.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_FROM_PATH =
            "src/main/java/core/basesyntax/resources/infoFile.csv";
    private static final String REPORT_FILE_PATH =
            "src/main/java/core/basesyntax/resources/report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnHandlerOperation());
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> dataFromFile = fileReaderService.readFile(FILE_FROM_PATH);
        DataParserService dataParserService = new DataParserServiceImpl();
        List<FruitTransaction> fruitTransactions = dataParserService.dataParser(dataFromFile);
        FruitShopService fruitShopService =
                new FruitShopServiceImpl(new OperationStrategyImpl(operationHandlerMap));
        fruitShopService.processingOperations(fruitTransactions);
        GenerateReportService generateReportService = new GenerateReportServiceImpl();
        String report = generateReportService.generateReport();
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeFile(REPORT_FILE_PATH, report);

    }
}

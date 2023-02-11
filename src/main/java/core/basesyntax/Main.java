package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.FileService;
import core.basesyntax.services.ReportService;
import core.basesyntax.services.TransactionParser;
import core.basesyntax.services.impl.FileServiceImpl;
import core.basesyntax.services.impl.ReportServiceImpl;
import core.basesyntax.services.impl.TransactionParserImpl;
import core.basesyntax.services.strategy.OperationHandler;
import core.basesyntax.services.strategy.OperationStrategy;
import core.basesyntax.services.strategy.impl.BalanceHandlerOperation;
import core.basesyntax.services.strategy.impl.OperationStrategyImpl;
import core.basesyntax.services.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.services.strategy.impl.ReturnHandlerOperation;
import core.basesyntax.services.strategy.impl.SupplyHandlerOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "scr/main/resources/dataInput.csv";
    private static final String OUTPUT_FILE_PATH = "scr/main/resources/dataOutput.csv";

    public static void main(String[] args) {
        FileService fileReadService = new FileServiceImpl();
        List<String> dataFromFile = fileReadService.parseDataFromFile(INPUT_FILE_PATH);

        Map<FruitTransaction.Operation, OperationHandler> typeOperationHandlerMap = new HashMap<>();
        typeOperationHandlerMap.put(FruitTransaction
                .Operation.BALANCE, new BalanceHandlerOperation());
        typeOperationHandlerMap.put(FruitTransaction
                .Operation.SUPPLY, new SupplyHandlerOperation());
        typeOperationHandlerMap.put(FruitTransaction
                .Operation.PURCHASE, new PurchaseOperationHandler());
        typeOperationHandlerMap.put(FruitTransaction
                .Operation.RETURN, new ReturnHandlerOperation());

        TransactionParser parser = new TransactionParserImpl();
        List<FruitTransaction> fruitTransactionsToList = parser.parse(dataFromFile);

        OperationStrategy operationStrategy = new OperationStrategyImpl(typeOperationHandlerMap);

        for (FruitTransaction fruitTransaction : fruitTransactionsToList) {
            OperationHandler handler = operationStrategy.get(fruitTransaction.getOperation());
            handler.handle(fruitTransaction);
        }

        ReportService reportService = new ReportServiceImpl();
        String fileReport = reportService.createReport();

        FileService fileWriteService = new FileServiceImpl();
        fileWriteService.writeDataToFile(fileReport, OUTPUT_FILE_PATH);
    }
}

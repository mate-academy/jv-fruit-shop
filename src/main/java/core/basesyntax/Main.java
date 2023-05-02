package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportCreatorService;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportCreatorServiceImpl;
import core.basesyntax.service.impl.TransactionProcessorImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationHandlerStrategy;
import core.basesyntax.strategy.OperationHandlerStrategyImpl;
import core.basesyntax.strategy.operation.BalanceHandler;
import core.basesyntax.strategy.operation.OperationHandler;
import core.basesyntax.strategy.operation.PurchaseHandler;
import core.basesyntax.strategy.operation.ReturnHandler;
import core.basesyntax.strategy.operation.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_NAME_INPUT_DATA = "src/main/resources/inputData.csv";
    private static final String FILE_NAME_PROCESSED_DATA = "src/main/resources/outputData.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());

        ReaderService readerService = new ReaderServiceImpl();
        List<String[]> dataFromFile = readerService.readFromFile(FILE_NAME_INPUT_DATA);

        ParserService parserService = new ParserServiceImpl();
        List<FruitTransaction> fruitTransactions = parserService.parse(dataFromFile);

        OperationHandlerStrategy strategy = new OperationHandlerStrategyImpl(operationHandlerMap);

        TransactionProcessor processor = new TransactionProcessorImpl(strategy);
        processor.processData(fruitTransactions);

        ReportCreatorService creatorService = new ReportCreatorServiceImpl();
        List<String> report = creatorService.createReport();

        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(FILE_NAME_PROCESSED_DATA, report);
    }
}

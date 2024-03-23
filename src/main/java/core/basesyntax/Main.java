package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.*;
import core.basesyntax.service.impl.*;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.operation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_NAME_INPUT_DATA = "src/main/resources/inputData.csv";
    private static final String REPORT_FILE_NAME = "src/main/resources/outputData.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());


        ReaderService readerService = new ReaderServiceImpl();
        List<String> dataFromFile = readerService.readFromFile(FILE_NAME_INPUT_DATA);

        ParserService parserService = new ParserServiceImpl();
        List<FruitTransaction> fruitTransactions = parserService.parse(dataFromFile);

        OperationStrategy strategy = new OperationStrategyImpl(operationHandlerMap);

        TransactionService processedData = new TransactionServiceImpl(strategy);
        processedData.processData(fruitTransactions);

        ReportCreatorService reportCreatorService = new ReportCreatorServiceImpl();
        List<String> report = reportCreatorService.createReport();

        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(REPORT_FILE_NAME, report);
    }
}

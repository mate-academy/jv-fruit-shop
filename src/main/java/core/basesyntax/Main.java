package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import model.FruitTransaction.Operation;
import service.FruitTransactionService;
import service.ReaderService;
import service.ReportService;
import service.WriterService;
import service.impl.FruitTransactionServiceImpl;
import service.impl.ReaderServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.WriterServiceImpl;
import strategy.OperationHandler;
import strategy.OperationStrategy;
import strategy.OperationStrategyImpl;
import strategy.handlers.BalanceHandlerImpl;
import strategy.handlers.PurchaseHandlerImpl;
import strategy.handlers.ReturnHandlerImpl;
import strategy.handlers.SupplyHandlerImpl;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/fruits.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.BALANCE, new BalanceHandlerImpl());
        operationHandlerMap.put(Operation.SUPPLY, new SupplyHandlerImpl());
        operationHandlerMap.put(Operation.RETURN, new ReturnHandlerImpl());
        operationHandlerMap.put(Operation.PURCHASE, new PurchaseHandlerImpl());
        List<String> inputDataList = readerService.readFromFile(INPUT_FILE_PATH);
        FruitTransactionService fruitTransactionService = new FruitTransactionServiceImpl();
        List<FruitTransaction> fruitTransactionList = fruitTransactionService
                .parseFruitTransactions(inputDataList);
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        for (FruitTransaction fruitTransaction : fruitTransactionList) {
            OperationHandler operationHandler = operationStrategy
                    .getOperationHandler(fruitTransaction.getOperation());
            operationHandler.apply(fruitTransaction);
        }
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.getReport();
        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(report, OUTPUT_FILE_PATH);
    }
}

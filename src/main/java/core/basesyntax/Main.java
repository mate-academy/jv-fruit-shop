package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.ParserService;
import service.ReaderService;
import service.ReportService;
import service.WriterService;
import service.impl.ParserServiceImpl;
import service.impl.ReaderServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.WriterServiceImpl;
import strategy.OperationStrategy;
import strategy.TransactionHandler;
import strategy.impl.BalanceTransactionImpl;
import strategy.impl.OperationStrategyImpl;
import strategy.impl.PurchaseTransactionImpl;
import strategy.impl.ReturnTransactionImpl;
import strategy.impl.SupplyTransactionImpl;

public class Main {
    private static final String FROM_FILE_NAME = "src/main/resources/file.txt";
    private static final String TO_FILE_NAME = "src/main/resources/report.txt";

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        List<String> data = readerService.readFromFile(FROM_FILE_NAME);
        Map<FruitTransaction.Operation, TransactionHandler> transactionHandlerMap = new HashMap<>();
        transactionHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceTransactionImpl());
        transactionHandlerMap
                .put(FruitTransaction.Operation.PURCHASE, new PurchaseTransactionImpl());
        transactionHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnTransactionImpl());
        transactionHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyTransactionImpl());
        OperationStrategy operationStrategy = new OperationStrategyImpl(transactionHandlerMap);
        ParserService parserService = new ParserServiceImpl();
        List<FruitTransaction> fruitTransactions = parserService.parseLines(data);
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            TransactionHandler transactionHandler = operationStrategy
                    .get(fruitTransaction.getOperation());
            transactionHandler.handleTransaction(fruitTransaction);
        }
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport();
        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(report, TO_FILE_NAME);
    }
}

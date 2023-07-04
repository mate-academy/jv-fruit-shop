package mate.academy;

import java.util.List;
import java.util.Map;
import mate.academy.model.FruitTransaction;
import mate.academy.service.ParserService;
import mate.academy.service.ProcessDataService;
import mate.academy.service.ReaderService;
import mate.academy.service.ReportService;
import mate.academy.service.WriterService;
import mate.academy.service.impl.ParserServiceImpl;
import mate.academy.service.impl.ProcessDataServiceImpl;
import mate.academy.service.impl.ReaderServiceImpl;
import mate.academy.service.impl.ReportServiceImpl;
import mate.academy.service.impl.WriterServiceImpl;
import mate.academy.service.transaction.BalanceHandlerImpl;
import mate.academy.service.transaction.PurchaseHandlerImpl;
import mate.academy.service.transaction.ReturnHandlerImpl;
import mate.academy.service.transaction.SupplyHandlerImpl;
import mate.academy.service.transaction.TransactionHandler;
import mate.academy.strategy.TransactionStrategy;
import mate.academy.strategy.TransactionStrategyImpl;

public class Main {
    private static final String inputFilePath = "src/main/java/mate/academy/resources/database.csv";
    private static final String reportFilePath = "src/main/java/mate/academy/resources/report.csv";
    private static final ReaderService readerService = new ReaderServiceImpl();
    private static final ParserService parserService = new ParserServiceImpl();
    private static final ProcessDataService processDataService = new ProcessDataServiceImpl();
    private static final ReportService reportService = new ReportServiceImpl();
    private static final WriterService writerService = new WriterServiceImpl();

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, TransactionHandler> transactionHandlersMap = Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceHandlerImpl(),
                FruitTransaction.Operation.PURCHASE,
                new PurchaseHandlerImpl(),
                FruitTransaction.Operation.SUPPLY,
                new SupplyHandlerImpl(),
                FruitTransaction.Operation.RETURN,
                new ReturnHandlerImpl());
        List<String> inputData = readerService.readFromFile(inputFilePath);
        List<FruitTransaction> transactions = parserService.parseData(inputData);

        TransactionStrategy transactionStrategy = new TransactionStrategyImpl(
                transactionHandlersMap);
        processDataService.processTransactions(transactions, transactionStrategy);

        String report = reportService.createReport();
        writerService.writeToFile(report, reportFilePath);
    }
}

package mate.academy;

import java.util.List;
import java.util.Map;
import mate.academy.model.FruitTransaction;
import mate.academy.service.Parser;
import mate.academy.service.ProcessData;
import mate.academy.service.Reader;
import mate.academy.service.Report;
import mate.academy.service.Writer;
import mate.academy.service.impl.ParserImpl;
import mate.academy.service.impl.ProcessImpl;
import mate.academy.service.impl.ReaderImpl;
import mate.academy.service.impl.ReportImpl;
import mate.academy.service.impl.WriterImpl;
import mate.academy.service.transaction.BalanceHandlerImpl;
import mate.academy.service.transaction.PurchaseHandlerImpl;
import mate.academy.service.transaction.ReturnHandlerImpl;
import mate.academy.service.transaction.SupplyHandlerImpl;
import mate.academy.service.transaction.TransactionHandler;
import mate.academy.strategy.TransactionStrategy;
import mate.academy.strategy.TransactionStrategyImpl;

public class Main {
    private static final String inputFilePath = "src/main/resources/database.csv";
    private static final String reportFilePath = "src/main/resources/report.csv";
    private static final Reader readerService = new ReaderImpl();
    private static final Parser parserService = new ParserImpl();
    private static final ProcessData processDataService = new ProcessImpl();
    private static final Report reportService = new ReportImpl();
    private static final Writer writerService = new WriterImpl();

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

package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ProcessDataService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ProcessDataServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.service.transaction.BalanceHandlerImpl;
import core.basesyntax.service.transaction.PurchaseHandlerImpl;
import core.basesyntax.service.transaction.ReturnHandlerImpl;
import core.basesyntax.service.transaction.SupplyHandlerImpl;
import core.basesyntax.service.transaction.TransactionHandler;
import core.basesyntax.strategy.TransactionStrategy;
import core.basesyntax.strategy.TransactionStrategyImpl;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String inputFilePath = "src/main/resources/input.csv";
    private static final String reportFilePath = "src/main/resources/report.csv";
    private static final ReaderService readerService = new ReaderServiceImpl();
    private static final ParserService parserService = new ParserServiceImpl();
    private static final ProcessDataService processDataService = new ProcessDataServiceImpl();
    private static final ReportService reportService = new ReportServiceImpl();
    private static final WriterService writerService = new WriterServiceImpl();

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, TransactionHandler> transactionHandlersMap = Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceHandlerImpl(),
                FruitTransaction.Operation.PURCHASE, new PurchaseHandlerImpl(),
                FruitTransaction.Operation.SUPPLY, new SupplyHandlerImpl(),
                FruitTransaction.Operation.RETURN, new ReturnHandlerImpl()
        );

        List<String> inputData = readerService.readFromFile(inputFilePath);
        List<FruitTransaction> transactions = parserService.parseData(inputData);

        TransactionStrategy transactionStrategy =
                new TransactionStrategyImpl(transactionHandlersMap);
        processDataService.processTransactions(transactions, transactionStrategy);

        String report = reportService.createReport();
        writerService.writeToFile(report, reportFilePath);
    }
}

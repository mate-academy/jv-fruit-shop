package core.basesyntax;

import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileReaderImpl;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FileWriterImpl;
import core.basesyntax.service.FruitTransactionParser;
import core.basesyntax.service.FruitTransactionParserImpl;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.FruitTransactionServiceImpl;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.OperationStrategyImpl;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ReportServiceImpl;
import core.basesyntax.service.strategy.BalanceOperationHandler;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.PurchaseOperationHandler;
import core.basesyntax.service.strategy.ReturnOperationHandler;
import core.basesyntax.service.strategy.SupplyOperationHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String TRANSACTION_FILE_NAME = "src/main/resources/transaction.csv";
    public static final String REPORT_FILE_NAME = "src/main/resources/report.csv";

    private static Map<Operation, OperationHandler> operationsMap = new HashMap<>();

    public static void main(String[] args) {
        initOperationsMap();
        FileReader readDailyTransactions =
                new FileReaderImpl();
        List<String> transactionsStringList = new ArrayList<>(
                readDailyTransactions.getListOfTransactions(TRANSACTION_FILE_NAME));
        FruitTransactionParser fruitTransactionParser =
                new FruitTransactionParserImpl();
        List<Transaction> transactionsList =
                fruitTransactionParser.parseList(transactionsStringList);
        OperationStrategy operationStrategyService = new OperationStrategyImpl(operationsMap);
        FruitTransactionService fruitTransactionService =
                new FruitTransactionServiceImpl(operationStrategyService);
        fruitTransactionService.processDailyReport(transactionsList);
        ReportService reportService = new ReportServiceImpl();
        List<String> dailyTransactionsReport =
                reportService.createReport();
        FileWriter writeDailyReportToFile = new FileWriterImpl();
        writeDailyReportToFile.writeToFile(dailyTransactionsReport, REPORT_FILE_NAME);
    }

    public static void initOperationsMap() {
        operationsMap.put(Operation.SUPPLY, new SupplyOperationHandler());
        operationsMap.put(Operation.BALANCE, new BalanceOperationHandler());
        operationsMap.put(Operation.RETURN, new ReturnOperationHandler());
        operationsMap.put(Operation.PURCHASE, new PurchaseOperationHandler());
    }
}

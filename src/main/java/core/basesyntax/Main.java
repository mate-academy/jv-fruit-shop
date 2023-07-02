package core.basesyntax;

import core.basesyntax.db.DataBase;
import core.basesyntax.db.DataBaseCsvImpl;
import core.basesyntax.db.StorageImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.FileWriterImpl;
import core.basesyntax.service.FruitTransactionParserCsv;
import core.basesyntax.service.FruitTransactionServiceImpl;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.OperationStrategyImpl;
import core.basesyntax.service.ReadDailyTransactionsImpl;
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
import java.util.stream.Collectors;

public class Main {
    public static final String TRANSACTION_FULL_PATH = "src/main/resources/transaction.csv";
    public static final String REPORT_FULL_PATH = "src/main/resources/report.csv";

    public static final String SEPARATE_SYMBOL_FOR_CSV =
            FruitTransactionParserCsv.SEPARATE_SYMBOL_FOR_CSV;
    private static Map<Operation, OperationHandler> operationsMap = new HashMap<>();

    public static void main(String[] args) {
        createFileTransactionsCsv();
        createTransactionsMap();
        ReadDailyTransactionsImpl readDailyTransactions =
                new ReadDailyTransactionsImpl();
        List<String> transactionsStringList = new ArrayList<>(
                readDailyTransactions.getListOfTransactions(TRANSACTION_FULL_PATH));
        FruitTransactionParserCsv csvFruitTransactionParser =
                new FruitTransactionParserCsv();
        List<Transaction> transactionsList = new ArrayList<>(
                csvFruitTransactionParser.parseList(
                        transactionsStringList));
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationsMap);
        FruitTransactionServiceImpl fruitTransactionServiceImpl =
                new FruitTransactionServiceImpl(operationStrategy);
        fruitTransactionServiceImpl.processDailyReport(transactionsList);
        ReportService reportService = new ReportServiceImpl();
        List<String> dailyTransactionsReport =
                reportService.createReport(StorageImpl.getStorage());
        FileWriterImpl writeDailyReportToFile = new FileWriterImpl();
        writeDailyReportToFile.writeToFile(dailyTransactionsReport, REPORT_FULL_PATH);
    }

    public static void createTransactionsMap() {
        operationsMap.put(Operation.SUPPLY, new SupplyOperationHandler());
        operationsMap.put(Operation.BALANCE, new BalanceOperationHandler());
        operationsMap.put(Operation.RETURN, new ReturnOperationHandler());
        operationsMap.put(Operation.PURCHASE, new PurchaseOperationHandler());
    }

    public static void createFileTransactionsCsv() {
        List<Transaction> transaction = new ArrayList<>();
        transaction.add(new Transaction(Operation.BALANCE, Fruit.BANANA, 20));
        transaction.add(new Transaction(Operation.BALANCE, Fruit.APPLE, 100));
        transaction.add(new Transaction(Operation.SUPPLY, Fruit.BANANA, 100));
        transaction.add(new Transaction(Operation.PURCHASE, Fruit.BANANA, 13));
        transaction.add(new Transaction(Operation.RETURN, Fruit.APPLE, 10));
        transaction.add(new Transaction(Operation.PURCHASE, Fruit.APPLE, 20));
        transaction.add(new Transaction(Operation.PURCHASE, Fruit.BANANA, 5));
        transaction.add(new Transaction(Operation.SUPPLY, Fruit.BANANA, 50));
        DataBase transactionsDataBase =
                new DataBaseCsvImpl(TRANSACTION_FULL_PATH);
        transactionsDataBase.writeDataToFile(transactionsListToStringList(
                transaction, ReadDailyTransactionsImpl.HEAD_OF_TRANSACTION_TABLE));
    }

    public static List<String> transactionsListToStringList(
            List<Transaction> transactionsList, String headOfTable) {

        List<String> list = transactionsList
                .stream()
                .map(t -> t.getOperation().getOperation()
                        + SEPARATE_SYMBOL_FOR_CSV
                        + t.getFruit().getFruitName()
                        + SEPARATE_SYMBOL_FOR_CSV
                        + t.getAmount())
                .collect(Collectors.toList());
        list.add(0, headOfTable);
        return list;
    }
}

package core.basesyntax;

import core.basesyntax.db.Dao;
import core.basesyntax.db.DaoCsvImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.CreateDailyReport;
import core.basesyntax.service.ProcessDailyTransactions;
import core.basesyntax.service.ReadDailyTransactions;
import core.basesyntax.service.WriteDailyReportToFile;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static final String SEPARATE_SYMBOL_FOR_CSV =
            ProcessDailyTransactions.SEPARATE_SYMBOL_FOR_CSV;

    public static void main(String[] args) {
        List<Transaction> transaction = new ArrayList<>();
        transaction.add(new Transaction(Operation.BALANCE, Fruit.BANANA, 22));
        transaction.add(new Transaction(Operation.PURCHASE, Fruit.BANANA, 1));
        transaction.add(new Transaction(Operation.RETURN, Fruit.BANANA, 1));
        transaction.add(new Transaction(Operation.SUPPLY, Fruit.BANANA, 1));
        transaction.add(new Transaction(Operation.SUPPLY, Fruit.APPLE, 1));
        transaction.add(new Transaction(Operation.BALANCE, Fruit.APPLE, 1));
        transaction.add(new Transaction(Operation.PURCHASE, Fruit.APPLE, 1));
        transaction.add(new Transaction(Operation.SUPPLY, Fruit.ORANGE, 3));
        transaction.add(new Transaction(Operation.PURCHASE, Fruit.ORANGE, 2));
        transaction.add(new Transaction(Operation.BALANCE, Fruit.LEMON, 2));

        Dao transactionsDao = new DaoCsvImpl(ReadDailyTransactions.TRANSACTION_FULL_PATH);
        transactionsDao.writeDataToFile(transactionsListToStringList(
                transaction, ReadDailyTransactions.HEAD_OF_TRANSACTION_TABLE));

        ReadDailyTransactions readDailyTransactions = new ReadDailyTransactions();
        List<String> transactionsStringList = new ArrayList<>(
                readDailyTransactions.getListOfTransactions());

        ProcessDailyTransactions processDailyTransactions = new ProcessDailyTransactions();
        List<Transaction> transactionsList = new ArrayList<>(
                processDailyTransactions.stringListToTransactionList(transactionsStringList));

        CreateDailyReport createDailyReport = new CreateDailyReport();
        List<String> dailyTransactionsReport = new ArrayList<>(
                createDailyReport.createReport(transactionsList));

        WriteDailyReportToFile writeDailyReportToFile = new WriteDailyReportToFile();
        writeDailyReportToFile.writeReportToFile(dailyTransactionsReport);
    }

    public static List<String> transactionsListToStringList(
            List<Transaction> transactionsList, String headOfTable) {
        List<String> list = transactionsList
                .stream()
                .map(t -> t.getOperation().getTransaction()
                        + SEPARATE_SYMBOL_FOR_CSV
                        + t.getFruit().getFruitName()
                        + SEPARATE_SYMBOL_FOR_CSV
                        + t.getAmount())
                .collect(Collectors.toList());
        list.add(0, headOfTable);
        return list;
    }
}

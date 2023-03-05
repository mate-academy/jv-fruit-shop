package core.basesyntax;

import core.basesyntax.db.Dao;
import core.basesyntax.db.DaoCsvImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.Operation;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.Transaction;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Transaction> transaction = new ArrayList<>();
        transaction.add(new Transaction(Operation.BALANCE, Fruit.BANANA, 2));
        transaction.add(new Transaction(Operation.PURCHASE, Fruit.BANANA, 1));
        transaction.add(new Transaction(Operation.RETURN, Fruit.BANANA, 1));
        transaction.add(new Transaction(Operation.SUPPLY, Fruit.BANANA, 1));
        transaction.add(new Transaction(Operation.SUPPLY, Fruit.APPLE, 1));
        transaction.add(new Transaction(Operation.BALANCE, Fruit.APPLE, 1));
        transaction.add(new Transaction(Operation.PURCHASE, Fruit.APPLE, 1));
        transaction.add(new Transaction(Operation.SUPPLY, Fruit.ORANGE, 3));
        transaction.add(new Transaction(Operation.PURCHASE, Fruit.ORANGE, 2));
        transaction.add(new Transaction(Operation.BALANCE, Fruit.LEMON, 2));
        Dao transactionsDao = new DaoCsvImpl(ReportService.TRANSACTION_FULL_PATH);
        transactionsDao.writeDataToFile(ReportService.transactionsListToStringList(
                transaction, ReportService.HEAD_OF_TRANSACTION_TABLE));
        List<String> transactionsStringList = new ArrayList<>();
        transactionsStringList.addAll(transactionsDao.getDataFromFile());
        ReportService reportService = new ReportService(transactionsStringList);
        List<String> reportList = reportService.createReport();
        Dao reportDao = new DaoCsvImpl(ReportService.REPORT_FULL_PATH);
        reportDao.writeDataToFile(reportList);
    }
}

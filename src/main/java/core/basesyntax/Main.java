package core.basesyntax;

import dao.TransactionsDao;
import dao.TransactionsDaoImpl;
import db.Storage;
import java.util.List;
import java.util.Map;
import service.FruitTransactionService;
import service.FruitsAmountStrategy;
import service.GenerateReport;
import service.ReadTransactions;
import service.SplitInformation;
import service.WriteReport;
import service.impl.FruitTransactionServiceImpl;
import service.impl.FruitsAmountStrategyImpl;
import service.impl.GenerateReportImpl;
import service.impl.ReadTransactionsImpl;
import service.impl.SplitInformationImpl;
import service.impl.WriteReportImpl;

public class Main {
    public static void main(String[] args) {
        String fromPath = "src/main/recources/ActionPerDay.csv";
        String toPath = "src/main/recources/TheRemainingFruit.csv";
        SplitInformation splitInformation = new SplitInformationImpl();
        FruitTransactionService fruitTransactionService = new FruitTransactionServiceImpl(
                splitInformation);
        ReadTransactions readTransactions = new ReadTransactionsImpl();
        TransactionsDao transactionsDao = new TransactionsDaoImpl(fruitTransactionService,
                readTransactions, fromPath);
        FruitsAmountStrategy fruitsAmountStrategy = new FruitsAmountStrategyImpl();
        GenerateReport generateReport = new GenerateReportImpl(fruitsAmountStrategy);
        WriteReport writeReport = new WriteReportImpl();
        transactionsDao.createTransactionList();
        Map<String, Integer> stringIntegerMap = generateReport.reportMap(Storage.getTransactions());
        List<String> reports = generateReport.createReport(stringIntegerMap);
        writeReport.fruitsReport(reports, toPath);
    }
}

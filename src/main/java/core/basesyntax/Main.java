package core.basesyntax;

import dao.StorageDaoImpl;
import db.Storage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.FruitsAmountStrategy;
import service.GenerateReportLines;
import service.ReadTransactions;
import service.SplitInformation;
import service.WriteReport;
import service.impl.FruitsAmountStrategyImpl;
import service.impl.GenerateReportLinesImpl;
import service.impl.ReadTransactionsImpl;
import service.impl.SplitInformationImpl;
import service.impl.WriteReportImpl;
import strategy.BalanceHandler;
import strategy.FruitsAmountHandler;
import strategy.PurchaseHandler;
import strategy.ReturnHandler;
import strategy.SupplyHandler;

public class Main {
    public static void main(String[] args) {
        String fromPath = "src/main/recources/ActionPerDay.csv";
        ReadTransactions readTransactions = new ReadTransactionsImpl();
        SplitInformation splitInformation = new SplitInformationImpl(readTransactions, fromPath);
        Map<FruitTransaction.Operation, FruitsAmountHandler> amountHandlerMap = new HashMap<>();
        amountHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        amountHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        amountHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        amountHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());
        FruitsAmountStrategy fruitsAmountStrategy = new FruitsAmountStrategyImpl(amountHandlerMap);
        StorageDaoImpl storageDao = new StorageDaoImpl();
        GenerateReportLines generateReport = new GenerateReportLinesImpl(
                storageDao,fruitsAmountStrategy);
        WriteReport writeReport = new WriteReportImpl();
        List<FruitTransaction> a = splitInformation
                .createTransactionList(readTransactions.convertFromFileToList(fromPath));
        generateReport.createReportMap(a);
        List<String> reports = generateReport.createReport(Storage.report);
        String toPath = "src/main/recources/TheRemainingFruit.csv";
        writeReport.fruitsReport(reports, toPath);
    }
}

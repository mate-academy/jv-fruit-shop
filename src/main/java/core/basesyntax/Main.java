package core.basesyntax;

import dao.StorageDao;
import dao.StorageDaoImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.FruitOperationStrategy;
import service.GenerateReportLines;
import service.ReadTransactions;
import service.SplitInformation;
import service.WriteReport;
import service.impl.FruitOperationStrategyImpl;
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
        SplitInformation splitInformation = new SplitInformationImpl();
        StorageDao storageDao = new StorageDaoImpl();
        Map<FruitTransaction.Operation, FruitsAmountHandler> amountHandlerMap = new HashMap<>();
        amountHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler(storageDao));
        amountHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler(storageDao));
        amountHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler(storageDao));
        amountHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler(storageDao));
        FruitOperationStrategy fruitsAmountStrategy =
                new FruitOperationStrategyImpl(storageDao,amountHandlerMap);
        WriteReport writeReport = new WriteReportImpl();
        List<FruitTransaction> allTransactions = splitInformation
                .createTransactionList(readTransactions.convertFromFileToList(fromPath));
        fruitsAmountStrategy.fillStorage(allTransactions);
        GenerateReportLines generateReportLines = new GenerateReportLinesImpl();
        List<String> reports = generateReportLines.createReport(storageDao.getAll());
        String toPath = "src/main/recources/TheRemainingFruit.csv";
        writeReport.fruitsReport(reports, toPath);
    }
}

package mate.academy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mate.academy.model.FruitTransaction;
import mate.academy.service.CreateFileForReport;
import mate.academy.service.CreateReport;
import mate.academy.service.ParseFile;
import mate.academy.service.ReadFile;
import mate.academy.service.TransactionStrategy;
import mate.academy.service.calculation.BalanceCalculator;
import mate.academy.service.calculation.PurchaseCalculator;
import mate.academy.service.calculation.ReturnCalculator;
import mate.academy.service.calculation.SupplyCalculator;
import mate.academy.service.calculation.TransactionCalculation;
import mate.academy.service.impl.CreateFileForReportImpl;
import mate.academy.service.impl.CreateReportImpl;
import mate.academy.service.impl.ParseFileImpl;
import mate.academy.service.impl.ReadFileImpl;
import mate.academy.service.impl.TransactionStrategyImpl;

public class Main {
    private static final String PATH_NAME_DB = "src/main/java/mate/academy/db/database.csv";
    private static final String PATH_NAME_REPORT = "src/main/java/mate/academy/report/report.csv";

    public static void main(String[] args) {
        Map<String, TransactionCalculation> strategyMap = new HashMap<>();
        strategyMap.put(FruitTransaction.Operation.BALANCE.getOperations(),
                new BalanceCalculator());
        strategyMap.put(FruitTransaction.Operation.SUPPLY.getOperations(),
                new SupplyCalculator());
        strategyMap.put(FruitTransaction.Operation.PURCHASE.getOperations(),
                new PurchaseCalculator());
        strategyMap.put(FruitTransaction.Operation.RETURN.getOperations(),
                new ReturnCalculator());

        TransactionStrategy strategy = new TransactionStrategyImpl(strategyMap);
        ReadFile readFile = new ReadFileImpl();
        ParseFile parseFile = new ParseFileImpl();
        List<FruitTransaction> fruitTransactions = parseFile
                .parseFile(readFile.readFromDb(PATH_NAME_DB));

        for (FruitTransaction fruitTransaction : fruitTransactions) {
            strategy.get(fruitTransaction.getOperation()).calculate(fruitTransaction);
        }
        CreateFileForReport createFileForReport = new CreateFileForReportImpl();
        createFileForReport.createFileForReport(PATH_NAME_REPORT);
        CreateReport createReport = new CreateReportImpl();
        createReport.createReport(PATH_NAME_REPORT);
    }
}

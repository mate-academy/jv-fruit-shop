package main;

import db.ShopStorage;
import db.ShopStorageImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.CsvFileWriterService;
import service.ReportGeneratorService;
import service.impl.CsvFileReaderServiceImpl;
import service.impl.CsvFileWriterServiceImpl;
import service.impl.CsvReportGeneratorService;
import strategy.BalanceHandler;
import strategy.FruitShopStrategy;
import strategy.FruitShopStrategyImpl;
import strategy.OperationHandler;
import strategy.PurchaseHandler;
import strategy.ReturnHandler;
import strategy.SupplyHandler;

public class Main {
    public static final String outputFilePath = "src/main/java/output.csv";
    private static final String inputFilePath = "src/main/java/input.csv";

    public static void main(String[] args) {
        ShopStorage fruitStorage = new ShopStorageImpl();

        Map<FruitTransaction.Operation, OperationHandler> fruitShopStrategyMap = new HashMap<>();
        fruitShopStrategyMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        fruitShopStrategyMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        fruitShopStrategyMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        fruitShopStrategyMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());

        CsvFileReaderServiceImpl fileReaderService = new CsvFileReaderServiceImpl();
        List<FruitTransaction> transactions = fileReaderService.readFromFile(inputFilePath);

        FruitShopStrategy operationProcessor =
                new FruitShopStrategyImpl(fruitShopStrategyMap,fruitStorage);
        operationProcessor.processTransactions(transactions);

        ReportGeneratorService reportGenerator = new CsvReportGeneratorService(fruitStorage);
        List<String> report = reportGenerator.generateReport();

        CsvFileWriterService fileWriterService = new CsvFileWriterServiceImpl();
        fileWriterService.writeToFile(report, outputFilePath);

        System.out.println("Report generated successfully.");
    }
}

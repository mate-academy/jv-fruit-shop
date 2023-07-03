package test;

import db.ShopStorage;
import db.ShopStorageImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.ReportGeneratorService;
import service.impl.CsvFileReaderServiceImpl;
import service.impl.CsvReportGeneratorService;
import strategy.BalanceStrategy;
import strategy.OperationHandler;
import strategy.PurchaseStrategy;
import strategy.ReturnStrategy;
import strategy.SupplyStrategy;

public class Main {
    public static final String outputFilePath = "src/main/java/output.csv";
    private static final String inputFilePath = "src/main/java/input.csv";

    public static void main(String[] args) {

        ShopStorage fruitStorage = new ShopStorageImpl();

        Map<FruitTransaction.Operation, OperationHandler> operationStrategies = new HashMap<>();
        operationStrategies.put(FruitTransaction.Operation.BALANCE, new BalanceStrategy());
        operationStrategies.put(FruitTransaction.Operation.SUPPLY, new SupplyStrategy());
        operationStrategies.put(FruitTransaction.Operation.PURCHASE, new PurchaseStrategy());
        operationStrategies.put(FruitTransaction.Operation.RETURN, new ReturnStrategy());

        CsvFileReaderServiceImpl fileReaderService = new CsvFileReaderServiceImpl();
        List<FruitTransaction> transactions = fileReaderService.readFromFile(inputFilePath);

        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = operationStrategies.get(transaction.getOperation());
            handler.handleOperation(transaction, fruitStorage);
        }

        ReportGeneratorService reportGeneratorService = new CsvReportGeneratorService(fruitStorage);
        reportGeneratorService.generateReport(outputFilePath);

        System.out.println("Report generated successfully.");
    }
}

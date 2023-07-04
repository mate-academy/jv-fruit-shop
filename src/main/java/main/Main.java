package main;

import db.ShopStorage;
import db.ShopStorageImpl;
import java.util.List;
import model.FruitTransaction;
import service.CsvFileWriterService;
import service.ReportGeneratorService;
import service.impl.CsvFileReaderServiceImpl;
import service.impl.CsvFileWriterServiceImpl;
import service.impl.CsvReportGeneratorService;
import strategy.FruitShopStrategyImpl;

public class Main {
    public static final String outputFilePath = "src/main/java/output.csv";
    private static final String inputFilePath = "src/main/java/input.csv";

    public static void main(String[] args) {

        ShopStorage fruitStorage = new ShopStorageImpl();

        CsvFileReaderServiceImpl fileReaderService = new CsvFileReaderServiceImpl();
        List<FruitTransaction> transactions = fileReaderService.readFromFile(inputFilePath);

        FruitShopStrategyImpl operationProcessor = new FruitShopStrategyImpl();
        operationProcessor.processTransactions(transactions, fruitStorage);

        ReportGeneratorService reportGenerator = new CsvReportGeneratorService(fruitStorage);
        List<String> report = reportGenerator.generateReport();

        CsvFileWriterService fileWriterService = new CsvFileWriterServiceImpl();
        fileWriterService.writeToFile(report, outputFilePath);

        System.out.println("Report generated successfully.");
    }

}

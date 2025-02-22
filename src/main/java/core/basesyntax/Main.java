package core.basesyntax;

import core.basesyntax.strategy.OperationStrategyProvider;
import dao.CsvFileWriter;
import dao.FileReader;
import dao.FileReaderImpl;
import dao.FileWriterImpl;
import java.util.HashMap;
import service.FruitShopService;
import service.FruitTransactionParser;
import service.InventoryService;
import service.ReportGeneratorService;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Please provide both source and target file paths as arguments.");
            return;
        }

        FileReader fileReader = new FileReaderImpl();
        CsvFileWriter fileWriter = new FileWriterImpl();
        FruitTransactionParser parser = new FruitTransactionParser();

        OperationStrategyProvider strategyProvider = new OperationStrategyProvider();

        ReportGeneratorService reportGeneratorService = new ReportGeneratorService();

        InventoryService inventoryService = new InventoryService(new HashMap<>());
        FruitShopService fruitShopService = new FruitShopService(inventoryService,
                strategyProvider);
        TransactionProcessingService transactionProcessingService =
                new TransactionProcessingService(fileReader, parser, fruitShopService, fileWriter,
                        reportGeneratorService);

        transactionProcessingService.processTransactions(args[0], args[1]);

        System.out.println("Report was successfully written to: " + args[1]);
    }
}

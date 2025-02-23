package core.basesyntax;

import core.basesyntax.dao.CsvFileWriter;
import core.basesyntax.dao.FileReader;
import core.basesyntax.dao.FileReaderImpl;
import core.basesyntax.dao.FileWriterImpl;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.FruitTransactionParser;
import core.basesyntax.service.InventoryService;
import core.basesyntax.service.ReportGeneratorService;
import core.basesyntax.strategy.OperationStrategyProvider;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Please provide both source and target file paths as arguments.");
            return;
        }

        InventoryService inventoryService = new InventoryService(new HashMap<>());
        ReportGeneratorService reportGeneratorService = new ReportGeneratorService();
        FileReader fileReader = new FileReaderImpl();
        CsvFileWriter fileWriter = new FileWriterImpl();
        FruitTransactionParser parser = new FruitTransactionParser();
        OperationStrategyProvider strategyProvider = new OperationStrategyProvider();

        FruitShopService fruitShopService = new FruitShopService(inventoryService,
                strategyProvider);
        TransactionProcessingService transactionProcessingService =
                new TransactionProcessingService(fileReader, parser, fruitShopService, fileWriter,
                        reportGeneratorService);

        List<String> inputReport = fileReader.readFile(args[0]);

        transactionProcessingService.processTransactions(args[0],
                args[1]);

        String resultingReport = reportGeneratorService.generateReport(inventoryService
                .getInventory());

        fileWriter.writeFile(args[1], resultingReport);

        System.out.println("Report was successfully written to: " + args[1]);
    }
}

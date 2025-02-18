package core.basesyntax;

import core.basesyntax.strategy.OperationStrategyProvider;
import dao.CsvFileWriter;
import dao.FileReader;
import dao.FileReaderImpl;
import dao.FileWriterImpl;
import java.util.HashMap;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import service.FruitShopService;
import service.FruitTransactionParser;
import service.InventoryService;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        if (args.length < 2) {
            logger.error("Please provide both source and target file paths as arguments.");
            return;
        }

        final String sourceFilePath = args[0];
        final String targetFilePath = args[1];

        FileReader fileReader = new FileReaderImpl();
        CsvFileWriter fileWriter = new FileWriterImpl();
        FruitTransactionParser parser = new FruitTransactionParser();
        OperationStrategyProvider strategyProvider = new OperationStrategyProvider();
        InventoryService inventoryService = new InventoryService(new HashMap<>());

        FruitShopService fruitShopService = new FruitShopService(inventoryService,
                strategyProvider.getOperationStrategy());

        TransactionProcessingService transactionProcessingService =
                new TransactionProcessingService(fileReader, parser, fruitShopService, fileWriter);

        try {
            transactionProcessingService.processTransactions(sourceFilePath, targetFilePath);
            logger.info(String.format("Report was successfully written to: %s", targetFilePath));
        } catch (Exception e) {
            logger.error("An error occurred while processing transactions.", e);
        }
    }
}

package core.basesyntax;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        if (args.length < 2) {
            logger.error("Please provide both source and target file paths as arguments.");
            return;
        }

        final String sourceFilePath = args[0];
        final String targetFilePath = args[1];

        TransactionProcessingService transactionProcessingService =
                new TransactionProcessingService();
        try {
            transactionProcessingService.processTransactions(sourceFilePath, targetFilePath);
            logger.info(String.format("Report was successfully written to: %s", targetFilePath));
        } catch (Exception e) {
            logger.error("An error occurred while processing transactions.", e);
        }
    }
}

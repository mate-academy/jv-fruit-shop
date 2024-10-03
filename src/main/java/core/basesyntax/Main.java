package core.basesyntax;

import dao.FileReaderImpl;
import dao.FileWriter;
import dao.FileWriterImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import model.OperationType;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import service.FruitShopService;
import strategy.BalanceOperationHandler;
import strategy.OperationHandler;
import strategy.PurchaseOperationHandler;
import strategy.ReturnOperationHandler;
import strategy.SupplyOperationHandler;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        if (args.length < 2) {
            logger.error("Please provide both source and target file paths as arguments.");
            return;
        }

        final String sourceFilePath = args[0];
        final dao.FileReader fileReader = new FileReaderImpl();
        final List<FruitTransaction> transactions = fileReader.readFile(sourceFilePath);

        Map<OperationType, OperationHandler> operationStrategy = new HashMap<>();
        operationStrategy.put(OperationType.BALANCE, new BalanceOperationHandler());
        operationStrategy.put(OperationType.SUPPLY, new SupplyOperationHandler());
        operationStrategy.put(OperationType.PURCHASE, new PurchaseOperationHandler());
        operationStrategy.put(OperationType.RETURN, new ReturnOperationHandler());

        FruitShopService fruitShopService = new FruitShopService(operationStrategy);
        fruitShopService.processTransactions(transactions);

        Map<String, Integer> inventory = fruitShopService.getInventory();

        final String targetFilePath = args[1];
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeFile(targetFilePath, inventory);

        logger.info(String.format("Report was successfully written to: %s", targetFilePath));
    }
}

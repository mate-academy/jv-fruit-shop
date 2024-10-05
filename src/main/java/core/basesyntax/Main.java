package core.basesyntax;

import core.basesyntax.dao.FileReader;
import core.basesyntax.dao.FileReaderImpl;
import core.basesyntax.dao.FileWriter;
import core.basesyntax.dao.FileWriterImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.OperationType;
import core.basesyntax.service.ConfigService;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String CONFIG_FILE_PATH = "config.properties";

    public static void main(String[] args) {
        ConfigService configService = new ConfigService(CONFIG_FILE_PATH);
        FileReader fileReader = new FileReaderImpl();

        String sourcePath = configService.getSourcePath();
        List<String> lines = fileReader.readFile(sourcePath);

        Map<OperationType, OperationHandler> operationStrategy = new HashMap<>();
        operationStrategy.put(OperationType.BALANCE, new BalanceOperationHandler());
        operationStrategy.put(OperationType.SUPPLY, new SupplyOperationHandler());
        operationStrategy.put(OperationType.PURCHASE, new PurchaseOperationHandler());
        operationStrategy.put(OperationType.RETURN, new ReturnOperationHandler());

        TransactionParser transactionParser = new TransactionParser();
        List<FruitTransaction> transactions = transactionParser.parseTransactions(lines);
        FruitShopService fruitShopService = new FruitShopService(operationStrategy);
        fruitShopService.processTransactions(transactions);

        String targetPath = configService.getTargetPath();
        Map<String, Integer> inventory = fruitShopService.getInventory();
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeFile(targetPath, inventory);
        System.out.println("Report was successfully written in: " + targetPath);
    }
}

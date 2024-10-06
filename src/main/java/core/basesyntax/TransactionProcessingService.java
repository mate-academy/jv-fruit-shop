package core.basesyntax;

import dao.FileReader;
import dao.FileReaderImpl;
import dao.FileWriter;
import dao.FileWriterImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import model.OperationType;
import service.FruitShopService;
import service.FruitTransactionParser;
import strategy.BalanceOperationHandler;
import strategy.OperationHandler;
import strategy.PurchaseOperationHandler;
import strategy.ReturnOperationHandler;
import strategy.SupplyOperationHandler;

public class TransactionProcessingService {
    private final FileReader fileReader;
    private final FruitTransactionParser parser;
    private final FruitShopService fruitShopService;
    private final FileWriter fileWriter;

    public TransactionProcessingService() {
        this.fileReader = new FileReaderImpl();
        this.parser = new FruitTransactionParser();

        Map<OperationType, OperationHandler> operationStrategy = new HashMap<>();
        operationStrategy.put(OperationType.BALANCE, new BalanceOperationHandler());
        operationStrategy.put(OperationType.SUPPLY, new SupplyOperationHandler());
        operationStrategy.put(OperationType.PURCHASE, new PurchaseOperationHandler());
        operationStrategy.put(OperationType.RETURN, new ReturnOperationHandler());

        this.fruitShopService = new FruitShopService(operationStrategy);
        this.fileWriter = new FileWriterImpl();
    }

    public void processTransactions(String sourceFilePath, String targetFilePath) {
        List<String> lines = fileReader.readFile(sourceFilePath);
        List<FruitTransaction> transactions = parser.parse(lines);
        fruitShopService.processTransactions(transactions);
        Map<String, Integer> inventory = fruitShopService.getInventory();
        fileWriter.writeFile(targetFilePath, inventory);
    }
}

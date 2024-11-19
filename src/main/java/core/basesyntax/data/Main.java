package core.basesyntax.data;

import core.basesyntax.data.dao.FileReader;
import core.basesyntax.data.dao.FileReaderImpl;
import core.basesyntax.data.dao.FileWriter;
import core.basesyntax.data.dao.FileWriterImpl;
import core.basesyntax.data.model.FruitTransaction;
import core.basesyntax.data.model.OperationType;
import core.basesyntax.data.servise.FruitShopService;
import core.basesyntax.data.strategy.BalanceOperationHandler;
import core.basesyntax.data.strategy.OperationHandler;
import core.basesyntax.data.strategy.PurchaseOperationHandler;
import core.basesyntax.data.strategy.ReturnOperationHandler;
import core.basesyntax.data.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String SOURCE_PATH_NAME = "src/data/fruit_shop_transactions";
    private static final String TARGET_PATH_NAME = "src/reports/report";

    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        Map<OperationType, OperationHandler> operationStrategy = new HashMap<>();
        operationStrategy.put(OperationType.BALANCE, new BalanceOperationHandler());
        operationStrategy.put(OperationType.SUPPLY, new SupplyOperationHandler());
        operationStrategy.put(OperationType.PURCHASE, new PurchaseOperationHandler());
        operationStrategy.put(OperationType.RETURN, new ReturnOperationHandler());

        List<FruitTransaction> transactions = fileReader.readFile(SOURCE_PATH_NAME);

        FruitShopService fruitShopService = new FruitShopService(operationStrategy);
        fruitShopService.processTransactions(transactions);

        Map<String, Integer> inventory = fruitShopService.getInventory();
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeFile(TARGET_PATH_NAME, inventory);
        System.out.println("Report was successfully written in:  " + TARGET_PATH_NAME);
    }
}

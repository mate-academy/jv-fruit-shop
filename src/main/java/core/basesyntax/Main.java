package core.basesyntax;

import core.basesyntax.dao.FileReader;
import core.basesyntax.dao.FileReaderImpl;
import core.basesyntax.dao.FileWriter;
import core.basesyntax.dao.FileWriterImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.OperationType;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String SOURCE_PATH_NAME = "src/data/fruit_shop_transactions";
    private static final String TARGET_PATH_NAME = "src/reports/report";

    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        List<FruitTransaction> transactions;
        transactions = fileReader.readFile(SOURCE_PATH_NAME);

        Map<OperationType, OperationHandler> operationStrategy = new HashMap<>();
        operationStrategy.put(OperationType.BALANCE, new BalanceOperationHandler());
        operationStrategy.put(OperationType.SUPPLY, new SupplyOperationHandler());
        operationStrategy.put(OperationType.PURCHASE, new PurchaseOperationHandler());
        operationStrategy.put(OperationType.RETURN, new ReturnOperationHandler());

        FruitShopService fruitShopService = new FruitShopService(operationStrategy);
        fruitShopService.processTransactions(transactions);

        Map<String, Integer> inventory = fruitShopService.getInventory();
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeFile(TARGET_PATH_NAME, inventory);
        System.out.println("Report was successfully written in: report.csv");
    }
}

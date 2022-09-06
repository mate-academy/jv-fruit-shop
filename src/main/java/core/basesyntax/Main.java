package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.FruitService;
import core.basesyntax.services.FruitServiceImpl;
import core.basesyntax.services.ReadService;
import core.basesyntax.services.WriteService;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_NAME = "src/main/java/core/basesyntax/resources/data.txt";
    private static final String OUTPUT_FILE_NAME = "src/main/java/core/basesyntax/resources/report.txt";

    public static void main(String[] args) {
        Map<String, OperationHandler> map = new HashMap<>();
        initializeMap(map);
        OperationStrategy strategy = new OperationStrategy(map);
        FruitService fruitService = new FruitServiceImpl();
        WriteService writeService = new WriteService();

        List<String> dataList = new ReadService().readFromFile(INPUT_FILE_NAME);
        List<FruitTransaction> fruitTransactionList = fruitService.getTransaction(dataList);
        for (FruitTransaction fruitTransaction: fruitTransactionList) {
            OperationHandler handler = strategy.getByOperation(fruitTransaction.getOperation());
            handler.apply(fruitTransaction);
        }
        String report = fruitService.createReport();
        writeService.writeToFile(OUTPUT_FILE_NAME, report);
    }

    private static void initializeMap(Map<String, OperationHandler> map) {
        map.put("b", new BalanceOperationHandler());
        map.put("s", new SupplyOperationHandler());
        map.put("p", new PurchaseOperationHandler());
        map.put("r", new ReturnOperationHandler());
    }
}

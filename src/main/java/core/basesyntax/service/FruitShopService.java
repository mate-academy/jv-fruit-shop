package core.basesyntax.service;

import core.basesyntax.db.FruitShopInventory;
import core.basesyntax.strategy.Balance;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.Purchase;
import core.basesyntax.strategy.Return;
import core.basesyntax.strategy.Supply;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitShopService {
    private final FileReaderImpl fileProcessor = new FileReaderImpl();
    private final ReportWriter reportWriter = new ReportWriter();
    private final FruitShopInventory inventory = new FruitShopInventory();
    private final Map<String, OperationStrategy> operationsMap = new HashMap<>();

    public FruitShopService() {
        operationsMap.put("b", new Balance());
        operationsMap.put("s", new Supply());
        operationsMap.put("p", new Purchase());
        operationsMap.put("r", new Return());
    }

    public void processFile(String inputFile) throws IOException {
        List<String[]> data = FileReaderImpl.processFile(inputFile);

        for (String[] row : data) {
            String operation = row[0].trim();
            String fruit = row[1].trim();
            int quantity = Integer.parseInt(row[2].trim());

            OperationStrategy operationStrategy = operationsMap.get(operation);

            if (operationStrategy != null) {
                inventory.applyOperation(operationStrategy, fruit, quantity);
            } else {
                throw new RuntimeException("Unknown operation: " + operation);
            }
        }
    }
}

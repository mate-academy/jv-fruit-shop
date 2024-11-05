package core.basesyntax.service;

import core.basesyntax.db.StockDao;
import core.basesyntax.db.StockDaoStorageImpl;
import core.basesyntax.service.operations.Balance;
import core.basesyntax.service.operations.Operation;
import core.basesyntax.service.operations.Purchase;
import core.basesyntax.service.operations.Return;
import core.basesyntax.service.operations.Supply;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class InventoryFromCsv implements Inventory {
    private static final String FILE_NAME = "inventory.csv";
    private final StockDao stockDao = new StockDaoStorageImpl();

    @Override
    public void synchronizeWithTheStorage() {
        Map<String, Operation> operationMap = new HashMap<>();
        operationMap.put("b", new Balance());
        operationMap.put("s", new Supply());
        operationMap.put("r", new Return());
        operationMap.put("p", new Purchase());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationMap);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            String line = reader.readLine();
            while (line != null) {
                String[] splitDataFromCurrentLine = line.split(",");
                operationStrategy.getOperation(splitDataFromCurrentLine[0])
                        .update(splitDataFromCurrentLine[1],
                                Integer.parseInt(splitDataFromCurrentLine[2]));
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

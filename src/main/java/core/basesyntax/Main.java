package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ProcessService;
import core.basesyntax.service.ReadService;
import core.basesyntax.service.WriteService;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ProcessServiceImpl;
import core.basesyntax.service.impl.ReadServiceImpl;
import core.basesyntax.service.impl.WriteServiceImpl;
import core.basesyntax.strategy.FruitStrategy;
import core.basesyntax.strategy.FruitStrategyImpl;
import core.basesyntax.strategy.activities.ActivitiesHandler;
import core.basesyntax.strategy.activities.BalanceActivitiesHandler;
import core.basesyntax.strategy.activities.PurchaseActivitiesHandler;
import core.basesyntax.strategy.activities.ReturnActivitiesHandler;
import core.basesyntax.strategy.activities.SupplyActivitiesHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final String PATH_FROM_FILE = "src/main/file.csv";
    private static final String PATH_TO_FILE = "src/main/toFile.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, ActivitiesHandler> activitiesHandlerMap = new HashMap<>();
        activitiesHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceActivitiesHandler());
        activitiesHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseActivitiesHandler());
        activitiesHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyActivitiesHandler());
        activitiesHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnActivitiesHandler());

        FruitStrategy fruitStrategy = new FruitStrategyImpl(activitiesHandlerMap);

        ReadService readService = new ReadServiceImpl();
        List<String> strings = readService.readFromFile(PATH_FROM_FILE);

        ProcessService processService = new ProcessServiceImpl();
        List<FruitTransaction> process = processService.modelSetUp(strings);

        FruitService fruitService = new FruitServiceImpl(fruitStrategy);
        fruitService.action(process);

        WriteService writeService = new WriteServiceImpl();
        writeService.writeFile(Storage.fruitStorage, PATH_TO_FILE);
    }
}

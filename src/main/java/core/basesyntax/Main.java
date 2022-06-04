package core.basesyntax;

import core.basesyntax.model.Operation;
import core.basesyntax.model.Record;
import core.basesyntax.service.ProcessorService;
import core.basesyntax.service.ProcessorServiceImpl;
import core.basesyntax.service.ReaderServiceImpl;
import core.basesyntax.service.WriterServiceImpl;
import core.basesyntax.strategy.ActionStrategy;
import core.basesyntax.strategy.ActionStrategyImpl;
import core.basesyntax.strategy.action.ActionHandler;
import core.basesyntax.strategy.action.BalanceHandler;
import core.basesyntax.strategy.action.PurchaseHandler;
import core.basesyntax.strategy.action.ReturnHandler;
import core.basesyntax.strategy.action.SupplyHandler;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class Main {
    private static final String INPUT_FILE_NAME = "src/main/resources/fruit-log.csv";
    private static final String OUTPUT_FILE_NAME = "src/main/resources/fruit-stat.csv";

    public static void main(String[] args) {
        Map<Operation, ActionHandler> actionHandlerMap = new HashMap<>();
        Main.getActionHandlerMap(actionHandlerMap);

        Queue<Record> records;
        ActionStrategy actionStrategy = new ActionStrategyImpl(actionHandlerMap);

        records = new ReaderServiceImpl().read(INPUT_FILE_NAME);
        new ProcessorServiceImpl(actionStrategy).process(records);
        new WriterServiceImpl().write(OUTPUT_FILE_NAME);
    }

    private static void getActionHandlerMap(Map<Operation, ActionHandler> map) {
        map.put(Operation.BALANCE, new BalanceHandler());
        map.put(Operation.SUPPLY, new SupplyHandler());
        map.put(Operation.PURCHASE, new PurchaseHandler());
        map.put(Operation.RETURN, new ReturnHandler());
    }
}

package core.basesyntax;

import core.basesyntax.dao.FruitStoreDao;
import core.basesyntax.dao.FruitStoreDaoImpl;
import core.basesyntax.model.Action;
import core.basesyntax.service.ActionStrategy;
import core.basesyntax.service.ActionStrategyImpl;
import core.basesyntax.service.FruitStoreService;
import core.basesyntax.service.FruitStoreServiceImpl;
import core.basesyntax.service.handler.ActionHandler;
import core.basesyntax.service.handler.BalanceActionHandler;
import core.basesyntax.service.handler.PurchaseActionHandler;
import core.basesyntax.service.handler.ReturnActionHandler;
import core.basesyntax.service.handler.SupplyActionHandler;
import core.basesyntax.service.reader.ReaderService;
import core.basesyntax.service.reader.ReaderServiceImpl;
import core.basesyntax.service.writer.WriterService;
import core.basesyntax.service.writer.WriterServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitStoreApplication {
    private static final String INPUT_DATA_FILE = "src/main/resources/inputData.csv";
    private static final String OUTPUT_DATA_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<String, ActionHandler> actionHandlerMap = new HashMap<>();
        actionHandlerMap.put(Action.BALANCE.getActionCode(), new BalanceActionHandler());
        actionHandlerMap.put(Action.SUPPLY.getActionCode(), new SupplyActionHandler());
        actionHandlerMap.put(Action.PURCHASE.getActionCode(), new PurchaseActionHandler());
        actionHandlerMap.put(Action.RETURN.getActionCode(), new ReturnActionHandler());
        ActionStrategy actionStrategy = new ActionStrategyImpl(actionHandlerMap);
        FruitStoreDao fruitStoreDao = new FruitStoreDaoImpl();
        FruitStoreService fruitStoreService =
                new FruitStoreServiceImpl(fruitStoreDao, actionStrategy);
        ReaderService readerService = new ReaderServiceImpl();
        WriterService writerService = new WriterServiceImpl();
        List<String> data = readerService.readFromFile(INPUT_DATA_FILE);
        fruitStoreService.addDataToStorage(data);
        String report = fruitStoreService.createNewReport();
        writerService.writeReportToFile(report, OUTPUT_DATA_FILE);
    }
}

package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.ActionStrategy;
import core.basesyntax.services.ProcessStoreService;
import core.basesyntax.services.ReadFileService;
import core.basesyntax.services.WriteFileService;
import core.basesyntax.services.actions.ActionHandler;
import core.basesyntax.services.actions.BalanceActionHandler;
import core.basesyntax.services.actions.PurchaseActionHandler;
import core.basesyntax.services.actions.ReturnActionHandler;
import core.basesyntax.services.actions.SupplyActionHandler;
import core.basesyntax.services.impl.ActionStrategyImpl;
import core.basesyntax.services.impl.CreateTaskServiceImpl;
import core.basesyntax.services.impl.ParseCsvServiceImpl;
import core.basesyntax.services.impl.ProcessStoreServiceImpl;
import core.basesyntax.services.impl.ReadFileServiceImpl;
import core.basesyntax.services.impl.WriteFileServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //Create strategy of actions
        Map<FruitTransaction.ActionType, ActionHandler> actionHandlerMap = new HashMap<>();
        actionHandlerMap.put(FruitTransaction.ActionType.BALANCE, new BalanceActionHandler());
        actionHandlerMap.put(FruitTransaction.ActionType.SUPPLY, new SupplyActionHandler());
        actionHandlerMap.put(FruitTransaction.ActionType.PURCHASE, new PurchaseActionHandler());
        actionHandlerMap.put(FruitTransaction.ActionType.RETURN, new ReturnActionHandler());
        ActionStrategy actionStrategy = new ActionStrategyImpl(actionHandlerMap);
        ReadFileService readService = new ReadFileServiceImpl();
        String[] readFiles = readService.read("resources/inputFile.csv");
        List<String[]> parseData = new ParseCsvServiceImpl().parse(readFiles);
        //Create list<Task> - all actions from file
        List<FruitTransaction> fruitTransactions = new CreateTaskServiceImpl()
                .createTasks(parseData);
        //create database
        Storage fruitDB = new Storage();
        //Create main process of handle tasks
        ProcessStoreService handleTasks = new ProcessStoreServiceImpl(fruitDB, actionStrategy);
        //handle tasks
        handleTasks.processAction(fruitTransactions);
        //write service created
        WriteFileService writeToFileService = new WriteFileServiceImpl();
        //write to file
        writeToFileService.writeToFile(fruitDB, "resources/resultData.txt");
        //additional print
        Map<String, Integer> storage = fruitDB.getStorageFruits();
        System.out.println(storage.toString());
    }
}

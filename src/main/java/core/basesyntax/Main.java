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
        //create database
        Storage fruitDB = new Storage();
        //Create strategy of actions
        Map<FruitTransaction.ActionType, ActionHandler> actionHandlerMap = new HashMap<>();
        actionHandlerMap.put(FruitTransaction.ActionType.BALANCE,
                new BalanceActionHandler(fruitDB));
        actionHandlerMap.put(FruitTransaction.ActionType.SUPPLY,
                new SupplyActionHandler(fruitDB));
        actionHandlerMap.put(FruitTransaction.ActionType.PURCHASE,
                new PurchaseActionHandler(fruitDB));
        actionHandlerMap.put(FruitTransaction.ActionType.RETURN,
                new ReturnActionHandler(fruitDB));
        ActionStrategy actionStrategy = new ActionStrategyImpl(actionHandlerMap);
        //read file
        String[] readFiles = new ReadFileServiceImpl().read("resources/inputFile.csv");
        //parse data from file
        List<String[]> parseData = new ParseCsvServiceImpl().parse(readFiles);
        //Create list<Task> - all actions from file
        List<FruitTransaction> fruitTransactions = new CreateTaskServiceImpl()
                .createTasks(parseData);
        //Create main process of handle tasks
        ProcessStoreService handleTasks = new ProcessStoreServiceImpl(fruitDB, actionStrategy);
        //handle tasks
        handleTasks.processAction(fruitTransactions);
        //write service created
        WriteFileService writeToFileService = new WriteFileServiceImpl(fruitDB);
        //write to file
        writeToFileService.writeToFile("resources/resultData.txt");
        //additional print
        Map<String, Integer> storage = fruitDB.getStorageFruits();
        System.out.println(storage.toString());
    }
}

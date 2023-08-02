package core.basesyntax;

import core.basesyntax.dao.StoreDao;
import core.basesyntax.dao.StoreDaoImpl;
import core.basesyntax.model.Task;
import core.basesyntax.services.ActionStrategy;
import core.basesyntax.services.ProcessStoreService;
import core.basesyntax.services.WriteFileService;
import core.basesyntax.services.actions.ActionHandler;
import core.basesyntax.services.actions.BalanceActionHandler;
import core.basesyntax.services.actions.PurchaseActionHandler;
import core.basesyntax.services.actions.ReturnActionHandler;
import core.basesyntax.services.actions.SupplyActionHandler;
import core.basesyntax.services.impl.ActionStrategyImpl;
import core.basesyntax.services.impl.CreateTaskServiceImpl;
import core.basesyntax.services.impl.ProcessStoreServiceImpl;
import core.basesyntax.services.impl.ReadFileServiceImpl;
import core.basesyntax.services.impl.WriteFileServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //Create strategy of actions
        Map<Task.ActionType, ActionHandler> actionHandlerMap = new HashMap<>();
        actionHandlerMap.put(Task.ActionType.BALANCE, new BalanceActionHandler());
        actionHandlerMap.put(Task.ActionType.SUPPLY, new SupplyActionHandler());
        actionHandlerMap.put(Task.ActionType.PURCHASE, new PurchaseActionHandler());
        actionHandlerMap.put(Task.ActionType.RETURN, new ReturnActionHandler());
        ActionStrategy actionStrategy = new ActionStrategyImpl(actionHandlerMap);
        //Create list<Task> - all actions from file
        List<Task> tasks = new CreateTaskServiceImpl()
                .createTasks(new ReadFileServiceImpl(), "resources/inputFile.csv");
        //create database
        StoreDao dao = new StoreDaoImpl();
        //Create main process of handle tasks
        ProcessStoreService handleTasks = new ProcessStoreServiceImpl(dao, actionStrategy);
        //handle tasks
        handleTasks.processAction(tasks);
        //write service created
        WriteFileService writeToFileService = new WriteFileServiceImpl();
        //write to file
        writeToFileService.writeToFile(dao, "resources/resultData.txt");
        //additional print
        Map<String, Integer> storage = dao.getStorage();
        System.out.println(storage.toString());
    }
}

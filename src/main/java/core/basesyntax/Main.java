package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FileCsvService;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.impl.FileCsvServiceImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.FruitTransactionServiceImpl;
import core.basesyntax.service.strategy.handler.ActivityHandler;
import core.basesyntax.service.strategy.handler.BalanceActivityHandler;
import core.basesyntax.service.strategy.handler.PurchaseActivityHandler;
import core.basesyntax.service.strategy.handler.ReturnActivityHandler;
import core.basesyntax.service.strategy.handler.SupplyActivityHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        FileCsvService fileService = new FileCsvServiceImpl();
        FruitTransactionService fruitTransactionService = new FruitTransactionServiceImpl();

        Map<Operation, ActivityHandler> activityHandlerMap = new HashMap<>();
        activityHandlerMap.put(Operation.BALANCE, new BalanceActivityHandler(fruitDao));
        activityHandlerMap.put(Operation.SUPPLY, new SupplyActivityHandler(fruitDao));
        activityHandlerMap.put(Operation.PURCHASE, new PurchaseActivityHandler(fruitDao));
        activityHandlerMap.put(Operation.RETURN, new ReturnActivityHandler(fruitDao));

        FruitService fruitService = new FruitServiceImpl(activityHandlerMap);

        List<String> activities = fileService
                .readFile("src/main/resources/activities.csv"); // read data from file
        List<FruitTransaction> allTransactions = fruitTransactionService
                .getFruitTransactionsFromData(activities); // convert data from file to java objects
        fruitService.processTransactions(allTransactions); // proccess java objects
        String report = fruitService.createReport(); // create report
        fileService.writeToFile("src/main/resources/report.csv", report); // write report to file
    }
}

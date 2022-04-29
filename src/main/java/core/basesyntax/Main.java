package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.files.FileReaderImpl;
import core.basesyntax.files.FileWriterImpl;
import core.basesyntax.operation.Operation;
import core.basesyntax.service.ReportServiceImpl;
import core.basesyntax.service.activity.BalanceHandler;
import core.basesyntax.service.activity.OperationHandler;
import core.basesyntax.service.activity.PurchaseHandler;
import core.basesyntax.service.activity.ReturnHandler;
import core.basesyntax.service.activity.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String fromFileName = "load.csv";

        Map<Operation, OperationHandler> activityServiceMap = new HashMap<>();
        FruitDao fruitDao = new FruitDaoImpl();
        activityServiceMap.put(Operation.BALANCE, new BalanceHandler(fruitDao));
        activityServiceMap.put(Operation.SUPPLY, new SupplyHandler(fruitDao));
        activityServiceMap.put(Operation.PURCHASE, new PurchaseHandler(fruitDao));
        activityServiceMap.put(Operation.RETURN, new ReturnHandler(fruitDao));

        List<String> dataFromFile = new FileReaderImpl().readFromFile(fromFileName);

        activityServiceMap.get(Operation.BALANCE).activity(dataFromFile);
        activityServiceMap.get(Operation.SUPPLY).activity(dataFromFile);
        activityServiceMap.get(Operation.PURCHASE).activity(dataFromFile);
        activityServiceMap.get(Operation.RETURN).activity(dataFromFile);

        String toFileName = "output.csv";
        new FileWriterImpl()
                .writeToFile(new ReportServiceImpl(new FruitDaoImpl()).getReport(), toFileName);

        System.out.println(Storage.fruits);
    }
}

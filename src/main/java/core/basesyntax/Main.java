package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.files.FileReaderImpl;
import core.basesyntax.files.FileWriterImpl;
import core.basesyntax.operation.Operation;
import core.basesyntax.service.ReportServiceImpl;
import core.basesyntax.service.activity.OperationHandler;
import core.basesyntax.service.activity.BalanceOperationHandler;
import core.basesyntax.service.activity.PurchaseOperationHandler;
import core.basesyntax.service.activity.ReturnOperationHandler;
import core.basesyntax.service.activity.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String fromFileName = "load.csv";
        String toFileName = "output.csv";
        Map<Operation, OperationHandler> activityServiceMap = new HashMap<>();
        FruitDao fruitDao = new FruitDaoImpl();
        activityServiceMap.put(Operation.BALANCE, new BalanceOperationHandler(fruitDao));
        activityServiceMap.put(Operation.SUPPLY, new SupplyOperationHandler(fruitDao));
        activityServiceMap.put(Operation.PURCHASE, new PurchaseOperationHandler(fruitDao));
        activityServiceMap.put(Operation.RETURN, new ReturnOperationHandler(fruitDao));

        List<String> dataFromFile = new FileReaderImpl().readFromFile(fromFileName);

        activityServiceMap.get(Operation.BALANCE).activity(dataFromFile);
        activityServiceMap.get(Operation.SUPPLY).activity(dataFromFile);
        activityServiceMap.get(Operation.PURCHASE).activity(dataFromFile);
        activityServiceMap.get(Operation.RETURN).activity(dataFromFile);

        new FileWriterImpl().writeToFile(new ReportServiceImpl(new FruitDaoImpl()).getReport(), toFileName);

        System.out.println(Storage.fruits);
    }
}

package myfirstproject;

import java.util.HashMap;
import java.util.Map;
import myfirstproject.dao.FruitDao;
import myfirstproject.dao.impl.FruitDaoImpl;
import myfirstproject.model.Operation;
import myfirstproject.service.ReadFile;
import myfirstproject.service.WriteFile;
import myfirstproject.service.impl.ReadFileImpl;
import myfirstproject.service.impl.WriteFileImpl;
import myfirstproject.strategy.BalanceOperation;
import myfirstproject.strategy.OperationHandler;
import myfirstproject.strategy.PurchaseOperation;
import myfirstproject.strategy.ReturnOperation;
import myfirstproject.strategy.SeparationOfOperations;
import myfirstproject.strategy.SupplyOperation;

public class Application {
    private static final String PATH_TO_DB = "src/main/resources/sourceFile.csv";
    private static final String PATH_TO_RESULT = "src/main/resources/resultFile.csv";

    public static void main(String[] args) {
        final FruitDao fruitDao = new FruitDaoImpl();
        final ReadFile reader = new ReadFileImpl();
        final WriteFile writer = new WriteFileImpl();
        final SeparationOfOperations separation = new SeparationOfOperations();
        Map<String, OperationHandler> operation = new HashMap<>();
        operation.put(Operation.BALANCE.getOperation(), new BalanceOperation());
        operation.put(Operation.SUPPLY.getOperation(), new SupplyOperation());
        operation.put(Operation.PURCHASE.getOperation(), new PurchaseOperation());
        operation.put(Operation.RETURN.getOperation(), new ReturnOperation());
        reader.readFile(PATH_TO_DB);
        separation.toDoEachOperation(operation);
        writer.writeToFile(PATH_TO_RESULT, fruitDao.getAll());
    }
}

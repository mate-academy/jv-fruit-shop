package myfirstproject;

import java.util.HashMap;
import java.util.Map;
import myfirstproject.dao.DataBaseDao;
import myfirstproject.dao.impl.DataBaseDaoImpl;
import myfirstproject.db.TemporalListOfOperations;
import myfirstproject.model.Fruit;
import myfirstproject.model.Operation;
import myfirstproject.service.ReadFile;
import myfirstproject.service.WriteFile;
import myfirstproject.service.impl.ReadFileImpl;
import myfirstproject.service.impl.WriteFileImpl;
import myfirstproject.strategy.BalanceOperation;
import myfirstproject.strategy.OperationHandler;
import myfirstproject.strategy.PurchaseOperation;
import myfirstproject.strategy.ReturnOperation;
import myfirstproject.strategy.SupplyOperation;

public class Application {
    private static final String PATH_TO_DB = "src/main/resources/sourceFile.csv";
    private static final String PATH_TO_RESULT = "src/main/resources/resultFile.csv";

    public static void main(String[] args) {
        final DataBaseDao dataBaseDao = new DataBaseDaoImpl();
        final ReadFile reader = new ReadFileImpl();
        final WriteFile writer = new WriteFileImpl();
        Map<String, OperationHandler> operation = new HashMap<>();
        operation.put(Operation.BALANCE.getOperation(), new BalanceOperation());
        operation.put(Operation.SUPPLY.getOperation(), new SupplyOperation());
        operation.put(Operation.PURCHASE.getOperation(), new PurchaseOperation());
        operation.put(Operation.RETURN.getOperation(), new ReturnOperation());

        reader.readFile(PATH_TO_DB);

        for (String [] s : TemporalListOfOperations.temporalData) {
            if (s[0].length() == 1) {
                Fruit fruit = new Fruit(s[1]);
                int value = Integer.parseInt(s[2]);
                operation.get(s[0]).changeValue(fruit, value);
            }
        }

        writer.writeToFile(PATH_TO_RESULT, dataBaseDao.getAllRecords());
    }
}

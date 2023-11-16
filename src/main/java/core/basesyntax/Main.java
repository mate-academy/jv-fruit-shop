package core.basesyntax;

import core.basesyntax.dao.impl.TransactionDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataService;
import core.basesyntax.service.WriteDataToFileService;
import core.basesyntax.service.impl.DataServiceImpl;
import core.basesyntax.service.impl.ReadDataFromFileServiceImpl;
import core.basesyntax.service.impl.TransactionServiceImpl;
import core.basesyntax.service.impl.WriteDataToFileServiceImpl;
import core.basesyntax.service.strategy.impl.FruitResolverImpl;
import core.basesyntax.service.strategy.impl.OperationResolverImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String PATH_TRANSACTIONS = "src/main/resources/balanceFruits.csv";
    private static final String PATH_REPORT = "src/main/resources/report.csv";

    public static void main(String[] args) {

        Map<String, Operation> operationMap = new HashMap<>();
        operationMap.put("b", Operation.BALANCE);
        operationMap.put("s", Operation.SUPPLY);
        operationMap.put("p", Operation.PURCHASE);
        operationMap.put("r", Operation.RETURN);
        Map<String, Fruit> fruitMap = new HashMap<>();
        fruitMap.put("banana", Fruit.BANANA);
        fruitMap.put("apple", Fruit.APPLE);

        ReadDataFromFileServiceImpl readDataFromFile = new ReadDataFromFileServiceImpl();
        List<String> listDataFromFile = readDataFromFile.readFromFile(PATH_TRANSACTIONS);

        DataService dataService = new DataServiceImpl(new TransactionDaoImpl(),
                new TransactionServiceImpl(
                        new TransactionDaoImpl(),
                        new OperationResolverImpl(operationMap),
                        new FruitResolverImpl(fruitMap)));
        String report = dataService.processingTransaction(listDataFromFile);

        WriteDataToFileService writeDataToFile = new WriteDataToFileServiceImpl();
        writeDataToFile.writeData(PATH_REPORT, report);

    }
}

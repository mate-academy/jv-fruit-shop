package core.basesyntax;

import core.basesyntax.dao.IStorageDao;
import core.basesyntax.dao.WorkWithFile;
import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.IStorageService;
import core.basesyntax.service.StorageService;
import core.basesyntax.strategy.FruitStrategy;
import core.basesyntax.strategy.IFruitStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static void main(String[] args) {
        Map<String, FruitTransaction.Operation> listOperations = new HashMap<>();
        listOperations.put("b", FruitTransaction.Operation.BALANCE);
        listOperations.put("s", FruitTransaction.Operation.SUPPLY);
        listOperations.put("p", FruitTransaction.Operation.PURCHASE);
        listOperations.put("r", FruitTransaction.Operation.RETURN);
        IFruitStrategy fruitStrategy = new FruitStrategy(listOperations);
        IStorageService storageService = new StorageService();
        IStorageDao storageDao = new WorkWithFile();
        FruitTransaction fruitTransaction;
        List<String> daysOperations = storageDao.getData();
        String[] tmp;
        for (int i = 1; i < daysOperations.size(); i++) {
            tmp = daysOperations.get(i).split(",");
            fruitTransaction = fruitStrategy.chooseOperation(tmp[0], tmp[1], Integer.parseInt(tmp[2]));
            storageService.operation(fruitTransaction);
        }
    }
}

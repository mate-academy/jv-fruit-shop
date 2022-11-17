package core.basesyntax;

import core.basesyntax.dao.IStorageDao;
import core.basesyntax.dao.WorkWithFile;
import core.basesyntax.service.IStorageService;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.operations.Balance;
import core.basesyntax.service.operations.IOperation;
import core.basesyntax.service.operations.Purchase;
import core.basesyntax.service.operations.Return;
import core.basesyntax.service.operations.Supply;
import core.basesyntax.strategy.FruitStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static void main(String[] args) {
        Map<String, IOperation> listOperations = new HashMap<>();
        listOperations.put("b", new Balance());
        listOperations.put("s", new Supply());
        listOperations.put("p", new Purchase());
        listOperations.put("r", new Return());

        IStorageService storageService = new StorageService(new FruitStrategy(listOperations));

        IStorageDao storageDao = new WorkWithFile();
        List<String> daysOperations = storageDao.getData();
        for (int i = 1; i < daysOperations.size(); i++) {
            String[] tmp = daysOperations.get(i).split(",");
            storageService.operation(tmp[0], tmp[1], Integer.parseInt(tmp[2]));
        }
        storageDao.putData();
    }
}

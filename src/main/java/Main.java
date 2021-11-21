import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.handler.WorkWithFruits;
import core.basesyntax.service.handler.impl.FruitBalance;
import core.basesyntax.service.handler.impl.FruitPurchase;
import core.basesyntax.service.handler.impl.FruitReturn;
import core.basesyntax.service.handler.impl.FruitSupply;
import core.basesyntax.service.impl.StorageServiceImpl;
import core.basesyntax.strategy.FruitWorkStrategy;
import core.basesyntax.strategy.FruitWorkStrategyImp;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String separator = File.separator;
        String pathPattern = "src" + separator +"main" + separator + "resources" + separator;
        String validData = pathPattern + "validData.csv";
        String invalidData = pathPattern + "invalidData.csv";
        String emptyData = pathPattern + "emptyData.csv";
        FruitDao fruitDao = new FruitDaoImpl();
        Map<String, WorkWithFruits> workWithFruitsMap = new HashMap<>();
        workWithFruitsMap.put("b", new FruitBalance());
        workWithFruitsMap.put("s", new FruitSupply());
        workWithFruitsMap.put("p", new FruitPurchase());
        workWithFruitsMap.put("r", new FruitReturn());
        FruitWorkStrategy fruitWork = new FruitWorkStrategyImp(workWithFruitsMap);

        StorageService storageService = new StorageServiceImpl(validData, fruitWork, fruitDao);
        storageService.workWithStorage();

        System.out.println(Storage.storage);
    }
}

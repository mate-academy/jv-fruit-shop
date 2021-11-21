import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
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
        String spr = File.separator;
        FruitDao fruitDao = new FruitDaoImpl();
        Map<String, WorkWithFruits> fruitStrategyMap = new HashMap<>();
        String pathPattern = "src" + spr + "main" + spr + "resources" + spr;
        String validDataPath = pathPattern + "validData.csv";
        fruitStrategyMap.put("b", new FruitBalance());
        fruitStrategyMap.put("s", new FruitSupply());
        fruitStrategyMap.put("p", new FruitPurchase());
        fruitStrategyMap.put("r", new FruitReturn());
        FruitWorkStrategy fruitWork = new FruitWorkStrategyImp(fruitStrategyMap);
        StorageService storageService = new StorageServiceImpl(validDataPath, fruitWork, fruitDao);
        storageService.workWithStorage();
    }
}

package core.basesyntax;

import core.basesyntax.infratructure.db.FruitsDao;
import core.basesyntax.infratructure.db.FruitsDaoImpl;
import core.basesyntax.infratructure.persistence.FruitRepository;
import core.basesyntax.infratructure.persistence.FruitRepositoryImpl;
import core.basesyntax.infratructure.persistence.FruitRepositorySupplier;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitServiceImpl;
import core.basesyntax.service.Operation;
import core.basesyntax.service.usecases.FruitUseService;
import core.basesyntax.service.usecases.PushareFruitImpl;
import core.basesyntax.service.usecases.ReturnFruitToBalanceImpl;
import core.basesyntax.service.usecases.SupplyFruitToBalanceImpl;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] arg) {
        // 1. Read the data from the input CSV file
        FruitsDao fruitsDao = new FruitsDaoImpl();
        List<String> allData;
        try {
            allData = fruitsDao.getFruits();
        } catch (IOException e) {
            throw new RuntimeException("Can't read from DB");
        }

        // 2. Convert the incoming data into FruitTransactions list
        FruitRepositorySupplier fruitRepositorySupplier = new FruitRepositorySupplier();
        Map<String, Fruit> fruitMap = fruitRepositorySupplier.get(allData);
        FruitRepository fruitRepository = new FruitRepositoryImpl(fruitMap);

        // 3. Create and feel the map with all OperationHandler implementations
        Map<Operation, FruitUseService> fruitUseServiceMap = new HashMap<>();
        fruitUseServiceMap
                .put(Operation.SUPPLY, new SupplyFruitToBalanceImpl(fruitRepository));
        fruitUseServiceMap
                .put(Operation.PURCHASE, new PushareFruitImpl(fruitRepository));
        fruitUseServiceMap
                .put(Operation.RETURN, new ReturnFruitToBalanceImpl(fruitRepository));
        FruitService fruitService = new FruitServiceImpl(fruitRepository, fruitUseServiceMap);

        // 4. Process the incoming transactions with applicable OperationHandler implementations
        fruitService.makeOperation(Operation.RETURN, "banana", 10);

        try {
            fruitsDao.setFruits(fruitService.getFruitRepository().getFruitMap());
        } catch (IOException e) {
            throw new RuntimeException("Can't write into DB");
        }

    }
}

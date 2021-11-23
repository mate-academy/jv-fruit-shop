package core.basesyntax;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.impl.FileReaderServiceImpl;
import core.basesyntax.impl.FileWriterServiceImpl;
import core.basesyntax.impl.FruitStoreServiceImpl;
import core.basesyntax.impl.ReportServiceImpl;
import core.basesyntax.impl.ValidatorServiceImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.ManipulationService;
import core.basesyntax.strategy.Manipulations;
import core.basesyntax.strategy.impl.BalanceManipulationService;
import core.basesyntax.strategy.impl.PurchaseManipulationService;
import core.basesyntax.strategy.impl.ReturnManipulationService;
import core.basesyntax.strategy.impl.SupplyManipulationService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String INPUT_PATH = "src/main/resources/InputFile";
    private static final String OUTPUT_PATH = "src/main/resources/OutputFile";

    public static void main(String[] args) {
        Map<Manipulations, ManipulationService> manipulationServiceMap = new HashMap<>();
        manipulationServiceMap.put(Manipulations.BALANCE, new BalanceManipulationService());
        manipulationServiceMap.put(Manipulations.PURCHASE, new PurchaseManipulationService());
        manipulationServiceMap.put(Manipulations.RETURN, new ReturnManipulationService());
        manipulationServiceMap.put(Manipulations.SUPPLY, new SupplyManipulationService());

        FruitStorageDao fruitStorageDao = new FruitStorageDaoImpl();
        List<String> data = new FileReaderServiceImpl().readFile(INPUT_PATH);
        if (new ValidatorServiceImpl().isValid(data)) {
            List<Fruit> fruits = new FruitStoreServiceImpl()
                    .changeBalance(data, manipulationServiceMap, fruitStorageDao);
            String report = new ReportServiceImpl().createReport(fruits);
            new FileWriterServiceImpl().writeFileToFile(OUTPUT_PATH, report);
        }
    }
}

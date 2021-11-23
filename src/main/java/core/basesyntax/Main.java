package core.basesyntax;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FruitStoreServiceImpl;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.ValidatorServiceImpl;
import core.basesyntax.strategy.Manipulation;
import core.basesyntax.strategy.ManipulationService;
import core.basesyntax.strategy.ManipulationStrategy;
import core.basesyntax.strategy.impl.BalanceManipulationService;
import core.basesyntax.strategy.impl.ManipulationStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseManipulationService;
import core.basesyntax.strategy.impl.ReturnManipulationService;
import core.basesyntax.strategy.impl.SupplyManipulationService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String OUTPUT_PATH = "src/main/resources/outputFile.csv";
    private static final String INPUT_PATH = "src/main/resources/inputFile.csv";

    public static void main(String[] args) {
        FruitStorageDao fruitStorageDao = new FruitStorageDaoImpl();
        Map<Manipulation, ManipulationService> manipulationServiceMap = new HashMap<>();
        manipulationServiceMap.put(Manipulation.BALANCE,
                new BalanceManipulationService(fruitStorageDao));
        manipulationServiceMap.put(Manipulation.PURCHASE,
                new PurchaseManipulationService(fruitStorageDao));
        manipulationServiceMap.put(Manipulation.RETURN,
                new ReturnManipulationService(fruitStorageDao));
        manipulationServiceMap.put(Manipulation.SUPPLY,
                new SupplyManipulationService(fruitStorageDao));

        List<String> data = new FileReaderServiceImpl().readFile(INPUT_PATH);
        new ValidatorServiceImpl().isValid(data);
        ManipulationStrategy manipulationStrategy =
                new ManipulationStrategyImpl(manipulationServiceMap);
        List<TransactionDto> transactionDtos = new ArrayList<>();
        ParserService parserService = new ParserServiceImpl();
        transactionDtos = parserService.parseLines(data);
        List<Fruit> fruits = new FruitStoreServiceImpl(fruitStorageDao, manipulationStrategy)
                .changeBalance(transactionDtos);
        String report = new ReportServiceImpl().createReport(fruits);
        new FileWriterServiceImpl().writeToFile(OUTPUT_PATH, report);
    }
}

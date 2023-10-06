package core.basesyntax;

import core.basesyntax.dao.FileService;
import core.basesyntax.dao.FileServiceImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitInfoConverter;
import core.basesyntax.service.FruitInfoGrouper;
import core.basesyntax.service.FruitInfoService;
import core.basesyntax.service.impl.FruitInfoConverterImpl;
import core.basesyntax.service.impl.FruitInfoGrouperImpl;
import core.basesyntax.service.impl.FruitInfoServiceImpl;
import core.basesyntax.strategy.BalanceOperationStrategy;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.PurchaseOperationStrategy;
import core.basesyntax.strategy.ReturnOperationStrategy;
import core.basesyntax.strategy.SupplyOperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static void main(String[] args) {
        FileService fileService = new FileServiceImpl();
        String data = fileService.readFile("src/main/resources/inputReport");

        FruitInfoConverter fruitInfoConverter = new FruitInfoConverterImpl();
        List<Fruit> convertedFruitsInfo = fruitInfoConverter.convertFruitInfo(data);

        Map<String, OperationStrategy> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put("b", new BalanceOperationStrategy());
        operationStrategyMap.put("p", new PurchaseOperationStrategy());
        operationStrategyMap.put("s", new SupplyOperationStrategy());
        operationStrategyMap.put("r", new ReturnOperationStrategy());

        FruitInfoGrouper fruitGrouper = new FruitInfoGrouperImpl(operationStrategyMap);
        Map<String, Integer> groupedInfoFruits = fruitGrouper.groupFruitsInfo(convertedFruitsInfo);

        FruitInfoService fruitInfoService = new FruitInfoServiceImpl();
        String report = fruitInfoService.createReport(groupedInfoFruits);

        fileService.writeToFile(report, "src/main/resources/resultReport");
    }
}

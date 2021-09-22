package core.basesyntax;

import core.basesyntax.model.FruitRecordDto;
import core.basesyntax.model.OperationType;
import core.basesyntax.operation.BalanceHandleImpl;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.operation.IncreaseFruitHandlerImpl;
import core.basesyntax.operation.OperationStrategy;
import core.basesyntax.operation.OperationStrategyImpl;
import core.basesyntax.operation.PurchaseHandlerImpl;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FruitParserImpl;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.FruitShopServiceImpl;
import core.basesyntax.service.ReadFromFileImpl;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.WriteToFileImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE = "src/main/resources/output.csv";

    public static void main(String[] args) {
        FileReader readFromFile = new ReadFromFileImpl();
        List<String> list = readFromFile.read(INPUT_FILE);
        FruitParserImpl fruitParser = new FruitParserImpl();
        Map<String, OperationHandler> fruitIntegerMap = new HashMap<>();
        fruitIntegerMap.put(OperationType.BALANCE.getShortName(),
                new BalanceHandleImpl());
        fruitIntegerMap.put(OperationType.SUPPLY.getShortName(),
                new IncreaseFruitHandlerImpl());
        fruitIntegerMap.put(OperationType.RETURN.getShortName(),
                new IncreaseFruitHandlerImpl());
        fruitIntegerMap.put(OperationType.PURCHASE.getShortName(),
                new PurchaseHandlerImpl());
        OperationStrategy operationStrategy = new OperationStrategyImpl(fruitIntegerMap);
        FruitShopService fruitShopService = new FruitShopServiceImpl(operationStrategy);
        List<FruitRecordDto> fruitRecordDtoList = fruitParser.apply(list);
        fruitShopService.save(fruitRecordDtoList);
        String report = fruitShopService.createReport();
        FileWriter writeToFile = new WriteToFileImpl();
        writeToFile.write(report, OUTPUT_FILE);
    }
}

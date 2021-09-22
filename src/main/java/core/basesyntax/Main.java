package core.basesyntax;

import core.basesyntax.model.FruitRecordDto;
import core.basesyntax.model.OperationType;
import core.basesyntax.operation.BalanceHandler;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.operation.IncreaseFruitHandler;
import core.basesyntax.operation.OperationStrategy;
import core.basesyntax.operation.OperationStrategyImpl;
import core.basesyntax.operation.PurchaseHandler;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FruitParserImpl;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.FruitShopServiceImpl;
import core.basesyntax.service.FileReaderImpl;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FileWriterImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE = "src/main/resources/output.csv";

    public static void main(String[] args) {
        FileReader readFromFile = new FileReaderImpl();
        List<String> list = readFromFile.read(INPUT_FILE);
        FruitParserImpl fruitParser = new FruitParserImpl();
        Map<String, OperationHandler> fruitIntegerMap = new HashMap<>();
        fruitIntegerMap.put(OperationType.BALANCE.getShortName(),
                new BalanceHandler());
        fruitIntegerMap.put(OperationType.SUPPLY.getShortName(),
                new IncreaseFruitHandler());
        fruitIntegerMap.put(OperationType.RETURN.getShortName(),
                new IncreaseFruitHandler());
        fruitIntegerMap.put(OperationType.PURCHASE.getShortName(),
                new PurchaseHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(fruitIntegerMap);
        FruitShopService fruitShopService = new FruitShopServiceImpl(operationStrategy);
        List<FruitRecordDto> fruitRecordDtoList = fruitParser.apply(list);
        fruitShopService.save(fruitRecordDtoList);
        String report = fruitShopService.createReport();
        FileWriter writeToFile = new FileWriterImpl();
        writeToFile.write(report, OUTPUT_FILE);
    }
}

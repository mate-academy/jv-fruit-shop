package core.basesyntax;

import core.basesyntax.model.FruitRecordDto;
import core.basesyntax.model.TypeOperation;
import core.basesyntax.operation.BalanceHandleImpl;
import core.basesyntax.operation.Handler;
import core.basesyntax.operation.IncreaseFruitHandlerImpl;
import core.basesyntax.operation.OperationStrategy;
import core.basesyntax.operation.OperationStrategyImpl;
import core.basesyntax.operation.PurchaseHandlerImpl;
import core.basesyntax.service.FruitParserImpl;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.FruitShopServiceImpl;
import core.basesyntax.service.ReadFromFile;
import core.basesyntax.service.ReadFromFileImpl;
import core.basesyntax.service.WriteToFile;
import core.basesyntax.service.WriteToFileImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE = "src/main/resources/output.csv";

    public static void main(String[] args) {
        ReadFromFile readFromFile = new ReadFromFileImpl();
        List<String> list = readFromFile.fileReader(INPUT_FILE);
        FruitParserImpl fruitParser = new FruitParserImpl();
        Map<String, Handler> fruitIntegerMap = new HashMap<>();
        fruitIntegerMap.put(TypeOperation.BALANCE.getShortName(),
                new BalanceHandleImpl());
        fruitIntegerMap.put(TypeOperation.SUPPLY.getShortName(),
                new IncreaseFruitHandlerImpl());
        fruitIntegerMap.put(TypeOperation.RETURN.getShortName(),
                new IncreaseFruitHandlerImpl());
        fruitIntegerMap.put(TypeOperation.PURCHASE.getShortName(),
                new PurchaseHandlerImpl());
        OperationStrategy operationStrategy = new OperationStrategyImpl(fruitIntegerMap);
        FruitShopService fruitShopService = new FruitShopServiceImpl(operationStrategy);
        List<FruitRecordDto> fruitRecordDtoList = fruitParser.apply(list);
        fruitShopService.save(fruitRecordDtoList);
        String report = fruitShopService.createReport();
        WriteToFile writeToFile = new WriteToFileImpl();
        writeToFile.writeToFile(report, OUTPUT_FILE);
    }
}

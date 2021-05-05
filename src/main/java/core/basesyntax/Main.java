package core.basesyntax;

import core.basesyntax.dao.FruitShopDao;
import core.basesyntax.dao.FruitShopDaoMapImpl;
import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.dto.FruitRecordDtoParser;
import core.basesyntax.dto.FruitRecordDtoParserImpl;
import core.basesyntax.model.OperationType;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.FruitShopServiceImpl;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.OperationStrategyImpl;
import core.basesyntax.service.file.FileService;
import core.basesyntax.service.file.FileServiceImpl;
import core.basesyntax.service.handler.AddToBalance;
import core.basesyntax.service.handler.OperationHandler;
import core.basesyntax.service.handler.SubtractFromBalance;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/inputFile";
    private static final String OUTPUT_FILE = "src/main/resources/DailyReport";

    public static void main(String[] args) {
        FruitShopDao fruitShopDao = new FruitShopDaoMapImpl();
        OperationHandler addToBalance = new AddToBalance(fruitShopDao);
        Map<OperationType, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(OperationType.BALANCE, addToBalance);
        operationHandlerMap.put(OperationType.PURCHASE,
                new SubtractFromBalance(fruitShopDao));
        operationHandlerMap.put(OperationType.SUPPLY, addToBalance);
        operationHandlerMap.put(OperationType.RETURN, addToBalance);
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FileService fileService = new FileServiceImpl();
        FruitRecordDtoParser fruitRecordDtoParser = new FruitRecordDtoParserImpl();
        FruitShopService fruitShopService =
                new FruitShopServiceImpl(fruitShopDao, operationStrategy);
        List<FruitRecordDto> fruitRecordDtos =
                fruitRecordDtoParser.parse(fileService.readFile(INPUT_FILE));
        fruitShopService.saveData(fruitRecordDtos);
        fileService.writeToFile(OUTPUT_FILE, fruitShopService.getReport());
    }
}

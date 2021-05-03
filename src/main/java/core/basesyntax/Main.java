package core.basesyntax;

import core.basesyntax.model.FruitRecordDto;
import core.basesyntax.model.OperationType;
import core.basesyntax.service.DecreaseStrategy;
import core.basesyntax.service.FileService;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.FruitShopServiceImpl;
import core.basesyntax.service.IncreaseStrategy;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.RecordDtoParser;
import core.basesyntax.service.RecordDtoParserImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<OperationType, OperationStrategy> handlers = new HashMap<>();
        handlers.put(OperationType.BALANCE, new IncreaseStrategy());
        handlers.put(OperationType.RETURN, new IncreaseStrategy());
        handlers.put(OperationType.SUPPLY, new IncreaseStrategy());
        handlers.put(OperationType.PURCHASE, new DecreaseStrategy());

        FileService fileReader = new FileService();
        List<String> fromFile = fileReader.readDataFromFile("src/main/java/resources/input.csv");
        //System.out.println(fromFile);
        RecordDtoParser recordDtoParser = new RecordDtoParserImpl();
        List<FruitRecordDto> fruitRecordDtos = recordDtoParser.parse(fromFile);
        //System.out.println(fruitRecordDtos);
        FruitShopService fruitShopService = new FruitShopServiceImpl(handlers);
        fruitShopService.applySuitableOperation(fruitRecordDtos);
        FileService fileService = new FileService();
        fileService.writeReportToFile(fruitShopService.fruitStorage(),
                            "src/main/java/resources/report.csv");
    }
}

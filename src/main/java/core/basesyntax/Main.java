package core.basesyntax;

import core.basesyntax.database.Storage;
import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.handler.DecreaseOperationHandler;
import core.basesyntax.handler.IncreaseOperationHandler;
import core.basesyntax.handler.OperationHandler;
import core.basesyntax.model.OperationType;
import core.basesyntax.service.FileService;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.RecordDtoParser;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.implementions.FileServiceImpl;
import core.basesyntax.service.implementions.FruitServiceImpl;
import core.basesyntax.service.implementions.RecordDtoParserImpl;
import core.basesyntax.service.implementions.ReportCreatorImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_NAME_FROM = "src/main/java/resources/input.csv";
    private static final String FILE_NAME_TO = "src/main/java/resources/report.csv";

    public static void main(String[] args) {
        OperationHandler increaseHandler = new IncreaseOperationHandler();
        Map<OperationType, OperationHandler> handlers = new HashMap<>();
        handlers.put(OperationType.BALANCE, increaseHandler);
        handlers.put(OperationType.RETURN, increaseHandler);
        handlers.put(OperationType.SUPPLY, increaseHandler);
        handlers.put(OperationType.PURCHASE, new DecreaseOperationHandler());

        FruitRecordDto fruitRecord = new FruitRecordDto();
        OperationStrategy operationStrategy = new OperationStrategyImpl(handlers);
        FileService fileService = new FileServiceImpl();
        RecordDtoParser recordDtoParser = new RecordDtoParserImpl();
        FruitService fruitService = new FruitServiceImpl(operationStrategy, fruitRecord);
        ReportCreator reportCreator = new ReportCreatorImpl();

        List<FruitRecordDto> fruitRecordDtos = recordDtoParser
                                            .parse(fileService.readDataFromFile(FILE_NAME_FROM));
        fruitService.saveData(fruitRecordDtos);
        fileService.writeToFile(FILE_NAME_TO, reportCreator.createReport(Storage.fruitStorage));
    }
}

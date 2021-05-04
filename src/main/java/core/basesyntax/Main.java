package core.basesyntax;

import core.basesyntax.database.Storage;
import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.model.OperationType;
import core.basesyntax.service.FileService;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.RecordDtoParser;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.implementions.FileServiceImpl;
import core.basesyntax.service.implementions.FruitServiceImpl;
import core.basesyntax.service.implementions.RecordDtoParserImpl;
import core.basesyntax.service.implementions.ReportCreatorImpl;
import core.basesyntax.strategy.DecreaseStrategy;
import core.basesyntax.strategy.IncreaseStrategy;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_NAME_FROM = "src/main/java/resources/input.csv";
    private static final String FILE_NAME_TO = "src/main/java/resources/report.csv";

    public static void main(String[] args) {
        Map<OperationType, OperationStrategy> handlers = new HashMap<>();
        handlers.put(OperationType.BALANCE, new IncreaseStrategy());
        handlers.put(OperationType.RETURN, new IncreaseStrategy());
        handlers.put(OperationType.SUPPLY, new IncreaseStrategy());
        handlers.put(OperationType.PURCHASE, new DecreaseStrategy());

        FileService fileReader = new FileServiceImpl();
        List<String> fromFile = fileReader.readDataFromFile(FILE_NAME_FROM);
        RecordDtoParser recordDtoParser = new RecordDtoParserImpl();
        List<FruitRecordDto> fruitRecordDtos = recordDtoParser.parse(fromFile);
        FruitService fruitService = new FruitServiceImpl(handlers);
        fruitService.saveDataToDataBase(fruitRecordDtos);
        ReportCreator reportCreator = new ReportCreatorImpl();
        String report = reportCreator.createReport(Storage.fruitStorage);
        FileService fileService = new FileServiceImpl();
        fileService.writeToFile(FILE_NAME_TO, report);
    }
}

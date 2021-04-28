package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoMapImpl;
import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.service.FileService;
import core.basesyntax.service.FruitRecordDtoParser;
import core.basesyntax.service.FruitRecordStrategy;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.handler.AddAmountHandler;
import core.basesyntax.service.handler.RecordHandler;
import core.basesyntax.service.handler.SubtractAmountHandler;
import core.basesyntax.service.impl.FileServiceImpl;
import core.basesyntax.service.impl.FruitRecordDtoParserImpl;
import core.basesyntax.service.impl.FruitRecordStrategyImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/DailyActivity.csv";
    private static final String OUTPUT_FILE = "src/main/resources/DailyFruitReport.csv";

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoMapImpl();
        RecordHandler addHandler = new AddAmountHandler(fruitDao);
        Map<FruitRecordDto.Type, RecordHandler> operationStrategies = new HashMap<>();
        operationStrategies.put(FruitRecordDto.Type.b, addHandler);
        operationStrategies.put(FruitRecordDto.Type.p, new SubtractAmountHandler(fruitDao));
        operationStrategies.put(FruitRecordDto.Type.s, addHandler);
        operationStrategies.put(FruitRecordDto.Type.r, addHandler);

        FruitRecordStrategy fruitRecordStrategy = new FruitRecordStrategyImpl(operationStrategies);
        FileService fileService = new FileServiceImpl();
        FruitRecordDtoParser fruitRecordDtoParser = new FruitRecordDtoParserImpl();
        FruitService fruitService = new FruitServiceImpl(fruitRecordStrategy, fruitDao);

        List<FruitRecordDto> fruitRecordDtos = fruitRecordDtoParser.parse(
                fileService.readFile(INPUT_FILE));
        fruitService.saveData(fruitRecordDtos);
        fileService.writeToFile(OUTPUT_FILE, fruitService.getFruitReport());
    }
}

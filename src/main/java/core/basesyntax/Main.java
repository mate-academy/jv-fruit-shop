package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.model.Operation;
import core.basesyntax.service.fileservice.FileService;
import core.basesyntax.service.fileservice.FileServiceImplForCsv;
import core.basesyntax.service.handlers.AddOperationStrategy;
import core.basesyntax.service.handlers.FruitOperationStrategy;
import core.basesyntax.service.handlers.RemoveOperationStrategy;
import core.basesyntax.service.parser.FruitRecordDtoParser;
import core.basesyntax.service.parser.FruitRecordDtoParserImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String fromFile = "src/main/resources/shop_instructions.csv";
    private static final String toFile = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        FileService fileService = new FileServiceImplForCsv(fruitDao);
        FruitRecordDtoParser parser = new FruitRecordDtoParserImpl();
        List<FruitRecordDto> dtos = parser.parse(fileService.readAllLinesFromFile(fromFile));
        Map<Operation, FruitOperationStrategy> fruitOperationHandlerMap =
                createStrategyMap(fruitDao);
        for (FruitRecordDto dto : dtos) {
            fruitOperationHandlerMap
                    .get(dto.getOperationType())
                    .applyAction(dto);
        }
        fileService.writeReport(toFile);
    }

    private static Map<Operation, FruitOperationStrategy> createStrategyMap(FruitDao fruitDao) {
        Map<Operation, FruitOperationStrategy> fruitOperationHandler = new HashMap<>();
        fruitOperationHandler.put(Operation.getOperationByLetter("s"),
                new AddOperationStrategy(fruitDao));
        fruitOperationHandler.put(Operation.getOperationByLetter("r"),
                new AddOperationStrategy(fruitDao));
        fruitOperationHandler.put(Operation.getOperationByLetter("b"),
                new AddOperationStrategy(fruitDao));
        fruitOperationHandler.put(Operation.getOperationByLetter("p"),
                new RemoveOperationStrategy(fruitDao));
        return fruitOperationHandler;
    }
}

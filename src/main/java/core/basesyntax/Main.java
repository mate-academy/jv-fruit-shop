package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.model.Operation;
import core.basesyntax.service.fileservice.FileReader;
import core.basesyntax.service.fileservice.FileReaderForCsvImpl;
import core.basesyntax.service.fileservice.FileWriter;
import core.basesyntax.service.fileservice.FileWriterForCsvImpl;
import core.basesyntax.service.fruitservice.FruitRecordStrategy;
import core.basesyntax.service.fruitservice.FruitRecordStrategyImpl;
import core.basesyntax.service.fruitservice.FruitService;
import core.basesyntax.service.fruitservice.FruitServiceImpl;
import core.basesyntax.service.handlers.AddOperationStrategy;
import core.basesyntax.service.handlers.RecordHandler;
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
        FruitRecordDtoParser parser = new FruitRecordDtoParserImpl();
        RecordHandler addOperation = new AddOperationStrategy(fruitDao);

        Map<Operation, RecordHandler> fruitOperationHandler = new HashMap<>();
        fruitOperationHandler.put(Operation.getOperationByLetter("s"), addOperation);
        fruitOperationHandler.put(Operation.getOperationByLetter("r"), addOperation);
        fruitOperationHandler.put(Operation.getOperationByLetter("b"), addOperation);
        fruitOperationHandler.put(Operation.getOperationByLetter("p"),
                new RemoveOperationStrategy(fruitDao));
        FruitRecordStrategy fruitRecordStrategy =
                new FruitRecordStrategyImpl(fruitOperationHandler);
        FruitService fruitService = new FruitServiceImpl(fruitRecordStrategy, fruitDao);

        FileReader fileReader = new FileReaderForCsvImpl();
        FileWriter fileWriter = new FileWriterForCsvImpl();
        List<FruitRecordDto> dtos = parser.parse(fileReader.readAllLinesFromFile(fromFile));
        fruitService.saveData(dtos);
        fileWriter.write(fruitService.createReport(), toFile);
    }
}

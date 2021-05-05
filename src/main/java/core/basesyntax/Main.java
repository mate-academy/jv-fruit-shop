package core.basesyntax;

import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FruitOperationHandler;
import core.basesyntax.service.FruitRecordDtoParser;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.WriteService;
import core.basesyntax.service.impl.AddOperation;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FruitRecordDtoParserImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.Operation;
import core.basesyntax.service.impl.SubtractOperation;
import core.basesyntax.service.impl.WriteServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/inputFileExample.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<Operation, FruitOperationHandler> operationStrategy = new HashMap<>();
        operationStrategy.put(Operation.BALANCE, new AddOperation());
        operationStrategy.put(Operation.PURCHASE, new SubtractOperation());
        operationStrategy.put(Operation.RETURN, new AddOperation());
        operationStrategy.put(Operation.SUPPLY, new AddOperation());

        FileReader fileReader = new FileReaderImpl();
        List<String> records = fileReader.readFromFile(INPUT_FILE_PATH);

        FruitRecordDtoParser recordParser = new FruitRecordDtoParserImpl();
        List<FruitRecordDto> parsedLines = recordParser.parseLines(records);

        FruitService fruitService = new FruitServiceImpl(operationStrategy);
        fruitService.saveData(parsedLines);

        String report = fruitService.createReport();

        WriteService writeService = new WriteServiceImpl();
        writeService.write(report, REPORT_FILE_PATH);
    }
}

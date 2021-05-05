package core.basesyntax;

import core.basesyntax.model.Operation;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FruitOperationHandler;
import core.basesyntax.service.FruitRecordDtoParser;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.AddOperation;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FruitRecordDtoParserImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.PurchaseOperation;
import core.basesyntax.service.impl.WriteServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/shop_operation.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<Operation, FruitOperationHandler> operationStrategy = new HashMap<>();
        operationStrategy.put(Operation.BALANCE, new AddOperation());
        operationStrategy.put(Operation.PURCHASE, new PurchaseOperation());
        operationStrategy.put(Operation.RETURN, new AddOperation());
        operationStrategy.put(Operation.SUPPLY, new AddOperation());

        FileReaderService fileReader = new FileReaderImpl();
        List<String> records = fileReader.readFromFile(INPUT_FILE_PATH);

        FruitRecordDtoParser parser = new FruitRecordDtoParserImpl();
        List<FruitRecordDto> fruitRecordDtos = parser.parse(records);

        FruitService fruitService = new FruitServiceImpl();
        fruitService.addToStorage(fruitRecordDtos, operationStrategy);

        String report = fruitService.getReport();

        WriterService writerService = new WriteServiceImpl();
        writerService.write(report, REPORT_FILE_PATH);
    }
}

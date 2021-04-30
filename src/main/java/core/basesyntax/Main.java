package core.basesyntax;

import core.basesyntax.filework.CsvFileReaderImpl;
import core.basesyntax.filework.CsvFileWriterImpl;
import core.basesyntax.filework.FileReader;
import core.basesyntax.filework.FileWriter;
import core.basesyntax.model.OperationType;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitServiceImpl;
import core.basesyntax.service.Parser;
import core.basesyntax.service.ParserCsvImpl;
import core.basesyntax.service.strategy.DecreaseOperationHandler;
import core.basesyntax.service.strategy.IncreaseOperationHandler;
import core.basesyntax.service.strategy.OperationHandler;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String FROM_FILE_NAME = "src/main/resources/fruit_shop.csv";
    private static final String TO_FILE_NAME = "src/main/resources/result.csv";

    public static void main(String[] args) {
        Map<OperationType, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(OperationType.BALANCE, new IncreaseOperationHandler());
        operationHandlerMap.put(OperationType.SUPPLY, new IncreaseOperationHandler());
        operationHandlerMap.put(OperationType.RETURN, new IncreaseOperationHandler());
        operationHandlerMap.put(OperationType.PURCHASE, new DecreaseOperationHandler());

        FileReader reader = new CsvFileReaderImpl();
        String[] lines = reader.read(FROM_FILE_NAME);
        Parser parser = new ParserCsvImpl();
        parser.parse(lines);
        FruitService fruitService = new FruitServiceImpl();
        String report = fruitService.createReport(operationHandlerMap);
        FileWriter writer = new CsvFileWriterImpl();
        writer.write(TO_FILE_NAME, report);
    }
}

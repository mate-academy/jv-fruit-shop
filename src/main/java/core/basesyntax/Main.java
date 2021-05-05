package core.basesyntax;

import core.basesyntax.model.Operation;
import core.basesyntax.model.dao.FruitDao;
import core.basesyntax.model.dao.FruitDaoImpl;
import core.basesyntax.service.impl.AddOperationHandler;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.RemoveOperationHandler;
import core.basesyntax.service.impl.ReportGeneratorServiceImpl;
import core.basesyntax.service.interfaces.FileReaderService;
import core.basesyntax.service.interfaces.FileWriterService;
import core.basesyntax.service.interfaces.FruitService;
import core.basesyntax.service.interfaces.OperationHandler;
import core.basesyntax.service.interfaces.OperationStrategy;
import core.basesyntax.service.interfaces.ParserService;
import core.basesyntax.service.interfaces.ReportGeneratorService;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        ReportGeneratorService reportGeneratorService = new ReportGeneratorServiceImpl();
        ParserService parserService = new ParserServiceImpl();

        Path inputFile = Path.of("src/main/resources/input.csv");
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        final List<String> lines = fileReaderService.readLines(inputFile);

        Map<Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.BALANCE, new AddOperationHandler(fruitDao));
        operationHandlerMap.put(Operation.SUPPLY, new AddOperationHandler(fruitDao));
        operationHandlerMap.put(Operation.RETURN, new AddOperationHandler(fruitDao));
        operationHandlerMap.put(Operation.PURCHASE, new RemoveOperationHandler(fruitDao));

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FruitService fruitService =
                new FruitServiceImpl(reportGeneratorService, operationStrategy, parserService);
        fruitService.saveData(lines);
        String report = fruitService.getReport();

        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeData(report, "src/main/resources/output.csv");
    }
}

package main;

import main.model.Operation;
import main.service.impl.AddOperationHandler;
import main.service.impl.FileReaderServiceImpl;
import main.service.impl.FileWriterServiceImpl;
import main.service.impl.FruitServiceImpl;
import main.service.impl.OperationStrategyImpl;
import main.service.impl.RemoveOperationHandler;
import main.service.interfaces.FileWriterService;
import main.service.interfaces.FruitService;
import main.service.interfaces.OperationHandler;
import main.service.interfaces.OperationStrategy;
import main.service.interfaces.FileReaderService;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Path inputFile = Path.of("src/main/resources/input.csv");
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> lines = fileReaderService.readLines(inputFile);

        Map<Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.B, new AddOperationHandler());
        operationHandlerMap.put(Operation.S, new AddOperationHandler());
        operationHandlerMap.put(Operation.R, new AddOperationHandler());
        operationHandlerMap.put(Operation.P, new RemoveOperationHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FruitService fruitService = new FruitServiceImpl(operationStrategy);
        fruitService.saveData(lines);
        String report = fruitService.getReport();

        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeData(report, "src/main/resources/output.csv");
    }
}

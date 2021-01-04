package core.basesyntax;

import core.basesyntax.model.Operation;
import core.basesyntax.parse.FruitReport;
import core.basesyntax.parse.FruitRetortImpl;
import core.basesyntax.parse.ParseFruit;
import core.basesyntax.parse.ParseFruitImpl;
import core.basesyntax.service.CsvFileReader;
import core.basesyntax.service.CsvFileWriter;
import core.basesyntax.service.FilesReader;
import core.basesyntax.service.FilesWriter;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitServiceImpl;
import core.basesyntax.strategy.AdditionStrategy;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.ReductionStrategy;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Operation, OperationStrategy> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(Operation.BALANCE, new AdditionStrategy());
        operationStrategyMap.put(Operation.RETURN, new AdditionStrategy());
        operationStrategyMap.put(Operation.SUPPLY, new AdditionStrategy());
        operationStrategyMap.put(Operation.PURCHASE, new ReductionStrategy());

        FruitService fruitService = new FruitServiceImpl(operationStrategyMap);
        ParseFruit parseFruit = new ParseFruitImpl();
        FruitReport fruitReport = new FruitRetortImpl();
        FilesWriter filesWriter = new CsvFileWriter();
        FilesReader filesReader = new CsvFileReader();

        fruitService.applyOperations(parseFruit.parse(filesReader.read("storageFile.csv")));
        filesWriter.write(fruitReport.create(fruitService.getFruitReport()), "report.csv");
    }
}

package core.basesyntax;

import core.basesyntax.model.Operation;
import core.basesyntax.model.Record;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.CsvFileReader;
import core.basesyntax.service.impl.CsvFileWriter;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.strategy.AdditionStrategy;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.ReductionStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    private static final String PATH_TO_INPUT = "src/main/resources/input.csv";
    private static final String PATH_TO_OUTPUT = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<Operation, OperationStrategy> operationStrategyMap = new HashMap<>();

        operationStrategyMap.put(Operation.BALANCE, new AdditionStrategy());
        operationStrategyMap.put(Operation.SUPPLY, new AdditionStrategy());
        operationStrategyMap.put(Operation.RETURN, new AdditionStrategy());
        operationStrategyMap.put(Operation.PURCHASE, new ReductionStrategy());

        FileReader fileReader = new CsvFileReader();
        List<Record> records = fileReader.readAll(PATH_TO_INPUT);

        FruitService fruitService = new FruitServiceImpl(operationStrategyMap);
        fruitService.applyOperationOnRecord(records);
        Map<String, Long> fruitReport = fruitService.getFruitReport();

        FileWriter fileWriter = new CsvFileWriter();
        fileWriter.writeReportToFile(fruitReport, PATH_TO_OUTPUT);
    }
}

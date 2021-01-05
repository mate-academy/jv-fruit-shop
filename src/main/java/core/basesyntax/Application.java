package core.basesyntax;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.servise.FileParser;
import core.basesyntax.servise.FileWriter;
import core.basesyntax.servise.FilesReader;
import core.basesyntax.servise.FruitService;
import core.basesyntax.servise.impl.CsvParser;
import core.basesyntax.servise.impl.FileWriterImpl;
import core.basesyntax.servise.impl.FilesReaderImpl;
import core.basesyntax.servise.impl.FruitServiceImpl;
import core.basesyntax.strategy.AdditionStrategy;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.ReductionStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Map<Operation, OperationStrategy> operationMap = new HashMap<>();
        operationMap.put(Operation.BALANCE, new AdditionStrategy());
        operationMap.put(Operation.SUPPLY, new AdditionStrategy());
        operationMap.put(Operation.PURCHASE, new ReductionStrategy());
        operationMap.put(Operation.RETURN, new AdditionStrategy());

        FilesReader filesReader = new FilesReaderImpl();
        FileParser<TransactionDto> fileParser = new CsvParser();
        List<String> list = filesReader.readData("src/main/resources/test-fruit.csv");
        List<TransactionDto> dtoList = fileParser.parseData(list);

        FruitService fruitService = new FruitServiceImpl(operationMap);
        fruitService.applyOperation(dtoList);
        Map<Fruit, Integer> report = fruitService.getFruitReport();

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.createReport(report, "src/main/resources/fruit-report.csv");
    }
}

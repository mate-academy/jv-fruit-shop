package core.basesyntax;

import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.CsvFileReader;
import core.basesyntax.service.CsvFileWriter;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ParseToList;
import core.basesyntax.service.impl.CsvFileReaderImpl;
import core.basesyntax.service.impl.CsvFileWriterImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ParseToListImpl;
import core.basesyntax.strategy.AdditionStrategy;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.ReduceStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        Map<Operation, OperationStrategy> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(Operation.BALANCE, new AdditionStrategy());
        operationStrategyMap.put(Operation.SUPPLY, new AdditionStrategy());
        operationStrategyMap.put(Operation.RETURN, new AdditionStrategy());
        operationStrategyMap.put(Operation.PURCHASE, new ReduceStrategy());

        CsvFileReader fileReader = new CsvFileReaderImpl();
        FruitService fruitService = new FruitServiceImpl(operationStrategyMap);
        ParseToList parse = new ParseToListImpl();
        List<TransactionDto> transactionDtos = parse.parseToTransactions(
                fileReader.readFile("src/main/resources/test_fruits"));
        fruitService.applyOperationoOnFruitsDto(transactionDtos);

        CsvFileWriter fileWriter = new CsvFileWriterImpl();
        fileWriter.writeReport("src/main/resources/fruits_report", fruitService.getFruitsReport());
    }
}

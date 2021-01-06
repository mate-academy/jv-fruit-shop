package core.basesyntax;

import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.CsvFileReader;
import core.basesyntax.service.CsvFileWriter;
import core.basesyntax.service.CsvParser;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.CsvFileReaderImpl;
import core.basesyntax.service.impl.CsvFileWriterImpl;
import core.basesyntax.service.impl.CsvParserImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.strategy.AdditionStrategy;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.ReductionStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static void main(String[] args) {
        Map<Operation, OperationStrategy> operationOperationStrategyMap = new HashMap<>();
        operationOperationStrategyMap.put(Operation.BALANCE, new AdditionStrategy());
        operationOperationStrategyMap.put(Operation.SUPPLY, new AdditionStrategy());
        operationOperationStrategyMap.put(Operation.RETURN, new AdditionStrategy());
        operationOperationStrategyMap.put(Operation.PURCHASE, new ReductionStrategy());

        CsvFileReader reader = new CsvFileReaderImpl();
        List<String> transactionDtoString = reader.readData("src/main/resources/test-fruit.csv");
        CsvParser csvFileWriter = new CsvParserImpl();
        List<TransactionDto> transactionDtos = csvFileWriter.convert(transactionDtoString);
        FruitService service = new FruitServiceImpl(operationOperationStrategyMap);
        service.applyOperationsOnFruitsDto(transactionDtos);
        CsvFileWriter writer = new CsvFileWriterImpl();
        writer.writeData("src/main/resources/test-fruit-write.csv");
    }
}

package core.basesyntax;

import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.CsvFileReader;
import core.basesyntax.service.CsvFileWriter;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.CsvFileReaderImpl;
import core.basesyntax.service.impl.CsvFileWriterImpl;
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
    private static final String FILE_PATH_READER = "src/main/resources/test-fruit.txt";
    private static final String FILE_PATH_REPORT = "src/main/resources/report-fruit.txt";

    public static void main(String[] args) {
        Map<Operation, OperationStrategy> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(Operation.BALANCE, new AdditionStrategy());
        operationStrategyMap.put(Operation.SUPPLY, new AdditionStrategy());
        operationStrategyMap.put(Operation.RETURN, new AdditionStrategy());
        operationStrategyMap.put(Operation.PURCHASE, new ReductionStrategy());

        CsvFileReader reader = new CsvFileReaderImpl();
        CsvFileWriter writer = new CsvFileWriterImpl();
        FruitService fruitService = new FruitServiceImpl(operationStrategyMap);

        List<TransactionDto> transactionDtos = reader.readData(FILE_PATH_READER);
        fruitService.applyOperationOnFruitDto(transactionDtos);
        Map<String, Long> fruitReport = fruitService.getFruitReport();
        writer.reportFile(fruitReport,FILE_PATH_REPORT);
    }
}

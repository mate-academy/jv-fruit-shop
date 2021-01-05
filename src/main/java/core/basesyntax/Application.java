package core.basesyntax;

import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.DataReader;
import core.basesyntax.service.DataWriter;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.CsvDataReaderImpl;
import core.basesyntax.service.impl.CsvDataWriterImpl;
import core.basesyntax.service.impl.CsvParser;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.strategy.AdditionStrategyImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.ReductionStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    private static final String INPUT_FILEPATH = "src/main/resources/test-fruit.csv";
    private static final String OUTPUT_FILEPATH = "src/main/resources/output-fruit.csv";

    public static void main(String[] args) {
        CsvParser csvParser = new CsvParser();
        DataReader dataReader = new CsvDataReaderImpl(csvParser);
        Map<Operation, OperationStrategy> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(Operation.BALANCE, new AdditionStrategyImpl());
        operationStrategyMap.put(Operation.PURCHASE, new ReductionStrategyImpl());
        operationStrategyMap.put(Operation.SUPPLY, new AdditionStrategyImpl());
        operationStrategyMap.put(Operation.RETURN, new AdditionStrategyImpl());
        FruitService fruitService = new FruitServiceImpl(operationStrategyMap);
        DataWriter dataWriter = new CsvDataWriterImpl();
        List<TransactionDto> transactionsFromFile = dataReader.read(INPUT_FILEPATH);
        fruitService.applyTransactionsToDB(transactionsFromFile);
        String report = fruitService.getReport();
        dataWriter.writeReport(report, OUTPUT_FILEPATH);
    }
}

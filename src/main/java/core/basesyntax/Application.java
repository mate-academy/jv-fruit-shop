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
    public static void main(String[] args) {
        String inputFilepath = "src/main/resources/test-fruit.csv";
        DataReader dataReader = new CsvDataReaderImpl();
        List<String> linesFromFile = dataReader.read(inputFilepath);
        linesFromFile.remove(0);
        Map<Operation, OperationStrategy> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(Operation.BALANCE, new AdditionStrategyImpl());
        operationStrategyMap.put(Operation.PURCHASE, new ReductionStrategyImpl());
        operationStrategyMap.put(Operation.SUPPLY, new AdditionStrategyImpl());
        operationStrategyMap.put(Operation.RETURN, new AdditionStrategyImpl());
        FruitService fruitService = new FruitServiceImpl(operationStrategyMap);
        CsvParser csvParser = new CsvParser();
        List<TransactionDto> transactionDtoList = csvParser.parse(linesFromFile);
        fruitService.applyTransactionsToDB(transactionDtoList);
        String report = fruitService.getReport();
        String outputFilepath = "src/main/resources/output-fruit.csv";
        DataWriter dataWriter = new CsvDataWriterImpl();
        dataWriter.writeReport(report, outputFilepath);
    }
}

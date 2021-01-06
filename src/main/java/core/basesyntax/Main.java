package core.basesyntax;

import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.parse.DataParser;
import core.basesyntax.parse.FruitParserImpl;
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
    public static final String STORAGE_FILE = "src/main/resources/storageFile.csv";
    public static final String REPORT_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<Operation, OperationStrategy> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(Operation.BALANCE, new AdditionStrategy());
        operationStrategyMap.put(Operation.RETURN, new AdditionStrategy());
        operationStrategyMap.put(Operation.SUPPLY, new AdditionStrategy());
        operationStrategyMap.put(Operation.PURCHASE, new ReductionStrategy());

        FruitService fruitService = new FruitServiceImpl(operationStrategyMap);
        DataParser<TransactionDto> parseFruit = new FruitParserImpl();
        FilesWriter filesWriter = new CsvFileWriter();
        FilesReader filesReader = new CsvFileReader();

        fruitService.applyOperations(parseFruit.parse(filesReader.read(STORAGE_FILE)));
        filesWriter.write(fruitService.getFruitReport(),REPORT_FILE);
    }
}

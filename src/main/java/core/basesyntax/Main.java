package core.basesyntax;

import core.basesyntax.model.Operation;
import core.basesyntax.service.CsvFileReader;
import core.basesyntax.service.CsvFileWriter;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.CsvFileReaderImpl;
import core.basesyntax.service.impl.CsvFileWriterImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.strategy.BalanceStrategy;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.PurchaseStrategy;
import core.basesyntax.strategy.ReturnStrategy;
import core.basesyntax.strategy.SupplyStrategy;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final String FILE_PATH = "src/main/resources/fruit-shop.csv";
    private static final String FRUIT_REPORT_CSV = "src/main/resources/fruit-report.csv";

    public static void main(String[] args) {
        Map<Operation, OperationStrategy> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(Operation.BALANCE, new BalanceStrategy());
        operationStrategyMap.put(Operation.SUPPLY, new SupplyStrategy());
        operationStrategyMap.put(Operation.PURCHASE, new PurchaseStrategy());
        operationStrategyMap.put(Operation.RETURN, new ReturnStrategy());

        CsvFileReader csvFileReader = new CsvFileReaderImpl();
        FruitService fruitService = new FruitServiceImpl(operationStrategyMap);
        fruitService.applyOperationsOnFruitsDto(csvFileReader.readFromFile(FILE_PATH));
        CsvFileWriter csvFileWriter = new CsvFileWriterImpl();
        csvFileWriter.reportFile(fruitService.getFruitsReport(), FRUIT_REPORT_CSV);
    }
}

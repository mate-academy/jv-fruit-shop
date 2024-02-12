package core.basesyntax;

import core.basesyntax.converter.FruitParser;
import core.basesyntax.converter.MapToStringListConverter;
import core.basesyntax.converter.impl.FruitParserImpl;
import core.basesyntax.converter.impl.MapToStringListConverterImpl;
import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.db.FruitDatabase;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.OperationStrategySupplier;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.OperationStrategySupplierImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.operation.OperationStrategy;
import core.basesyntax.service.operation.impl.BalanceOperationStrategy;
import core.basesyntax.service.operation.impl.PurchaseOperationStrategy;
import core.basesyntax.service.operation.impl.ReturnOperationStrategy;
import core.basesyntax.service.operation.impl.SupplyOperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String PATH_TO_INPUT_FILE = "src/main/java/core/basesyntax/csv/input.csv";
    private static final String PATH_TO_REPORT = "src/main/java/core/basesyntax/csv/report.csv";

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        Map<FruitTransaction.Operation, OperationStrategy> strategies = new HashMap<>();
        strategies.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationStrategy(fruitDao));
        strategies.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationStrategy(fruitDao));
        strategies.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationStrategy(fruitDao));
        strategies.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationStrategy(fruitDao));
        FileReader fileReader = new FileReaderImpl();
        List<String> strings = fileReader.readLines(PATH_TO_INPUT_FILE);

        FruitParser fruitParser =
                new FruitParserImpl();
        List<FruitTransaction> fruitTransactions = fruitParser.parseList(strings);

        OperationStrategySupplier supplier = new OperationStrategySupplierImpl(strategies);
        FruitService fruitService = new FruitServiceImpl(supplier);
        fruitService.performFruitsOperations(fruitTransactions);

        MapToStringListConverter toStringListConverter = new MapToStringListConverterImpl();
        List<String> reportStrings = toStringListConverter.parseMap(FruitDatabase.database);

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.generateReport(reportStrings);

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeToFile(report, PATH_TO_REPORT);
    }
}

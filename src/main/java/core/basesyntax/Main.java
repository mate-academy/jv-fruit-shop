package core.basesyntax;

import core.basesyntax.converter.FruitParser;
import core.basesyntax.converter.impl.FruitParserImpl;
import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
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
    private static final String PATH_TO_INPUT_FILE =
            "src/main/resources/input.csv";
    private static final String PATH_TO_REPORT =
            "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationStrategy> strategies = new HashMap<>();
        fillMapWithValues(strategies);

        FileReader fileReader = new FileReaderImpl();
        FruitParser fruitParser = new FruitParserImpl();
        List<String> strings = fileReader.readLines(PATH_TO_INPUT_FILE);
        List<FruitTransaction> fruitTransactions = fruitParser.parseFruitTransaction(strings);

        OperationStrategySupplier supplier = new OperationStrategySupplierImpl(strategies);
        FruitService fruitService = new FruitServiceImpl(supplier);
        fruitService.performFruitsOperations(fruitTransactions);

        ReportService reportService = new ReportServiceImpl();
        String report = reportService.generateReport();

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeToFile(report, PATH_TO_REPORT);
    }

    private static void fillMapWithValues(Map<FruitTransaction.Operation, OperationStrategy> map) {
        FruitDao fruitDao = new FruitDaoImpl();
        map.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationStrategy(fruitDao));
        map.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationStrategy(fruitDao));
        map.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationStrategy(fruitDao));
        map.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationStrategy(fruitDao));
    }
}

package core.basesyntax;

import core.basesyntax.dao.ShopDao;
import core.basesyntax.dao.ShopDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.Operation;
import core.basesyntax.model.OperationType;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.Parser;
import core.basesyntax.service.Reporter;
import core.basesyntax.service.impl.CsvParser;
import core.basesyntax.service.impl.CsvReaderImpl;
import core.basesyntax.service.impl.CsvReporter;
import core.basesyntax.service.impl.CsvWriterImpl;
import core.basesyntax.service.impl.ValidateCsv;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.handlers.BalanceOperationHandler;
import core.basesyntax.strategy.handlers.PurchaseOperationHandler;
import core.basesyntax.strategy.handlers.ReturnOperationHandler;
import core.basesyntax.strategy.handlers.SupplyOperationHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Path FROM_PATH = Paths.get("src/main/resources/FruitShop.csv");
    private static final Path TO_PATH = Paths.get("src/main/resources/report.csv");
    private static final Map<OperationType, OperationHandler> handlers = new HashMap<>();

    public static void main(String[] args) {
        FileReader fileReader = new CsvReaderImpl();
        final List<String> inputData = fileReader.readFile(FROM_PATH);
        new ValidateCsv().isValid(inputData);
        Parser parser = new CsvParser();
        final List<Operation> operations = parser.parse(inputData);
        ShopDao dao = new ShopDaoImpl(Storage.shopStorage);
        handlers.put(OperationType.BALANCE, new BalanceOperationHandler(dao));
        handlers.put(OperationType.PURCHASE, new PurchaseOperationHandler(dao));
        handlers.put(OperationType.RETURN, new ReturnOperationHandler(dao));
        handlers.put(OperationType.SUPPLY, new SupplyOperationHandler(dao));
        OperationStrategy strategy = new OperationStrategyImpl(handlers);
        operations.forEach(operation -> strategy.get(operation).process(operation));
        Reporter reporter = new CsvReporter();
        final List<String> report = reporter.generate(dao.getAll());
        FileWriter fileWriter = new CsvWriterImpl();
        fileWriter.writeCsv(report, TO_PATH);
    }
}

package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FileHandler;
import core.basesyntax.service.FileValidator;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.Parser;
import core.basesyntax.service.Reporter;
import core.basesyntax.service.ShopDao;
import core.basesyntax.service.impl.BalanceOperationHandler;
import core.basesyntax.service.impl.CsvHandlerImpl;
import core.basesyntax.service.impl.CsvParser;
import core.basesyntax.service.impl.CsvReporter;
import core.basesyntax.service.impl.DbSetInitialState;
import core.basesyntax.service.impl.PurchaseOperationHandler;
import core.basesyntax.service.impl.ReturnOperationHandler;
import core.basesyntax.service.impl.ShopDaoImpl;
import core.basesyntax.service.impl.SupplyOperationHandler;
import core.basesyntax.service.impl.ValidateCsv;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.OperationType;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    private static final Path FROM_PATH = Paths.get("src/main/FruitShop.csv");
    private static final Path TO_PATH = Paths.get("src/main/report.csv");
    private static final Map<OperationType, OperationHandler> handlers = new HashMap<>();

    public static void main(String[] args) {
        FileHandler fileHandler = new CsvHandlerImpl();
        List<String> inputData = fileHandler.readFile(FROM_PATH);
        FileValidator validator = new ValidateCsv();
        if (!validator.isValid(inputData)) {
            throw new RuntimeException("input data from file" + FROM_PATH
                    + " has unsupported format");
        }
        Parser parser = new CsvParser();
        List<Operation> operations = inputData.stream()
                .skip(1)
                .map(parser::parse)
                .collect(Collectors.toList());
        Storage storage = new DbSetInitialState().initialStorage(operations);
        ShopDao dao = new ShopDaoImpl(storage);
        handlers.put(OperationType.BALANCE, new BalanceOperationHandler(dao));
        handlers.put(OperationType.PURCHASE, new PurchaseOperationHandler(dao));
        handlers.put(OperationType.RETURN, new ReturnOperationHandler(dao));
        handlers.put(OperationType.SUPPLY, new SupplyOperationHandler(dao));
        OperationStrategy strategy = new OperationStrategyImpl(handlers);
        operations.forEach(o -> strategy.get(o).process(o));
        Reporter reporter = new CsvReporter();
        List<String> report = reporter.generate(dao.getAll());
        fileHandler.writeCsv(report, TO_PATH);
    }
}

package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Operation;
import core.basesyntax.service.*;
import core.basesyntax.service.impl.*;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.dao.ShopDao;
import core.basesyntax.strategy.handlers.BalanceOperationHandler;
import core.basesyntax.strategy.handlers.PurchaseOperationHandler;
import core.basesyntax.strategy.handlers.ReturnOperationHandler;
import core.basesyntax.dao.ShopDaoImpl;
import core.basesyntax.strategy.handlers.SupplyOperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.model.OperationType;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    private static final Path FROM_PATH = Paths.get("src/main/resources/FruitShop.csv");
    private static final Path TO_PATH = Paths.get("src/main/resources/report.csv");
    private static final Map<OperationType, OperationHandler> handlers = new HashMap<>();

    public static void main(String[] args) {
        FileReader fileReader = new CsvReaderImpl();
        List<String> inputData = fileReader.readFile(FROM_PATH);
        FileValidator validator = new ValidateCsv();
        Parser parser = new CsvParser();
        List<Operation> operations = inputData.stream()
                .skip(1)
                .map(parser::parse)
                .collect(Collectors.toList());
        Storage storage = new Storage();
        ShopDao dao = new ShopDaoImpl(storage.shopStorage);
        handlers.put(OperationType.BALANCE, new BalanceOperationHandler(dao));
        handlers.put(OperationType.PURCHASE, new PurchaseOperationHandler(dao));
        handlers.put(OperationType.RETURN, new ReturnOperationHandler(dao));
        handlers.put(OperationType.SUPPLY, new SupplyOperationHandler(dao));
        OperationStrategy strategy = new OperationStrategyImpl(handlers);
        operations.forEach(operation -> strategy.get(operation).process(operation));
        Reporter reporter = new CsvReporter();
        List<String> report = reporter.generate(dao.getAll());
        FileWriter fileWriter = new CsvWriterImpl();
        fileWriter.writeCsv(report, TO_PATH);
    }
}

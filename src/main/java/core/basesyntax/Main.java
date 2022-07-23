package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.handlers.BalanceOperationHandler;
import core.basesyntax.handlers.OperationHandler;
import core.basesyntax.handlers.PurchaseOperationHandler;
import core.basesyntax.handlers.ReturnOperationHandler;
import core.basesyntax.handlers.SupplyOperationHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ParseService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.ParseServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.csv";

    public static void main(String[] args) {
        StorageDao storageDao = new StorageDaoImpl();
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("b", new BalanceOperationHandler(storageDao));
        operationHandlerMap.put("p", new PurchaseOperationHandler(storageDao));
        operationHandlerMap.put("r", new ReturnOperationHandler(storageDao));
        operationHandlerMap.put("s", new SupplyOperationHandler(storageDao));

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);

        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> data = fileReaderService.readFromFile(INPUT_FILE_PATH);

        ParseService parseService = new ParseServiceImpl();
        List<FruitTransaction> parse = parseService.parse(data);

        for (FruitTransaction fruitTransaction : parse) {
            OperationHandler operationHandler = operationStrategy.get(
                    fruitTransaction.getOperation());
            operationHandler.doOperation(fruitTransaction.getFruit(),
                    fruitTransaction.getQuantity());
        }
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.makeReport(storageDao.getAll());

        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(OUTPUT_FILE_PATH, report);
    }
}

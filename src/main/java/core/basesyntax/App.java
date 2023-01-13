package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operationhandler.OperationHandler;
import core.basesyntax.operationhandler.impl.BalanceOperationHandler;
import core.basesyntax.operationhandler.impl.PurchaseOperationHandler;
import core.basesyntax.operationhandler.impl.ReturnOperationHandler;
import core.basesyntax.operationhandler.impl.SupplyOperationHandler;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ParseService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FruitTransactionParseService;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    private static final String INPUT_FILE_PATH = "src/main/resources/input_file.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output_file.csv";
    private static final int DATA_START_INDEX = 1;

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler());

        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> lines = fileReaderService.readAllLines(INPUT_FILE_PATH);
        ParseService<FruitTransaction> fruitTransactionParseService
                = new FruitTransactionParseService();
        OperationStrategy operationStrategy
                = new OperationStrategyImpl(operationHandlerMap);
        for (String line : lines.subList(DATA_START_INDEX, lines.size())) {
            FruitTransaction fruitTransaction = fruitTransactionParseService.parse(line);
            OperationHandler operationHandler
                    = operationStrategy.getHandler(fruitTransaction.getOperation());
            operationHandler.handle(fruitTransaction);
        }

        FruitDao fruitDao = new FruitDaoImpl();
        Map<String, Integer> fruitStorage = fruitDao.getStorage();
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.getReport(fruitStorage);

        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(OUTPUT_FILE_PATH, report);
    }
}

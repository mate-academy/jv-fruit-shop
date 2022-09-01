package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.impl.CsvReportServiceImpl;
import core.basesyntax.impl.FileReaderServiceImpl;
import core.basesyntax.impl.FileWriterServiceImpl;
import core.basesyntax.impl.TransactionCsvParseServiceImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.BalanceOperationHandler;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.operation.PurchaseOperationHandler;
import core.basesyntax.operation.ReturnOperationHandler;
import core.basesyntax.operation.SupplyOperationHandler;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ParseService;
import core.basesyntax.service.ReportService;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/fruits_info.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/fruits_report.csv";
    private static final int DATA_START_INDEX = 1;

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler(fruitDao));
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler(fruitDao));
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler(fruitDao));
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler(fruitDao));

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        ParseService<FruitTransaction> parseService = new TransactionCsvParseServiceImpl();
        FileReaderService readerService = new FileReaderServiceImpl();
        List<String> lines = readerService.readFromFile(INPUT_FILE_PATH);
        for (String raw : lines.subList(DATA_START_INDEX, lines.size())) {
            FruitTransaction fruitTransaction = parseService.parse(raw);
            OperationHandler operationHandler =
                    operationStrategy.get(fruitTransaction.getOperation());
            operationHandler.handle(fruitTransaction);
        }

        Map<String, Integer> fruitStorage = fruitDao.getAll();
        ReportService reportService = new CsvReportServiceImpl();
        String finalReport = reportService.createReport(fruitStorage);

        FileWriterService writerService = new FileWriterServiceImpl();
        writerService.writeToFile(OUTPUT_FILE_PATH, finalReport);
    }
}

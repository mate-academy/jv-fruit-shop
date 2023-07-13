package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.CsvParserServiceImpl;
import core.basesyntax.service.impl.CsvReportServiceImpl;
import core.basesyntax.service.io.ReaderService;
import core.basesyntax.service.io.ReaderServiceImpl;
import core.basesyntax.service.io.WriterService;
import core.basesyntax.service.io.WriterServiceImpl;
import core.basesyntax.service.operation.BalanceHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseHandler;
import core.basesyntax.service.operation.ReturnHandler;
import core.basesyntax.service.operation.SupplyHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String PATH_INPUT_FILE = "src/main/resources/operations.csv";
    private static final String PATH_OUTPUT_FILE = "src/main/resources/report.csv";
    private static final int START_LINE_OF_DATA = 1;

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        Map<FruitTransaction.Operation, OperationHandler> operations = new HashMap<>();
        operations.put(FruitTransaction.Operation.BALANCE, new BalanceHandler(fruitDao));
        operations.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler(fruitDao));
        operations.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler(fruitDao));
        operations.put(FruitTransaction.Operation.RETURN, new ReturnHandler(fruitDao));

        OperationStrategy operationStrategy = new OperationStrategyImpl(operations);
        ReaderService reader = new ReaderServiceImpl();
        List<String> list = reader.readFromFile(PATH_INPUT_FILE);
        ParserService<FruitTransaction> parserService = new CsvParserServiceImpl();

        for (String line : list.subList(START_LINE_OF_DATA, list.size())) {
            FruitTransaction fruitTransaction = parserService.parse(line);
            OperationHandler operationHandler =
                    operationStrategy.get(fruitTransaction.getOperation());
            operationHandler.process(fruitTransaction);
        }

        Map<String, Integer> storage = fruitDao.getAll();
        ReportService reportService = new CsvReportServiceImpl();
        String report = reportService.create(storage);
        WriterService writer = new WriterServiceImpl();
        writer.writeToFile(PATH_OUTPUT_FILE, report);
    }
}

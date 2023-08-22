package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.FruitTransactionServiceImpl;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.BalanceOperationHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperationHandler;
import core.basesyntax.strategy.ReturnOperationHandler;
import core.basesyntax.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_NAME = "src/main/resources/input.csv";
    private static final String REPORT_FILE_NAME = "src/main/resources/dailyreport.csv";

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        Map<FruitTransaction.Operation, OperationHandler> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler());
        operationStrategyMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationStrategyMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler());
        operationStrategyMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationStrategyMap);

        ReaderService readFromCsvFile = new ReaderServiceImpl();
        List<String> dataFromFile = readFromCsvFile.readFile(INPUT_FILE_NAME);
        ParserService parserService = new ParserServiceImpl();
        List<FruitTransaction> fruitTransactions = parserService.parse(dataFromFile);

        FruitTransactionService fruitTransactionService
                = new FruitTransactionServiceImpl(fruitDao, operationStrategy);
        fruitTransactionService.executeTransaction(fruitTransactions);

        ReportService reportService = new ReportServiceImpl(fruitDao);
        String report = reportService.createReport();
        WriterService writerService = new WriterServiceImpl();
        writerService.writeToFile(report, REPORT_FILE_NAME);
    }
}

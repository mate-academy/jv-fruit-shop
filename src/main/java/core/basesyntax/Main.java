package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileParser;
import core.basesyntax.service.FruitTransactionParser;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.CsvFileParserImpl;
import core.basesyntax.service.impl.FruitTransactionParserImpl;
import core.basesyntax.service.impl.FruitTransactionServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE = "inputData.csv";
    private static final String OUTPUT_FILE = "outputData.csv";

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

        OperationStrategy strategy =
                new OperationStrategyImpl(operationHandlerMap);

        ReaderService readerService = new ReaderServiceImpl();

        List<String> lines = readerService.readFile(INPUT_FILE);

        FileParser fileParser = new CsvFileParserImpl();
        FruitTransactionParser fruitTransactionParser = new FruitTransactionParserImpl(fileParser);

        FruitTransactionService fruitTransactionService =
                new FruitTransactionServiceImpl(strategy);

        for (FruitTransaction fruitTransaction : fruitTransactionParser.parse(lines)) {
            fruitTransactionService.transaction(fruitTransaction);
        }

        ReportService reportService = new ReportServiceImpl(fruitDao);

        String report = reportService.createReport();

        WriterService writerService = new WriterServiceImpl();

        writerService.writeToFile(OUTPUT_FILE, report);
    }

}

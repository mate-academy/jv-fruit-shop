package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.OperationProcessorService;
import core.basesyntax.service.impl.FileReaderServiceCsvImpl;
import core.basesyntax.service.impl.FileWriterServiceCsvImpl;
import core.basesyntax.service.impl.OperationProcessorServiceImpl;
import core.basesyntax.service.impl.TransactionParserServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.handler.BalanceOperationHandler;
import core.basesyntax.strategy.handler.OperationHandler;
import core.basesyntax.strategy.handler.PurchaseOperationHandler;
import core.basesyntax.strategy.handler.ReturnOperationHandler;
import core.basesyntax.strategy.handler.SupplyOperationHandler;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FileReaderService fileReaderService = new FileReaderServiceCsvImpl();
        List<String> strings = fileReaderService.read(INPUT_FILE_PATH);
        TransactionParserServiceImpl transactionParserService = new TransactionParserServiceImpl();
        List<FruitTransaction> fruits = transactionParserService.parse(strings);
        FruitDao fruitDao = new FruitDaoImpl();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap
                = Map.of(FruitTransaction.Operation.BALANCE,
                         new BalanceOperationHandler(fruitDao),
                FruitTransaction.Operation.SUPPLY,
                         new SupplyOperationHandler(fruitDao),
                FruitTransaction.Operation.PURCHASE,
                         new PurchaseOperationHandler(fruitDao),
                FruitTransaction.Operation.RETURN,
                         new ReturnOperationHandler(fruitDao));
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        OperationProcessorService operationProcessorService
                = new OperationProcessorServiceImpl(operationStrategy);
        operationProcessorService.process(fruits);
        FileWriterService fileWriterService = new FileWriterServiceCsvImpl();
        fileWriterService.write(REPORT_FILE_PATH);
        System.out.println(fruits);
        System.out.println(Storage.fruitStorage);

    }
}

package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileService;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.impl.FileServiceCsvImpl;
import core.basesyntax.service.impl.FruitTransactionServiceImpl;
import core.basesyntax.service.impl.TransactionParserImpl;
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
        FileService fileService = new FileServiceCsvImpl();
        List<String> strings = fileService.read(INPUT_FILE_PATH);
        TransactionParserImpl transactionParserService = new TransactionParserImpl();
        List<FruitTransaction> transactions = transactionParserService.parse(strings);
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
        FruitTransactionService fruitTransactionService
                = new FruitTransactionServiceImpl(operationStrategy);
        fruitTransactionService.process(transactions);
        fileService.write(REPORT_FILE_PATH);
    }
}

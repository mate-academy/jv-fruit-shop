package core.basesyntax;

import core.basesyntax.db.StorageDao;
import core.basesyntax.db.StorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Executor;
import core.basesyntax.service.Parser;
import core.basesyntax.service.Reader;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.Writer;
import core.basesyntax.service.impl.ExecutorImpl;
import core.basesyntax.service.impl.ParserImpl;
import core.basesyntax.service.impl.ReaderImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.service.impl.WriterImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.operationhandlers.BalanceOperationHandler;
import core.basesyntax.strategy.operationhandlers.OperationHandler;
import core.basesyntax.strategy.operationhandlers.PurchaseOperationHandler;
import core.basesyntax.strategy.operationhandlers.ReturnOperationHandler;
import core.basesyntax.strategy.operationhandlers.SupplyOperationHandler;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    private static final String DB_FILE_PATH = "src/main/resources/database.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/report.csv";

    private static final Map<FruitTransaction.Operation,
            OperationHandler> OPERATION_HANDLER_MAP = Map.of(
            FruitTransaction.Operation.BALANCE, new BalanceOperationHandler(),
            FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler(),
            FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler(),
            FruitTransaction.Operation.RETURN, new ReturnOperationHandler());

    public static void main(String[] args) {
        Reader reader = new ReaderImpl();
        List<String> data = reader.readFile(DB_FILE_PATH);
        Parser parser = new ParserImpl();
        List<FruitTransaction> fruitTransactions = parser.parse(data);
        OperationStrategy operationStrategy = new OperationStrategyImpl(OPERATION_HANDLER_MAP);
        StorageDao storageDao = new StorageDaoImpl();
        Executor executor = new ExecutorImpl(storageDao, operationStrategy);
        executor.execute(fruitTransactions);
        ReportCreator reportCreator = new ReportCreatorImpl(storageDao);
        String report = reportCreator.createReport();
        Writer writer = new WriterImpl();
        writer.writeToFile(report, REPORT_FILE_PATH);
    }
}

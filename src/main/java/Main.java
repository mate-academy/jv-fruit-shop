import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.PrecessDataService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.CsvReaderServiceImpl;
import core.basesyntax.service.impl.CsvWriterServiceImpl;
import core.basesyntax.service.impl.ParserServiceImpl;
import core.basesyntax.service.impl.PrecessDataServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.handler.BalanceHandler;
import core.basesyntax.strategy.handler.OperationHandler;
import core.basesyntax.strategy.handler.PurchaseHandler;
import core.basesyntax.strategy.handler.ReturnHandler;
import core.basesyntax.strategy.handler.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final ReaderService READER_SERVICE =
            new CsvReaderServiceImpl("src/main/resources/text.csv");
    private static final WriterService WRITER_SERVICE =
            new CsvWriterServiceImpl("src/main/resources/result.csv");
    private static final ParserService PARSER_SERVICE = new ParserServiceImpl();
    private static final OperationStrategy OPERATION_STRATEGY;
    private static final PrecessDataService PRECESS_DATA_SERVICE;
    private static Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap;
    private static Storage storage = new Storage();

    static {
        operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());

        OPERATION_STRATEGY = new OperationStrategyImpl(operationHandlerMap);
        PRECESS_DATA_SERVICE = new PrecessDataServiceImpl(OPERATION_STRATEGY);
    }

    public static void main(String[] args) {
        List<String> lines = READER_SERVICE.getLines();
        List<FruitTransaction> records = PARSER_SERVICE.getRecords(lines);
        PRECESS_DATA_SERVICE.writeToStorage(records);
        WRITER_SERVICE.write(storage.getAll());
    }
}

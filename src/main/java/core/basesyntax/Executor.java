package core.basesyntax;

import core.basesyntax.dao.FruitStockDao;
import core.basesyntax.dao.FruitStockDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ConverterService;
import core.basesyntax.service.ProcessorService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ConverterServiceImpl;
import core.basesyntax.service.impl.ProcessorServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.service.impl.WriterMapToCsvServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceOperationHandlerImpl;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseOperationHandlerImpl;
import core.basesyntax.strategy.impl.ReturnOperationHandlerImpl;
import core.basesyntax.strategy.impl.SupplyOperationHandlerImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Executor {
    private static final String INPUT_FILE = "src/main/resources/input.csv";
    private static final String INPUT_FILE_HEADER = "type,fruit,quantity";
    private static final Storage FRUIT_STOCK = new Storage();
    private static final FruitStockDao FRUIT_STOCK_DAO = new FruitStockDaoImpl(FRUIT_STOCK);

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandlerImpl(FRUIT_STOCK_DAO));
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandlerImpl(FRUIT_STOCK_DAO));
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandlerImpl(FRUIT_STOCK_DAO));
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandlerImpl(FRUIT_STOCK_DAO));
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        ReaderService readerService = new ReaderServiceImpl();
        List<String> data = readerService.readFile(INPUT_FILE);
        ConverterService converterService = new ConverterServiceImpl();
        ProcessorService processorService = new ProcessorServiceImpl(operationStrategy);
        data.stream()
                .filter(string -> !string.equals(INPUT_FILE_HEADER))
                .map(converterService::convertStringToFruitTransaction)
                .forEach(processorService::process);
        ReportCreator<Storage> reportCreator = new ReportCreatorImpl();
        WriterService<String> writerService = new WriterMapToCsvServiceImpl();
        writerService.writeReport(reportCreator.createReport(FRUIT_STOCK));
    }
}

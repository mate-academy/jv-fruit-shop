package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitItem;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FruitItemService;
import core.basesyntax.service.FruitItemServiceImpl;
import core.basesyntax.service.FruitReportCreatorService;
import core.basesyntax.service.FruitReportCreatorServiceImpl;
import core.basesyntax.service.FruitReportFileWriter;
import core.basesyntax.service.FruitReportFileWriterCsvImpl;
import core.basesyntax.service.FruitServiceForHandleTransactions;
import core.basesyntax.service.FruitServiceForHandleTransactionsImpl;
import core.basesyntax.service.InputTransactionsFileReader;
import core.basesyntax.service.InputTransactionsFileReaderCsvImpl;
import core.basesyntax.service.strategy.FruitTransactionHandler;
import core.basesyntax.service.strategy.FruitTransactionHandlerBalance;
import core.basesyntax.service.strategy.FruitTransactionHandlerPurchase;
import core.basesyntax.service.strategy.FruitTransactionHandlerReturn;
import core.basesyntax.service.strategy.FruitTransactionHandlerSupply;
import core.basesyntax.service.strategy.FruitTransactionStrategy;
import core.basesyntax.service.strategy.FruitTransactionStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_NAME = "src\\main\\resources\\input.csv";
    private static final String OUTPUT_FILE_NAME = "src\\main\\resources\\output.csv";

    public static void main(String[] args) {
        final Map<Operation, FruitTransactionHandler> operationHandlersMap =
                new HashMap<>();
        operationHandlersMap.put(Operation.BALANCE, new FruitTransactionHandlerBalance());
        operationHandlersMap.put(Operation.SUPPLY, new FruitTransactionHandlerSupply());
        operationHandlersMap.put(Operation.PURCHASE, new FruitTransactionHandlerPurchase());
        operationHandlersMap.put(Operation.RETURN, new FruitTransactionHandlerReturn());
        FruitTransactionStrategy fruitTransactionStrategy =
                new FruitTransactionStrategyImpl(operationHandlersMap);

        FruitDao fruitDao = new FruitDaoImpl();
        FruitItemService fruitItemService = new FruitItemServiceImpl();

        InputTransactionsFileReader transActionsReader = new InputTransactionsFileReaderCsvImpl();
        List<FruitTransaction> fruitTransactions = transActionsReader.read(INPUT_FILE_NAME);

        FruitServiceForHandleTransactions fruitServiceForHandleTransactions =
                new FruitServiceForHandleTransactionsImpl(
                        fruitDao, fruitItemService, fruitTransactionStrategy);
        fruitServiceForHandleTransactions.handle(fruitTransactions);

        FruitReportCreatorService fruitReportCreatorService =
                new FruitReportCreatorServiceImpl(fruitDao);
        List<FruitItem> fruitReport = fruitReportCreatorService.create();

        FruitReportFileWriter fruitReportFileWriter = new FruitReportFileWriterCsvImpl();
        fruitReportFileWriter.write(OUTPUT_FILE_NAME, fruitReport);
    }
}

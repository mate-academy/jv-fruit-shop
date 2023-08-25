package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitItem;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FruitItemService;
import core.basesyntax.service.FruitItemServiceImpl;
import core.basesyntax.service.FruitReportFileWriter;
import core.basesyntax.service.FruitReportFileWriterCsvImpl;
import core.basesyntax.service.FruitTransactionsHandler;
import core.basesyntax.service.FruitTransactionsHandlerImpl;
import core.basesyntax.service.InputTransactionsFileReader;
import core.basesyntax.service.InputTransactionsFileReaderCsvImpl;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ReportServiceImpl;
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
    private static final String FOLDER_SEPARATOR = System.getProperty("file.separator");
    private static final String INPUT_FILE_NAME = "src" + FOLDER_SEPARATOR + "main"
            + FOLDER_SEPARATOR + "resources" + FOLDER_SEPARATOR + "input.csv";
    private static final String OUTPUT_FILE_NAME = "src" + FOLDER_SEPARATOR + "main"
            + FOLDER_SEPARATOR + "resources" + FOLDER_SEPARATOR + "output.csv";

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

        InputTransactionsFileReader transactionsReader = new InputTransactionsFileReaderCsvImpl();
        List<FruitTransaction> fruitTransactions = transactionsReader.read(INPUT_FILE_NAME);

        FruitTransactionsHandler fruitTransactionsHandler =
                new FruitTransactionsHandlerImpl(fruitTransactionStrategy);
        fruitTransactionsHandler.handle(fruitTransactions);

        ReportService reportService =
                new ReportServiceImpl(fruitDao);
        List<FruitItem> fruitReport = reportService.create();

        FruitReportFileWriter fruitReportFileWriter = new FruitReportFileWriterCsvImpl();
        fruitReportFileWriter.write(OUTPUT_FILE_NAME, fruitReport);
    }
}

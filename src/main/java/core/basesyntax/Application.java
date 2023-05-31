package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FruitQuantityCalculatorImpl;
import core.basesyntax.service.impl.FruitTransactionParserServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceOperationHandlerImpl;
import core.basesyntax.strategy.impl.OperationHandlerStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseOperationHandlerImpl;
import core.basesyntax.strategy.impl.ReturnOperationHandlerImpl;
import core.basesyntax.strategy.impl.SupplyOperationHandlerImpl;
import java.util.List;
import java.util.Map;

public class Application {
    private static final String VALID_DATA_FILE_PATH = "src/main/resources/ValidData";
    private static final String RESULT_FILE_PATH = "src/main/resources/WriteToFile";

    public static void main(String[] args) {
        List<String> dataFromFile = new FileReaderServiceImpl().readFromFile(VALID_DATA_FILE_PATH);

        List<FruitTransaction> fruitsTransaction = new FruitTransactionParserServiceImpl()
                .parseToFruitTransaction(dataFromFile);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap
                = Map.of(FruitTransaction.Operation.BALANCE, new BalanceOperationHandlerImpl(),
                FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandlerImpl(),
                FruitTransaction.Operation.RETURN, new ReturnOperationHandlerImpl(),
                FruitTransaction.Operation.SUPPLY, new SupplyOperationHandlerImpl());

        new FruitQuantityCalculatorImpl(new OperationHandlerStrategyImpl(operationHandlerMap))
                .calculateQuantity(fruitsTransaction);

        ReportService reportService = new ReportServiceImpl();
        String data = reportService.createReport(Storage.dataStorage);

        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(RESULT_FILE_PATH, data);
    }
}

package core.basesyntax;

import core.basesyntax.bd.TransactionStorage;
import core.basesyntax.bd.dao.FruitTransactionDao;
import core.basesyntax.bd.dao.FruitTransactionDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CreateReportService;
import core.basesyntax.service.FruitShopTransferService;
import core.basesyntax.service.ParseReaderService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.CreateReportServiceImpl;
import core.basesyntax.service.impl.FruitShopTransferServiceImpl;
import core.basesyntax.service.impl.ParseReaderServiceImpl;
import core.basesyntax.service.impl.ReadFromFileCsvImpl;
import core.basesyntax.service.impl.WriteToFileCsvImpl;
import core.basesyntax.service.operationhandler.Operation;
import core.basesyntax.service.operationhandler.OperationHandler;
import core.basesyntax.service.operationhandler.impl.AddingOperationHandler;
import core.basesyntax.service.operationhandler.impl.RemovingOperationHandler;
import core.basesyntax.service.validation.Validator;
import core.basesyntax.service.validation.ValidatorImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_DATA_FILE_PATH = "input.csv";
    private static final String REPORT_FILE_PATH = "output.csv";

    public static void main(String[] args) {
        FruitTransactionDao fruitTransactionDao = new FruitTransactionDaoImpl();
        ReaderService readReportService = new ReadFromFileCsvImpl();
        ParseReaderService parseReaderService = new ParseReaderServiceImpl();
        CreateReportService createReportService = new CreateReportServiceImpl();
        WriterService writeReportService = new WriteToFileCsvImpl();

        Map<Operation, OperationHandler> operationsHandlers = new HashMap<>();
        operationsHandlers.put(Operation.BALANCE,
                new AddingOperationHandler(fruitTransactionDao));
        operationsHandlers.put(Operation.PURCHASE,
                new RemovingOperationHandler(fruitTransactionDao));
        operationsHandlers.put(Operation.RETURN,
                new AddingOperationHandler(fruitTransactionDao));
        operationsHandlers.put(Operation.SUPPLY,
                new AddingOperationHandler(fruitTransactionDao));

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationsHandlers);
        FruitShopTransferService fruitShopTransferService
                = new FruitShopTransferServiceImpl(operationStrategy);

        List<String> dataFromFile = readReportService.readFromFile(INPUT_DATA_FILE_PATH);
        Validator validator = new ValidatorImpl();
        if (validator.isValid(dataFromFile)) {
            List<FruitTransaction> fruits = parseReaderService.getFruitList(dataFromFile);
            fruitShopTransferService.updateStorageInfo(fruits);
            String report = createReportService.createReport(TransactionStorage.fruits);
            writeReportService.writeReport(REPORT_FILE_PATH, report);
        }
    }
}

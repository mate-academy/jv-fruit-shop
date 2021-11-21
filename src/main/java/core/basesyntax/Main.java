package core.basesyntax;

import core.basesyntax.bd.TransactionStorage;
import core.basesyntax.bd.dao.FruitTransactionDao;
import core.basesyntax.bd.dao.FruitTransactionDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CreateReportService;
import core.basesyntax.service.FruitShopTransferService;
import core.basesyntax.service.ParseReaderService;
import core.basesyntax.service.ReadFromFileCvs;
import core.basesyntax.service.WriteToFileCvs;
import core.basesyntax.service.impl.CreateReportServiceImpl;
import core.basesyntax.service.impl.FruitShopTransferServiceImpl;
import core.basesyntax.service.impl.ParseReaderServiceImpl;
import core.basesyntax.service.impl.ReadFromFileCvsImpl;
import core.basesyntax.service.impl.WriteToFileCvsImpl;
import core.basesyntax.service.operationhandler.Operation;
import core.basesyntax.service.operationhandler.OperationHandler;
import core.basesyntax.service.operationhandler.impl.AddingOperationHandler;
import core.basesyntax.service.operationhandler.impl.RemovingOperationHandler;
import core.basesyntax.service.validation.Validator;
import core.basesyntax.service.validation.ValidatorImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_DATA_FILE_PATH = "input.csv";
    private static final String REPORT_FILE_PATH = "output.csv";

    public static void main(String[] args) {
        FruitTransactionDao fruitTransactionDao = new FruitTransactionDaoImpl();
        ReadFromFileCvs readReportService = new ReadFromFileCvsImpl();
        ParseReaderService parseReaderService = new ParseReaderServiceImpl();
        CreateReportService createReportService = new CreateReportServiceImpl();
        WriteToFileCvs writeReportService = new WriteToFileCvsImpl();
        FruitShopTransferService fruitShopTransferService = new FruitShopTransferServiceImpl();

        Map<Operation, OperationHandler> operationsHandlers = new HashMap<>();
        operationsHandlers.put(Operation.BALANCE,
                new AddingOperationHandler(fruitTransactionDao));
        operationsHandlers.put(Operation.PURCHASE,
                new RemovingOperationHandler(fruitTransactionDao));
        operationsHandlers.put(Operation.RETURN,
                new AddingOperationHandler(fruitTransactionDao));
        operationsHandlers.put(Operation.SUPPLY,
                new AddingOperationHandler(fruitTransactionDao));

        List<String> dataFromFile = readReportService.readFromFile(INPUT_DATA_FILE_PATH);
        Validator validator = new ValidatorImpl();
        if (validator.isValid(dataFromFile)) {
            List<FruitTransaction> fruits = parseReaderService.getFruitList(dataFromFile);
            fruitShopTransferService.updateStorageInfo(fruits, operationsHandlers);
            String report = createReportService.createReport(TransactionStorage.fruits);
            writeReportService.writeReport(REPORT_FILE_PATH, report);
        }
    }
}

package core.basesyntax;

import core.basesyntax.bd.dao.FruitDao;
import core.basesyntax.bd.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CreateReportService;
import core.basesyntax.service.FruitShopTransferService;
import core.basesyntax.service.ParseService;
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
    private static final String INPUT_DATA_FILE_PATH = "src/main/resources/input.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/output.csv";

    public static void main(String[] args) {
        ReaderService readReportService = new ReadFromFileCsvImpl();
        FruitDao fruitDao = new FruitDaoImpl();

        Map<Operation, OperationHandler> operationsHandlers = new HashMap<>();
        operationsHandlers.put(Operation.BALANCE, new AddingOperationHandler(fruitDao));
        operationsHandlers.put(Operation.PURCHASE, new RemovingOperationHandler(fruitDao));
        operationsHandlers.put(Operation.RETURN, new AddingOperationHandler(fruitDao));
        operationsHandlers.put(Operation.SUPPLY, new AddingOperationHandler(fruitDao));

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationsHandlers);
        FruitShopTransferService fruitShopTransferService
                = new FruitShopTransferServiceImpl(operationStrategy);
        ParseService parseReaderService = new ParseReaderServiceImpl();
        WriterService writeReportService = new WriteToFileCsvImpl();
        CreateReportService createReportService = new CreateReportServiceImpl();

        List<String> dataFromFile = readReportService.readFromFile(INPUT_DATA_FILE_PATH);
        Validator validator = new ValidatorImpl();
        validator.isValid(dataFromFile);
        List<FruitTransaction> fruits = parseReaderService.getTransaction(dataFromFile);
        fruitShopTransferService.updateStorageInfo(fruits);
        String report = createReportService.createReport();
        writeReportService.writeToFile(REPORT_FILE_PATH, report);
    }
}

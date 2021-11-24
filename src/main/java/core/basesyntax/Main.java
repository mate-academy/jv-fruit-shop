package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ParseServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.service.operationhandler.OperationHandler;
import core.basesyntax.service.operationhandler.impl.AddingOperationHandler;
import core.basesyntax.service.operationhandler.impl.RemovingOperationHandler;
import core.basesyntax.service.validation.Validator;
import core.basesyntax.service.validation.ValidatorCsvImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_DATA_FILE_PATH = "src/main/resources/input.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/output.csv";

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        Map<Operation, OperationHandler> operationsHandlers = new HashMap<>();
        operationsHandlers.put(Operation.BALANCE, new AddingOperationHandler(fruitDao));
        operationsHandlers.put(Operation.PURCHASE, new RemovingOperationHandler(fruitDao));
        operationsHandlers.put(Operation.RETURN, new AddingOperationHandler(fruitDao));
        operationsHandlers.put(Operation.SUPPLY, new AddingOperationHandler(fruitDao));
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationsHandlers);

        ReaderService readerService = new ReaderServiceImpl();
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        ParserService parserService = new ParseServiceImpl();
        WriterService writerService = new WriterServiceImpl();
        ReportService reportService = new ReportServiceImpl();

        List<String> dataFromFile = readerService.readFromFile(INPUT_DATA_FILE_PATH);
        Validator validator = new ValidatorCsvImpl();
        validator.isValid(dataFromFile);
        List<TransactionDto> transactionDtos = parserService.parseData(dataFromFile);
        shopService.updateStorageInfo(transactionDtos);
        String report = reportService.createReport(fruitDao.getAll());
        writerService.writeToFile(REPORT_FILE_PATH, report);
    }
}

package core.basesyntax;

import core.basesyntax.bd.dao.StorageDao;
import core.basesyntax.bd.dao.impl.StorageDaoImpl;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.service.operationhandler.Operation;
import core.basesyntax.service.operationhandler.OperationHandler;
import core.basesyntax.service.operationhandler.impl.AddOperation;
import core.basesyntax.service.operationhandler.impl.SubtractOperation;
import core.basesyntax.service.parser.ParserService;
import core.basesyntax.service.parser.impl.CsvParserService;
import core.basesyntax.service.validator.Validator;
import core.basesyntax.service.validator.impl.ValidatorImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Path DEFAULT_INPUT_PATH = Paths.get("inputData.csv");
    private static final Path DEFAULT_OUTPUT_PATH = Paths.get("outputData.csv");

    public static void main(String[] args) {
        StorageDao storageDao = new StorageDaoImpl();
        Map<Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.BALANCE, new AddOperation(storageDao));
        operationHandlerMap.put(Operation.SUPPLY, new AddOperation(storageDao));
        operationHandlerMap.put(Operation.PURCHASE, new SubtractOperation(storageDao));
        operationHandlerMap.put(Operation.RETURN, new AddOperation(storageDao));
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        TransactionService transactionService = new TransactionServiceImpl(operationStrategy);
        ReaderService reader = new ReaderServiceImpl();
        Validator validator = new ValidatorImpl();
        ParserService parser = new CsvParserService(validator);
        ReportService reporter = new ReportServiceImpl(storageDao);
        WriterService writer = new WriterServiceImpl();
        List<String> dataFromFile = reader.readFile(DEFAULT_INPUT_PATH);
        List<Transaction> transactionList = parser.parse(dataFromFile);
        transactionService.applyTransactions(transactionList);
        String report = reporter.createReport();
        writer.writeToFile(report, DEFAULT_OUTPUT_PATH);
    }

}

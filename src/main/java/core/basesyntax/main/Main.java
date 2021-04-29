package core.basesyntax.main;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.handlers.OperationDecreaseHandler;
import core.basesyntax.handlers.OperationHandler;
import core.basesyntax.handlers.OperationIncreaseHandler;
import core.basesyntax.model.dto.TransactionDto;
import core.basesyntax.service.fileservice.FileReaderService;
import core.basesyntax.service.fileservice.FileReaderServiceImpl;
import core.basesyntax.service.fileservice.FileWriterService;
import core.basesyntax.service.fileservice.FileWriterServiceImpl;
import core.basesyntax.service.storageservice.StorageService;
import core.basesyntax.service.storageservice.StorageServiceImpl;
import core.basesyntax.service.transactionservice.TransactionDtoService;
import core.basesyntax.service.transactionservice.TransactionDtoServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String OUPUT_FILE_PATH = "src\\main\\resources\\report.csv";
    private static final String INPUT_FILE_PATH = "src\\main\\resources\\data.csv";

    public static void main(String[] args) {
        StorageDao storageDao = new StorageDaoImpl();
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("b", new OperationIncreaseHandler(storageDao));
        operationHandlerMap.put("s", new OperationIncreaseHandler(storageDao));
        operationHandlerMap.put("p", new OperationDecreaseHandler(storageDao));
        operationHandlerMap.put("r", new OperationIncreaseHandler(storageDao));

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        StorageService storageService = new StorageServiceImpl(operationStrategy, storageDao);

        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> lines = fileReaderService.read(INPUT_FILE_PATH);
        TransactionDtoService transactionDtoService = new TransactionDtoServiceImpl();
        List<TransactionDto> transformedData = transactionDtoService.transform(lines);
        storageService.addToStorage(transformedData);

        String report = storageService.getReport();

        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.write(report, OUPUT_FILE_PATH);
    }
}

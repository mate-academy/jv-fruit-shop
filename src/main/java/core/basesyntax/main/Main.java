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
import core.basesyntax.service.storageservice.StorageReportService;
import core.basesyntax.service.storageservice.StorageReportServiceImpl;
import core.basesyntax.service.storageservice.StorageService;
import core.basesyntax.service.storageservice.StorageServiceImpl;
import core.basesyntax.service.transactionservice.TransactionDtoImpl;
import core.basesyntax.service.transactionservice.TransactionDtoService;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StorageDao storageDao = new StorageDaoImpl();
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("b", new OperationIncreaseHandler(storageDao));
        operationHandlerMap.put("s", new OperationIncreaseHandler(storageDao));
        operationHandlerMap.put("p", new OperationDecreaseHandler(storageDao));
        operationHandlerMap.put("r", new OperationIncreaseHandler(storageDao));

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        StorageService storageService = new StorageServiceImpl(operationStrategy);

        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> lines = fileReaderService.readFromFile("src\\main\\resources\\data.csv");
        TransactionDtoService transactionDtoService = new TransactionDtoImpl();
        List<TransactionDto> transform = transactionDtoService.transform(lines);
        storageService.addToStorage(transform);

        StorageReportService storageReportService = new StorageReportServiceImpl(storageDao);
        String report = storageReportService.getReport();

        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(report);
    }
}

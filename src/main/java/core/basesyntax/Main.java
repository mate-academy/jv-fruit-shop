package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.impl.StorageDaoImpl;
import core.basesyntax.model.Operation;
import core.basesyntax.service.OperationService;
import core.basesyntax.service.ProcessingService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.fileservice.FileReaderService;
import core.basesyntax.service.fileservice.FileWriterService;
import core.basesyntax.service.fileservice.impl.FileReaderServiceImpl;
import core.basesyntax.service.fileservice.impl.FileWriterServiceImpl;
import core.basesyntax.service.serviceimpl.OperationServiceImpl;
import core.basesyntax.service.serviceimpl.ProcessingServiceImpl;
import core.basesyntax.service.serviceimpl.ReportServiceImpl;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.OperationHandlerOfBalance;
import core.basesyntax.service.strategy.OperationHandlerOfPurchase;
import core.basesyntax.service.strategy.OperationHandlerOfReturn;
import core.basesyntax.service.strategy.OperationHandlerOfSupply;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.csv";

    public static void main(String[] args) {
        Map<Operation, OperationHandler> operationHandlerHashMap = new HashMap<>();
        StorageDao storageDao = new StorageDaoImpl();
        operationHandlerHashMap.put(Operation.BALANCE,
                new OperationHandlerOfBalance(storageDao));
        operationHandlerHashMap.put(Operation.SUPPLY,
                new OperationHandlerOfSupply(storageDao));
        operationHandlerHashMap.put(Operation.PURCHASE,
                new OperationHandlerOfPurchase(storageDao));
        operationHandlerHashMap.put(Operation.RETURN,
                new OperationHandlerOfReturn(storageDao));
        FileReaderService fileReader = new FileReaderServiceImpl();
        List<String> dataFromFile = fileReader.getData(INPUT_FILE_PATH);
        ProcessingService processingService = new ProcessingServiceImpl(operationHandlerHashMap);
        OperationService operationService = new OperationServiceImpl();
        processingService.processTransaction(operationService.createOperationList(dataFromFile));
        FileWriterService fileWriter = new FileWriterServiceImpl();
        ReportService report = new ReportServiceImpl(storageDao);
        fileWriter.setData(report.getReport(), OUTPUT_FILE_PATH);
    }
}

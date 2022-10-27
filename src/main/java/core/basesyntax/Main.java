package core.basesyntax;

import core.basesyntax.model.Operation;
import core.basesyntax.service.DataProcessingService;
import core.basesyntax.service.ReportGeneratorService;
import core.basesyntax.service.StorageReadService;
import core.basesyntax.service.StorageWriteService;
import core.basesyntax.service.impl.DataProcessingServiceImpl;
import core.basesyntax.service.impl.ReportGeneratorServiceImpl;
import core.basesyntax.service.impl.StorageReadServiceImpl;
import core.basesyntax.service.impl.StorageWriteServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.OperationHandlerBalance;
import core.basesyntax.strategy.impl.OperationHandlerPurchase;
import core.basesyntax.strategy.impl.OperationHandlerReturn;
import core.basesyntax.strategy.impl.OperationHandlerSupply;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_PATH_READ = "src/main/resources/storage.csv";
    private static final String FILE_PATH_WRITE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<Operation, OperationHandler> strategyMap = new HashMap<>();
        strategyMap.put(Operation.BALANCE, new OperationHandlerBalance());
        strategyMap.put(Operation.PURCHASE, new OperationHandlerPurchase());
        strategyMap.put(Operation.SUPPLY, new OperationHandlerSupply());
        strategyMap.put(Operation.RETURN, new OperationHandlerReturn());
        OperationStrategy strategyPicker = new OperationStrategyImpl();
        strategyPicker.provideStrategyList(strategyMap);
        StorageReadService reader = new StorageReadServiceImpl();
        List<String> data = reader.readData(FILE_PATH_READ);
        DataProcessingService dataProcessingService = new DataProcessingServiceImpl();
        dataProcessingService.processData(data, strategyPicker);
        ReportGeneratorService reportGenerator = new ReportGeneratorServiceImpl();
        String report = reportGenerator.generateReport();
        StorageWriteService writer = new StorageWriteServiceImpl();
        String recordingResult = writer.writeFromDb(report, FILE_PATH_WRITE);
        System.out.println(recordingResult);
    }
}

package core.basesyntax;

import core.basesyntax.model.Operation;
import core.basesyntax.service.DataProcessingService;
import core.basesyntax.service.OperationSelector;
import core.basesyntax.service.ReportGeneratorService;
import core.basesyntax.service.StorageReadService;
import core.basesyntax.service.StorageWriteService;
import core.basesyntax.service.impl.DataProcessingServiceImpl;
import core.basesyntax.service.impl.OperationSelectorBalance;
import core.basesyntax.service.impl.OperationSelectorPurchase;
import core.basesyntax.service.impl.OperationSelectorReturn;
import core.basesyntax.service.impl.OperationSelectorSupply;
import core.basesyntax.service.impl.ReportGeneratorServiceImpl;
import core.basesyntax.service.impl.StorageReadServiceImpl;
import core.basesyntax.service.impl.StorageWriteServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_PATH_READ = "src/main/resources/storage.csv";
    private static final String FILE_PATH_WRITE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<Operation, OperationSelector> strategyMap = new HashMap<>();
        strategyMap.put(Operation.BALANCE, new OperationSelectorBalance());
        strategyMap.put(Operation.PURCHASE, new OperationSelectorPurchase());
        strategyMap.put(Operation.SUPPLY, new OperationSelectorSupply());
        strategyMap.put(Operation.RETURN, new OperationSelectorReturn());
        OperationStrategy strategyPicker = new OperationStrategyImpl();
        strategyPicker.provideStrategyList(strategyMap);
        File file = new File(FILE_PATH_READ);
        StorageReadService reader = new StorageReadServiceImpl();
        List<String> data = reader.readData(file);
        DataProcessingService dataProcessingService = new DataProcessingServiceImpl();
        dataProcessingService.processData(data, strategyPicker);
        ReportGeneratorService reportGenerator = new ReportGeneratorServiceImpl();
        String report = reportGenerator.generateReport();
        file = new File(FILE_PATH_WRITE);
        StorageWriteService writer = new StorageWriteServiceImpl();
        writer.writeFromDb(report, file);
    }
}

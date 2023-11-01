package core.basesyntax;

import core.basesyntax.service.DataHandlerService;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.ReportWriterService;
import core.basesyntax.service.impl.DataHandlerServiceImpl;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.ReportWriterServiceImpl;
import core.basesyntax.strategy.StorageUpdateHandler;
import core.basesyntax.strategy.impl.FruitBalanceStrategy;
import core.basesyntax.strategy.impl.FruitPurchaseStrategy;
import core.basesyntax.strategy.impl.FruitReturnStrategy;
import core.basesyntax.strategy.impl.FruitSupplyStrategy;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String INPUT_FILE_NAME = "input.csv";
    private static final String REPORT_FILE_NAME = "report.csv";

    public static void main(String[] args) {
        List<StorageUpdateHandler> storageUpdateHandlers = new ArrayList<>();
        storageUpdateHandlers.add(new FruitBalanceStrategy());
        storageUpdateHandlers.add(new FruitSupplyStrategy());
        storageUpdateHandlers.add(new FruitPurchaseStrategy());
        storageUpdateHandlers.add(new FruitReturnStrategy());

        FileReaderService fileReaderService = new FileReaderServiceImpl();
        ReportWriterService reportWriterService = new ReportWriterServiceImpl();
        DataHandlerService dataHandlerService = new DataHandlerServiceImpl(storageUpdateHandlers);
        String inputData = fileReaderService.readInputData(INPUT_FILE_NAME);
        String reportData = dataHandlerService.calculateInputData(inputData);
        reportWriterService.writeReport(reportData, REPORT_FILE_NAME);
    }
}

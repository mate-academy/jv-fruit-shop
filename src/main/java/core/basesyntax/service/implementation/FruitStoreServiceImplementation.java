package core.basesyntax.service.implementation;

import core.basesyntax.service.CreateReportService;
import core.basesyntax.service.FruitStoreService;
import core.basesyntax.service.ReadFromFileService;
import core.basesyntax.service.WriteToFileService;
import core.basesyntax.strategy.OperationStrategy;

public class FruitStoreServiceImplementation implements FruitStoreService {
    private OperationStrategy operationStrategy;
    private ReadFromFileService readFromFileService;
    private CreateReportService createReportService;
    private WriteToFileService writeToFileService;

    public FruitStoreServiceImplementation(OperationStrategy operationStrategy,
                                           ReadFromFileService readFromFileService,
                                           CreateReportService createReportService,
                                           WriteToFileService writeToFileService) {
        this.operationStrategy = operationStrategy;
        this.readFromFileService = readFromFileService;
        this.createReportService = createReportService;
        this.writeToFileService = writeToFileService;
    }

    @Override
    public void createReportFile(String fromFile, String reportFile) {
        String dataFromFile = readFromFileService.readFromFile(fromFile);
        String report = createReportService.createReport(dataFromFile);
        writeToFileService.writeToFile(report, reportFile);
    }
}

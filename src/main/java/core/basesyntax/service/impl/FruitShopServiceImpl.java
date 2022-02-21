package core.basesyntax.service.impl;

import core.basesyntax.service.DataHandler;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.ReportCreateService;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import java.util.List;
import java.util.Map;

public class FruitShopServiceImpl implements FruitShopService {
    private final FileReaderService fileReaderService;
    private final FileWriterService fileWriterService;
    private final OperationStrategy operationStrategy;
    private final DataHandler dataHandler;
    private final ReportCreateService reportCreateService;

    public FruitShopServiceImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationStrategiesMap) {
        this.fileReaderService = new FileReaderServiceCSV();
        this.fileWriterService = new FileWriterServiceImpl();
        this.operationStrategy = new OperationStrategyImpl(operationStrategiesMap);
        this.dataHandler = new FruitDataHandler(operationStrategy);
        this.reportCreateService = new FruitReportCreateService();
    }

    @Override
    public void createReport(String fileNameFrom, String fileNameTo) {
        List<String> dataFromFile = fileReaderService.readFromFile(fileNameFrom);
        dataHandler.processData(dataFromFile);
        String report = reportCreateService.createReport();
        fileWriterService.writeToFile(report, fileNameTo);
    }
}

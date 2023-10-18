package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.impl.DataProcessingServiceImpl;
import core.basesyntax.service.impl.ReaderFromCsv;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.service.impl.WriterToCsv;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import java.util.List;
import java.util.Map;

public class FruitShopService {
    private Reader reader;
    private DataProcessingService dataProcessingService;
    private ReportCreator reportCreator;
    private Writer writer;

    public FruitShopService(Map<FruitTransaction.Operation, OperationHandler> map) {
        this.reader = new ReaderFromCsv();
        this.dataProcessingService = new DataProcessingServiceImpl(new OperationStrategyImpl(map));
        this.reportCreator = new ReportCreatorImpl();
        this.writer = new WriterToCsv();
    }

    public void createDailyReport(String fileFrom, String fileTo) {
        List<String> dataFromFile = reader.readData(fileFrom);
        dataProcessingService.processTransaction(dataFromFile);
        String report = reportCreator.createReport();
        writer.writeToReport(report, fileTo);
    }
}

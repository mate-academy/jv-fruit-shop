package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataProcessing;
import core.basesyntax.service.DataReader;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.Writer;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import java.util.List;
import java.util.Map;

public class FruitShopServiceImpl {
    private DataReader dataReader;
    private DataProcessing dataProcessing;
    private ReportCreator reportCreator;
    private Writer writer;

    public FruitShopServiceImpl(Map<FruitTransaction.Operation, OperationHandler> map) {
        dataReader = new DataReaderFromCsv();
        dataProcessing = new DataProcessingImpl(new OperationStrategyImpl(map));
        reportCreator = new ReportCreatorImpl();
        writer = new CsvWriter();
    }

    public void createDailyReport(String fromFile, String toFile) {
        List<String> dataFromFile = dataReader.readData(fromFile);
        dataProcessing.processTransaction(dataFromFile);
        String report = reportCreator.createReport();
        writer.writeReportToFile(report, toFile);
    }

}

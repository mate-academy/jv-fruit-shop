package core.basesyntax.service.impl;

import core.basesyntax.service.DataProcessing;
import core.basesyntax.service.DataReader;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.Writer;
import java.util.List;

public class FruitShopServiceImpl {
    private final DataReader dataReader;
    private final DataProcessing dataProcessing;
    private final ReportCreator reportCreator;
    private final Writer writer;

    public FruitShopServiceImpl(DataReader dataReader, DataProcessing dataProcessing,
                                ReportCreator reportCreator, Writer writer) {
        this.dataReader = dataReader;
        this.dataProcessing = dataProcessing;
        this.reportCreator = reportCreator;
        this.writer = writer;
    }

    public void createDailyReport(String fromFile, String toFile) {
        List<String> dataFromFile = dataReader.readData(fromFile);
        dataProcessing.processTransaction(dataFromFile);
        String report = reportCreator.createReport();
        writer.writeReportToFile(report, toFile);
    }

}

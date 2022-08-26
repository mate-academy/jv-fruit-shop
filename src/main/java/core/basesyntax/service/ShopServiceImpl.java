package core.basesyntax.service;

import core.basesyntax.FruitTransaction;
import core.basesyntax.lib.Inject;
import core.basesyntax.parse.DataParser;
import core.basesyntax.process.ProcessData;
import core.basesyntax.readdata.DataReader;
import core.basesyntax.report.ReportData;
import core.basesyntax.writedata.DataWriter;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    @Inject
    private DataReader dataReading;
    @Inject
    private ProcessData processData;
    @Inject
    private DataWriter dataWriting;
    @Inject
    private DataParser dataParser;
    @Inject
    private ReportData reportData;

    @Override
    public void servicing(String fileStartDay, String fileReport) {
        List<String> lines = dataReading.readData(fileStartDay);
        List<FruitTransaction> parsedData = dataParser.parse(lines);
        Map<String, Integer> values = processData.processingData(parsedData);
        String dataReport = reportData.createDataReport(values);
        dataWriting.writeData(fileReport, dataReport);
    }
}

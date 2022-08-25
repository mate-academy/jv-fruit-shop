package core.basesyntax.service;

import core.basesyntax.FruitTransaction;
import core.basesyntax.parse.DataParser;
import core.basesyntax.parse.DataParserImpl;
import core.basesyntax.process.ProcessData;
import core.basesyntax.process.ProcessDataImpl;
import core.basesyntax.readdata.DataReader;
import core.basesyntax.readdata.DataReaderImpl;
import core.basesyntax.report.ReportData;
import core.basesyntax.report.ReportDataImpl;
import core.basesyntax.writedata.DataWriting;
import core.basesyntax.writedata.DataWritingImpl;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private DataReader dataReading;
    private ProcessData processData;
    private DataWriting dataWriting;
    private DataParser dataParser;
    private ReportData reportData;

    public ShopServiceImpl(ReportDataImpl reportData, DataParserImpl dataParser,
                           DataReaderImpl dataReading, ProcessDataImpl processData,
                           DataWritingImpl dataWriting) {
        this.dataReading = dataReading;
        this.processData = processData;
        this.dataWriting = dataWriting;
        this.dataParser = dataParser;
        this.reportData = reportData;
    }

    @Override
    public void servicing(String fileStartDay, String fileReport) {
        List<String> lines = dataReading.readData(fileStartDay);
        List<FruitTransaction> parsedData = dataParser.parse(lines);
        Map<String, Integer> values = processData.processingData(parsedData);
        String dataReport = reportData.createDataReport(values);
        dataWriting.writeData(fileReport, dataReport);
    }
}

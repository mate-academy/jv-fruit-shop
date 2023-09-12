package core.basesyntax;

import core.basesyntax.file.reader.CsvFileReader;
import core.basesyntax.file.reader.CsvFileReaderImpl;
import core.basesyntax.file.writer.CsvFileWriter;
import core.basesyntax.file.writer.CsvFileWriterImpl;
import core.basesyntax.operationstrategy.operation.BalanceOperationHandler;
import core.basesyntax.operationstrategy.operation.OperationHandler;
import core.basesyntax.operationstrategy.operation.OperationType;
import core.basesyntax.operationstrategy.operation.PurchaseOperationHandler;
import core.basesyntax.operationstrategy.operation.ReturnOperationHandler;
import core.basesyntax.operationstrategy.operation.SupplyOperationHandler;
import core.basesyntax.processdata.DataProcessor;
import core.basesyntax.processdata.DataProcessorImpl;
import core.basesyntax.processdata.convertdata.DataConverter;
import core.basesyntax.processdata.convertdata.DataConverterImpl;
import core.basesyntax.processdata.createreport.ReportCreator;
import core.basesyntax.processdata.createreport.ReportCreatorImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_PATH = "report.csv";
    private static final String TODAY_REPORT_PATH = "todayReport.csv";
    private static final Map<OperationType, OperationHandler> OPERATION_HANDLER_MAP;

    static {
        OPERATION_HANDLER_MAP = new HashMap<>();
        OPERATION_HANDLER_MAP.put(OperationType.B, new BalanceOperationHandler());
        OPERATION_HANDLER_MAP.put(OperationType.S, new SupplyOperationHandler());
        OPERATION_HANDLER_MAP.put(OperationType.P, new PurchaseOperationHandler());
        OPERATION_HANDLER_MAP.put(OperationType.R, new ReturnOperationHandler());
    }

    public static void main(String[] args) {
        CsvFileReader fileReader = new CsvFileReaderImpl();
        DataProcessor dataProcessor = new DataProcessorImpl(OPERATION_HANDLER_MAP);
        DataConverter dataConverter = new DataConverterImpl();
        ReportCreator createReportCreator = new ReportCreatorImpl();
        CsvFileWriter fileWriter = new CsvFileWriterImpl();

        List<String> data = fileReader.readDataFromFile(FILE_PATH);
        List<List<String>> convertedData = dataConverter.convertData(data);
        dataProcessor.process(convertedData);
        String report = createReportCreator.createReport();
        fileWriter.writeDataToFile(TODAY_REPORT_PATH, report);
    }
}

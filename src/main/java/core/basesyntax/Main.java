package core.basesyntax;

import core.basesyntax.service.reader.CsvFileReader;
import core.basesyntax.service.impl.CsvFileReaderImpl;
import core.basesyntax.service.writer.CsvFileWriter;
import core.basesyntax.service.impl.CsvFileWriterImpl;
import core.basesyntax.strategy.operation.BalanceOperationHandler;
import core.basesyntax.strategy.operation.OperationHandler;
import core.basesyntax.strategy.operation.OperationType;
import core.basesyntax.strategy.operation.PurchaseOperationHandler;
import core.basesyntax.strategy.operation.ReturnOperationHandler;
import core.basesyntax.strategy.operation.SupplyOperationHandler;
import core.basesyntax.service.processor.DataProcessor;
import core.basesyntax.service.impl.DataProcessorImpl;
import core.basesyntax.service.converter.DataConverter;
import core.basesyntax.service.impl.DataConverterImpl;
import core.basesyntax.service.reportcreator.ReportCreator;
import core.basesyntax.service.impl.ReportCreatorImpl;
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

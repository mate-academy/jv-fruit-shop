package core.basesyntax;

import core.basesyntax.file.reader.CsvFileReader;
import core.basesyntax.file.reader.CsvFileReaderImpl;
import core.basesyntax.file.writer.CsvFileWriter;
import core.basesyntax.file.writer.CsvFileWriterImpl;
import core.basesyntax.operationstrategy.operation.BalanceOperationHandler;
import core.basesyntax.operationstrategy.operation.OperationHandler;
import core.basesyntax.operationstrategy.operation.PurchaseOperationHandler;
import core.basesyntax.operationstrategy.operation.ReturnOperationHandler;
import core.basesyntax.operationstrategy.operation.SupplyOperationHandler;
import core.basesyntax.processdata.ProcessData;
import core.basesyntax.processdata.ProcessDataImpl;
import core.basesyntax.processdata.convertdata.ConvertData;
import core.basesyntax.processdata.convertdata.ConvertDataImpl;
import core.basesyntax.processdata.createreport.Report;
import core.basesyntax.processdata.createreport.ReportImpl;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    private static final CsvFileReader FILE_READER;
    private static final ProcessData PROCESS_DATA;
    private static final ConvertData CONVERT_DATA;
    private static final Report CREATE_REPORT;
    private static final CsvFileWriter FILE_WRITER;
    private static final String FILE_PATH = "report.csv";
    private static final String TODAY_REPORT_PATH = "todayReport.csv";
    private static final Map<Character, OperationHandler> OPERATION_HANDLER_MAP;

    static {
        FILE_READER = new CsvFileReaderImpl();
        OPERATION_HANDLER_MAP = new HashMap<>();
        OPERATION_HANDLER_MAP.put('b', new BalanceOperationHandler());
        OPERATION_HANDLER_MAP.put('s', new SupplyOperationHandler());
        OPERATION_HANDLER_MAP.put('p', new PurchaseOperationHandler());
        OPERATION_HANDLER_MAP.put('r', new ReturnOperationHandler());
        PROCESS_DATA = new ProcessDataImpl(OPERATION_HANDLER_MAP);
        CONVERT_DATA = new ConvertDataImpl();
        CREATE_REPORT = new ReportImpl();
        FILE_WRITER = new CsvFileWriterImpl();
    }

    public static void main(String[] args) {
        List<String> data = FILE_READER.readDataFromFile(FILE_PATH);
        List<List<String>> convertData = CONVERT_DATA.convertData(data);
        Map<String, Integer> stock = PROCESS_DATA.process(convertData);
        List<String> report = CREATE_REPORT.createReport(stock);
        File todayReport = new File(TODAY_REPORT_PATH);
        try {
            todayReport.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Cannot create file " + TODAY_REPORT_PATH, e);
        }
        FILE_WRITER.writeDataToFile(todayReport, report);
    }
}

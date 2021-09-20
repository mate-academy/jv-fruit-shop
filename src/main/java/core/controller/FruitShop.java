package core.controller;

import core.model.Storage;
import core.service.oparation.OperationHandler;
import core.service.reader.ReaderService;
import core.service.reader.ReaderServiceImpl;
import core.service.report.ReportGenerator;
import core.service.report.ReportGeneratorImpl;
import core.service.writer.ReportWriter;
import core.service.writer.ReportWriterImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitShop {
    public static final Storage STORAGE;
    private static final String INPUT_FILE_CSV = "src/main/resources/inputFile.csv";
    private static final String REPORT_FILE_CSV = "src/main/resources/reportFile.csv";

    static {
        STORAGE = new Storage(new HashMap<>());
    }

    private ReaderService readerService;
    private ReportGenerator reportGenerator;
    private ReportWriter reportWriter;
    private Map<String, OperationHandler> operationHandlersMap;

    public FruitShop(Map<String, OperationHandler> operationHandlersMap) {
        readerService = new ReaderServiceImpl();
        reportWriter = new ReportWriterImpl();
        this.operationHandlersMap = operationHandlersMap;
        reportGenerator = new ReportGeneratorImpl(this.operationHandlersMap);
    }

    public void writeReport() {
        List<String> listFromInputFile = readerService.read(INPUT_FILE_CSV);
        List<String> report = reportGenerator.createReport(listFromInputFile);
        reportWriter.write(report, REPORT_FILE_CSV);
    }
}

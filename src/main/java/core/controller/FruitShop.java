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
    private String inputFileCsv;
    private String reportFileCsv;

    static {
        STORAGE = new Storage(new HashMap<>());
    }

    private ReaderService readerService;
    private ReportGenerator reportGenerator;
    private ReportWriter reportWriter;
    private Map<String, OperationHandler> operationHandlersMap;

    public FruitShop(Map<String, OperationHandler> operationHandlersMap,
                     String inputFileCsv,
                     String reportFileCsv) {
        readerService = new ReaderServiceImpl();
        reportWriter = new ReportWriterImpl();
        this.operationHandlersMap = operationHandlersMap;
        reportGenerator = new ReportGeneratorImpl(this.operationHandlersMap);
        this.inputFileCsv = inputFileCsv;
        this.reportFileCsv = reportFileCsv;
    }

    public void writeReport() {
        List<String> listFromInputFile = readerService.read(inputFileCsv);
        List<String> report = reportGenerator.createReport(listFromInputFile);
        reportWriter.write(report, reportFileCsv);
    }
}

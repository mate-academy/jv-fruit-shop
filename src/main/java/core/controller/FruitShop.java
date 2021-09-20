package core.controller;

import core.model.Fruit;
import core.model.MyConstants;
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
    public static final Fruit BANANA;
    public static final Fruit APPLE;
    public static final Map<String, Fruit> FRUITS;

    static {
        BANANA = new Fruit(MyConstants.BANANA);
        APPLE = new Fruit(MyConstants.APPLE);
        FRUITS = new HashMap<>();
        FRUITS.put(BANANA.getName(), BANANA);
        FRUITS.put(APPLE.getName(), APPLE);
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
        List<String> listFromInputFile = readerService.read(MyConstants.INPUT_FILE_CSV);
        List<String> report = reportGenerator.createReport(listFromInputFile);
        reportWriter.write(report, MyConstants.REPORT_FILE_CSV);
    }
}

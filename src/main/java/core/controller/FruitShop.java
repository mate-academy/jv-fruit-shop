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
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FruitShop {
    private Fruit banana;
    private Fruit apple;
    private Set<Fruit> fruits;
    private ReaderService readerService;
    private ReportGenerator reportGenerator;
    private ReportWriter reportWriter;
    private Map<String, OperationHandler> operationHandlersMap;

    public FruitShop(Map<String, OperationHandler> operationHandlersMap) {
        banana = new Fruit(MyConstants.BANANA);
        apple = new Fruit(MyConstants.APPLE);
        fruits = new HashSet<>();
        fruits.add(banana);
        fruits.add(apple);
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

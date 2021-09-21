package core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import operation.AdditionHandler;
import operation.DecreaseHandler;
import operation.OperationHandler;
import operation.OperationStrategy;
import operation.OperationStrategyImpl;
import service.ReaderServiceImpl;
import service.RecordParser;
import service.RecordParserImpl;
import service.ReportCreator;
import service.ReportCreatorImpl;
import service.WriterService;
import service.WriterServiceImpl;

public class Main {
    private static final String INPUT_PATH = "src/main/resources/input.csv";
    private static final String REPORT_PATH = "src/main/resources/report.csv";
    private static final String BALANCE = "b";
    private static final String SUPPLY = "s";
    private static final String PURCHASE = "p";
    private static final String RETURN = "r";

    public static void main(String[] args) {
        List<String> fileData = new ReaderServiceImpl().readFromFile(INPUT_PATH);
        RecordParser recordParser = new RecordParserImpl();
        recordParser.parseRecords(fileData);
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(BALANCE, new AdditionHandler());
        operationHandlerMap.put(SUPPLY, new AdditionHandler());
        operationHandlerMap.put(PURCHASE, new DecreaseHandler());
        operationHandlerMap.put(RETURN, new AdditionHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        ReportCreator reportCreator = new ReportCreatorImpl(operationStrategy);
        List<String> newReport = reportCreator.createNewReport();
        WriterService writerService = new WriterServiceImpl();
        writerService.writeReportToCsv(newReport, REPORT_PATH);
    }
}

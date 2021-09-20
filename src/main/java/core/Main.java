package core;

import dao.RecordDao;
import database.Database;
import model.Record;
import operation.*;
import report.Report;
import service.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_PATH = "src/main/resources/input.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put("b", new AdditionHandler());
        operationHandlerMap.put("s", new AdditionHandler());
        operationHandlerMap.put("p", new DecreaseHandler());
        operationHandlerMap.put("r", new AdditionHandler());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        List<String> fileData = new ReaderServiceImpl().readFromFile(FILE_PATH);
        RecordParser recordParser = new RecordParserImpl();
        recordParser.parseRecords(fileData);
        ReportCreator reportCreator = new ReportCreatorImpl(operationStrategy);
        System.out.println(reportCreator.createNewReport());
    }
}

package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import service.FileService;
import service.ReportService;
import service.StoreActivities;
import service.Strategy;
import service.Validator;
import service.impl.Balance;
import service.impl.Fruit;
import service.impl.OsFileServiceImpl;
import service.impl.Purchase;
import service.impl.ReportServiceImpl;
import service.impl.Return;
import service.impl.StrategyImpl;
import service.impl.Supply;
import service.impl.TransactionDataImpl;
import service.impl.ValidatorImpl;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/inputFile";
    private static final String REPORT_FILE_PATH = "src/main/resources/reportFile";

    public static void main(String[] args) {
        Map<String, StoreActivities> stringActivitiesMap = new HashMap<>();
        stringActivitiesMap.put("b", new Balance());
        stringActivitiesMap.put("p", new Purchase());
        stringActivitiesMap.put("r", new Return());
        stringActivitiesMap.put("s", new Supply());

        FileService fileService = new OsFileServiceImpl();
        Strategy strategy = new StrategyImpl(stringActivitiesMap);
        Validator validation = new ValidatorImpl();
        List<String> inputValues = fileService.readFromFile(INPUT_FILE_PATH);
        Map<Fruit, Integer> report = new HashMap<>();
        service.TransactionData transactionData = new TransactionDataImpl(validation, strategy);
        transactionData.parseDataToMap(inputValues, report);
        ReportService valueReport = new ReportServiceImpl();
        fileService.writeToReportFile(valueReport.getReport(report), REPORT_FILE_PATH);
    }
}

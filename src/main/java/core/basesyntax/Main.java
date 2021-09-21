package core.basesyntax;

import java.util.HashMap;
import java.util.Map;
import service.FileService;
import service.StoreActivities;
import service.Strategy;
import service.Validator;
import service.ValueReport;
import service.impl.Balance;
import service.impl.OsFileServiceImpl;
import service.impl.Purchase;
import service.impl.Return;
import service.impl.StrategyImpl;
import service.impl.Supply;
import service.impl.ValidateImpl;
import service.impl.ValueReportImpl;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/inputFile";
    private static final String REPORT_FILE_PATH = "src/main/resources/reportFile";

    public static void main(String[] args) {
        Map<String, StoreActivities> stringActivitiesMap = new HashMap<>();
        stringActivitiesMap.put("b", new Balance());
        stringActivitiesMap.put("p", new Purchase());
        stringActivitiesMap.put("r", new Return());
        stringActivitiesMap.put("s", new Supply());
        FileService fileDao = new OsFileServiceImpl();
        Strategy strategy = new StrategyImpl(stringActivitiesMap);
        Validator validation = new ValidateImpl();
        ValueReport valueReport = new ValueReportImpl(fileDao, strategy, validation);
        valueReport.getReport(INPUT_FILE_PATH, REPORT_FILE_PATH);
    }
}

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import service.FileReaderImpl;
import service.FileWriter;
import service.FileWriterImpl;
import service.RecordTransformer;
import service.RecordTransformerImpl;
import service.ReportCreator;
import service.ReportCreatorImpl;
import strategy.ActivityStrategy;
import strategy.ActivityStrategyImpl;
import strategy.activity.ActivityHandler;
import strategy.activity.ActivityHandlerAddImpl;
import strategy.activity.ActivityHandlerSubstractionImpl;

public class Main {
    private static final String FILE_NAME_FROM = "src/main/java/resources/inputData.csv";
    private static final String FILE_NAME_TO = "src/main/java/resources/reportData.csv";
    private static final String BALANCE = "b";
    private static final String SUPPLY = "s";
    private static final String PURCHASE = "p";
    private static final String RETURN = "r";
    private static final int TITLE_INDEX = 0;

    public static void main(String[] args) {
        List<String> fileData = new FileReaderImpl().read(FILE_NAME_FROM);
        fileData.remove(TITLE_INDEX);
        RecordTransformer recordTransformer = new RecordTransformerImpl();
        recordTransformer.transform(fileData);
        Map<String, ActivityHandler> activityHandlerMap = new HashMap<>();
        activityHandlerMap.put(BALANCE, new ActivityHandlerAddImpl());
        activityHandlerMap.put(SUPPLY, new ActivityHandlerAddImpl());
        activityHandlerMap.put(PURCHASE, new ActivityHandlerSubstractionImpl());
        activityHandlerMap.put(RETURN, new ActivityHandlerAddImpl());
        ActivityStrategy activityStrategy = new ActivityStrategyImpl(activityHandlerMap);
        ReportCreator reportCreator = new ReportCreatorImpl(activityStrategy);
        List<String> newReport = reportCreator.createReport();
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.write(newReport, FILE_NAME_TO);
    }
}

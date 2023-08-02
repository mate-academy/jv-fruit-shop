package core.basesyntax;

import core.basesyntax.service.ActivitiesProcessor;
import core.basesyntax.service.ActivityStrategy;
import core.basesyntax.service.FileProcessor;
import core.basesyntax.service.FileService;
import core.basesyntax.service.ReportGenerator;

public class FruitShopHW {
    private static final String FILE_NAME = "activities.csv";
    private static final String REPORT_NAME = "report.csv";
    private static final FileService fileService = new FileService();
    private static final FileProcessor fileProcessor = new FileProcessor(fileService);
    //todo maybe HashMap should be created in main not in ActivityStrategy
    private static final ActivityStrategy activityStrategy = new ActivityStrategy();
    private static final ActivitiesProcessor activitiesProcessor =
            new ActivitiesProcessor(activityStrategy);
    private static final ReportGenerator reportGenerator = new ReportGenerator();

    public static void main(String[] args) {
        fileProcessor.processFile(FILE_NAME);
        activitiesProcessor.processActivities();
        fileService.writeTextToFile(REPORT_NAME, reportGenerator.generateReport());
    }
}

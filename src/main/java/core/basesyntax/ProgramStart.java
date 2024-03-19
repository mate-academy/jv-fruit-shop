package core.basesyntax;

import core.basesyntax.service.strategy.ActivityStrategy;
import core.basesyntax.utility.FileServiceImpl;
import core.basesyntax.utility.FruitDataParserImpl;
import core.basesyntax.utility.FruitTransaction;
import core.basesyntax.utility.ReportServiceImpl;
import core.basesyntax.utility.service.FileService;
import core.basesyntax.utility.service.ReportService;
import java.util.List;

public class ProgramStart {
    private static final String REPORT_FILE = "src/main/resources/report.csv";
    private static final String DATA_FILE = "src/main/resources/input.csv";

    public static void main(String[] args) {
        FileService fileService = new FileServiceImpl();
        List<FruitTransaction> fruitTransactions = new FruitDataParserImpl()
                .parseData(fileService.readFromFile(DATA_FILE));

        ActivityStrategy activityStrategy = new ActivityStrategy();
        for (var element : fruitTransactions) {
            activityStrategy.getActivityService(element.getOperation()).execute(element);
        }
        ReportService reportService = new ReportServiceImpl();
        fileService.writeToFile(REPORT_FILE, reportService.createReport());
    }
}

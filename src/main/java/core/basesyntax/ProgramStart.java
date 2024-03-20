package core.basesyntax;

import core.basesyntax.service.strategy.ActivityService;
import core.basesyntax.service.strategy.ActivityStrategy;
import core.basesyntax.service.strategy.impl.BalanceService;
import core.basesyntax.service.strategy.impl.PurchaseService;
import core.basesyntax.service.strategy.impl.ReturnService;
import core.basesyntax.service.strategy.impl.SupplyService;
import core.basesyntax.utility.FileServiceImpl;
import core.basesyntax.utility.FruitDataParserImpl;
import core.basesyntax.utility.FruitTransaction;
import core.basesyntax.utility.ReportServiceImpl;
import core.basesyntax.utility.service.FileService;
import core.basesyntax.utility.service.ReportService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProgramStart {
    private static final String REPORT_FILE = "src/main/resources/report.csv";
    private static final String DATA_FILE = "src/main/resources/input.csv";

    public static void main(String[] args) {

        Map<String, ActivityService> services = new HashMap<>();
        services.put("b", new BalanceService());
        services.put("s", new SupplyService());
        services.put("r", new ReturnService());
        services.put("p", new PurchaseService());

        FileService fileService = new FileServiceImpl();
        List<FruitTransaction> fruitTransactions = new FruitDataParserImpl()
                .parseData(fileService.readFromFile(DATA_FILE));

        ActivityStrategy activityStrategy = new ActivityStrategy(services);
        for (var element : fruitTransactions) {
            activityStrategy.getActivityService(element.getOperation()).execute(element);
        }
        ReportService reportService = new ReportServiceImpl();
        fileService.writeToFile(REPORT_FILE, reportService.createReport());
    }
}

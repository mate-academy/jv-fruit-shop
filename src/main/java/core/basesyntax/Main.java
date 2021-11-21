package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitServiceImpl;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReaderServiceImpl;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ReportServiceImpl;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.StorageServiceImpl;
import core.basesyntax.service.Validator;
import core.basesyntax.strategy.ActivityService;
import core.basesyntax.strategy.ActivityStrategy;
import core.basesyntax.strategy.impl.BalanceService;
import core.basesyntax.strategy.impl.PurchaseService;
import core.basesyntax.strategy.impl.ReturnService;
import core.basesyntax.strategy.impl.SupplyService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        ReaderService readerService = new ReaderServiceImpl();
        List<String> strings = readerService.readFromFile("src/main/resources/dayActivity.csv");
        strings.remove(0);

        FruitDao fruitDao = new FruitDaoImpl();
        FruitService fruitService = new FruitServiceImpl();

        Map<String, ActivityService> activityHandlerMap = new HashMap<>();
        activityHandlerMap.put("b", new BalanceService());
        activityHandlerMap.put("s", new SupplyService());
        activityHandlerMap.put("p", new PurchaseService());
        activityHandlerMap.put("r", new ReturnService());

        ActivityStrategy activityStrategy = new ActivityStrategy(activityHandlerMap);
        StorageService storageService =
                new StorageServiceImpl(activityStrategy, fruitService, fruitDao);

        Validator validator = new Validator();
        strings.stream()
                .map(String::trim)
                .forEach(str -> {
                    if (validator.validateRow(str)) {
                        storageService.releaseActivity(str);
                    }
                });

        ReportService reportService = new ReportServiceImpl();
        String reportData = reportService.getReportText();
        String reportFileName = "src/main/resources/report.csv";
        reportService.writeReport(reportData, reportFileName);

    }
}

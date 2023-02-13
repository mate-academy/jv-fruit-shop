package core.basesyntax;

import dao.DaoReader;
import dao.DaoReaderImpl;
import dao.DaoWriter;
import dao.DaoWriterImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitRecord;
import service.ActivityStrategy;
import service.ActivityStrategyImpl;
import service.FruitService;
import service.FruitServiceImpl;
import service.ParsingService;
import service.ParsingServiceImpl;
import service.ReportService;
import service.ReportServiceImpl;
import service.activity.ActivityHandler;
import service.activity.BalanceHandler;
import service.activity.PurchaseHandler;
import service.activity.SupplyHandler;

public class Main {
    public static void main(String[] args) {
        Map<String, ActivityHandler> activityHandlersMap = new HashMap<>();

        activityHandlersMap.put("b", new BalanceHandler());
        activityHandlersMap.put("p", new PurchaseHandler());
        SupplyHandler supplyHandler = new SupplyHandler();
        activityHandlersMap.put("s", supplyHandler);
        activityHandlersMap.put("r", supplyHandler);

        DaoReader daoReader = new DaoReaderImpl();
        List<String> rawData = daoReader.get("src/main/resources/basic_data.txt");

        ParsingService parsingService = new ParsingServiceImpl();
        List<FruitRecord> fruitRecordList = parsingService.parse(rawData);

        ActivityStrategy activityStrategy = new ActivityStrategyImpl(activityHandlersMap);
        FruitService fruitService = new FruitServiceImpl();
        Map<String, Integer> report = fruitService.getReport(fruitRecordList, activityStrategy);

        ReportService reportService = new ReportServiceImpl();
        List<String> stringReport = reportService.makeReport(report);

        DaoWriter daoWriter = new DaoWriterImpl();
        daoWriter.write(stringReport,"src/main/resources/report.txt");
    }
}

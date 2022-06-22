package core.basesyntax;

import dao.DaoReader;
import dao.DaoReaderImpl;
import dao.DaoWriter;
import dao.DaoWriterImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitRecord;
import service.impl.ActivityStrategy;
import service.impl.ActivityStrategyImpl;
import service.impl.FruitService;
import service.impl.FruitServiceImpl;
import service.impl.ParsingService;
import service.impl.ParsingServiceImpl;
import service.impl.ReportService;
import service.impl.ReportServiceImpl;
import service.impl.activity.ActivityHandler;
import service.impl.activity.BalanceHandler;
import service.impl.activity.PurchaseHandler;
import service.impl.activity.SupplyHandler;

public class Main {

    public static void main(String[] args) {
        Map<String, ActivityHandler> activityHandlerMap = new HashMap<>();

        activityHandlerMap.put("b", new BalanceHandler());
        activityHandlerMap.put("p", new PurchaseHandler());
        SupplyHandler supplyHandler = new SupplyHandler();
        activityHandlerMap.put("s", supplyHandler);
        activityHandlerMap.put("r", supplyHandler);
        DaoReader daoReader = new DaoReaderImpl();
        List<String> rawData = daoReader.get("src/main/resources/basic_data.csv");
        ParsingService parsingService = new ParsingServiceImpl();
        List<FruitRecord> fruitRecordList = parsingService.parse(rawData);
        ActivityStrategy activityStrategy = new ActivityStrategyImpl(activityHandlerMap);
        FruitService fruitService = new FruitServiceImpl();
        Map<String, Integer> report = fruitService.getReport(fruitRecordList, activityStrategy);
        ReportService reportService = new ReportServiceImpl();
        List<String> stringReport = reportService.makeReport(report);
        DaoWriter daoWriter = new DaoWriterImpl();
        daoWriter.write(stringReport, "src/main/resources/report.csv");
    }
}

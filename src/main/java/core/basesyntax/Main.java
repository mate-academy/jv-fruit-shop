package core.basesyntax;

import dao.FruitStorageDao;
import dao.impl.FruitStorageDaoImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import service.CreatReport;
import service.ReadFromFile;
import service.WriteToDB;
import service.WriteToFile;
import service.impl.ReadFromFileImpl;
import service.impl.ReportCreator;
import service.impl.WriteToDbFromList;
import service.impl.WriteToFileImpl;
import strategy.DoActivities;
import strategy.strategy.impl.BalanceReadActivity;
import strategy.strategy.impl.PurchaseActivity;
import strategy.strategy.impl.ReturnActivity;
import strategy.strategy.impl.SupplyActivity;

public class Main {
    private static final String SPLITTER = ",";
    private static final String DATA_FILE = "src/main/resources/file.txt";
    private static final String REPORT_FILE = "src/main/resources/report.txt";
    private static final String BALANCE = "b";
    private static final String SUPPLY = "s";
    private static final String PURCHASE = "p";
    private static final String RETURN = "r";

    public static void main(String[] args) {
        FruitStorageDao storageDao = new FruitStorageDaoImpl();
        Map<String, DoActivities> strategyMap = new HashMap<>();
        strategyMap.put(BALANCE, new BalanceReadActivity(storageDao));
        strategyMap.put(SUPPLY, new SupplyActivity(storageDao));
        strategyMap.put(PURCHASE, new PurchaseActivity(storageDao));
        strategyMap.put(RETURN, new ReturnActivity(storageDao));
        ReadFromFile reader = new ReadFromFileImpl();
        List<String> activities = reader.readFormFile(DATA_FILE);
        WriteToDB activityWriter = new WriteToDbFromList(SPLITTER);
        activityWriter.writeToDB(activities, strategyMap);
        CreatReport reporter = new ReportCreator(storageDao);
        List<String> report = reporter.creatReport();
        WriteToFile writer = new WriteToFileImpl();
        writer.writeToFile(REPORT_FILE, report);
    }
}

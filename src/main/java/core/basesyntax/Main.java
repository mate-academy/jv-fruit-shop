package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
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
import strategy.strategy.strategy.impl.BalaceReadActivity;
import strategy.strategy.strategy.impl.PurchaseActivity;
import strategy.strategy.strategy.impl.ReturnActivity;
import strategy.strategy.strategy.impl.SupplyActivity;

public class Main {
    private static final String SPLITTER = ",";
    private static final String DATA_FILE = "src/main/resources/file.txt";
    private static final String REPORT_FILE = "src/main/resources/report.txt";
    private static final String BALANCE = "b";
    private static final String SUPPLY = "s";
    private static final String PURCHASE = "p";
    private static final String RETURN = "r";

    public static void main(String[] args) {
        try {
            Path path = Path.of(DATA_FILE);
            Files.writeString(path,"type,fruit,quantity" + System.lineSeparator());
            Files.writeString(path, "b,banana,20" + System.lineSeparator(),
                    StandardOpenOption.APPEND);
            Files.writeString(path, "b,apple,100" + System.lineSeparator(),
                    StandardOpenOption.APPEND);
            Files.writeString(path,"s,banana,100" + System.lineSeparator(),
                    StandardOpenOption.APPEND);
            Files.writeString(path,"p,banana,13" + System.lineSeparator(),
                    StandardOpenOption.APPEND);
            Files.writeString(path,"r,apple,10" + System.lineSeparator(),
                    StandardOpenOption.APPEND);
            Files.writeString(path,"p,apple,20" + System.lineSeparator(),
                    StandardOpenOption.APPEND);
            Files.writeString(path,"p,banana,5" + System.lineSeparator(),
                    StandardOpenOption.APPEND);
            Files.writeString(path,"s,banana,50" + System.lineSeparator(),
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Map<String, DoActivities> strategyMap = new HashMap<>();
        strategyMap.put(BALANCE, new BalaceReadActivity());
        strategyMap.put(SUPPLY, new SupplyActivity());
        strategyMap.put(PURCHASE, new PurchaseActivity());
        strategyMap.put(RETURN, new ReturnActivity());
        ReadFromFile reader = new ReadFromFileImpl();
        List<String> activities = reader.readFormFile(DATA_FILE);
        WriteToDB activityWriter = new WriteToDbFromList(SPLITTER);
        activityWriter.writeToDB(activities, strategyMap);
        CreatReport reporter = new ReportCreator();
        List<String> report = reporter.creatReport();
        WriteToFile writer = new WriteToFileImpl();
        writer.writeToFile(REPORT_FILE, report);

    }
}

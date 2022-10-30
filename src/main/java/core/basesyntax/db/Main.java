package core.basesyntax.db;

import service.ConvertData;
import service.ReadFromFile;
import service.WriteToFile;
import service.impl.ConvertDataFromList;
import service.impl.ReadFromFileImpl;
import service.impl.WriteToFileImpl;
import service.strategy_of_activities.StrategyOfActivities;
import service.strategy_of_activities.strategyImpl.StrategyOfActivitiesImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String splitter = ",";
        String dataFile = "src/main/resources/file.txt";
        String reportFile = "src/main/resources/file.txt";
        ConvertData converter = new ConvertDataFromList(splitter);
        ReadFromFile reader = new ReadFromFileImpl();
        StrategyOfActivities strategy = new StrategyOfActivitiesImpl();
        reader.readFormFile(dataFile).stream()
               .map(converter::converteData)
               .forEachOrdered(s -> strategy.rightActivity(s[0]).doActivity(s[1], Integer.parseInt(s[2])));
        WriteToFile writer = new WriteToFileImpl();
        writer.writeToFile(reportFile, splitter);
    }
}

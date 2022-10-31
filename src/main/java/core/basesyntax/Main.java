package core.basesyntax;

import service.ConvertData;
import service.ReadFromFile;
import service.WriteToFile;
import service.impl.ConvertDataFromList;
import service.impl.ReadFromFileImpl;
import service.impl.WriteToFileImpl;
import service.strategy_of_activities.StrategyOfActivities;
import service.strategy_of_activities.strategyImpl.StrategyOfActivitiesImpl;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {
    public static void main(String[] args) {
        String splitter = ",";
        String dataFile = "src/main/resources/file.txt";
        try {
            Files.writeString(Paths.get(dataFile),"type,fruit,quantity" + System.lineSeparator());
            Files.writeString(Paths.get(dataFile), "b,banana,20" + System.lineSeparator()
                    , StandardOpenOption.APPEND);
            Files.writeString(Paths.get(dataFile), "b,apple,100" + System.lineSeparator(),
                    StandardOpenOption.APPEND);
            Files.writeString(Paths.get(dataFile),"s,banana,100" + System.lineSeparator(),
                    StandardOpenOption.APPEND);
            Files.writeString(Paths.get(dataFile),"p,banana,13" + System.lineSeparator(),
                    StandardOpenOption.APPEND);
            Files.writeString(Paths.get(dataFile),"r,apple,10" + System.lineSeparator(),
                    StandardOpenOption.APPEND);
            Files.writeString(Paths.get(dataFile),"p,apple,20" + System.lineSeparator(),
                    StandardOpenOption.APPEND);
            Files.writeString(Paths.get(dataFile),"p,banana,5" + System.lineSeparator(),
                    StandardOpenOption.APPEND);
            Files.writeString(Paths.get(dataFile),"s,banana,50" + System.lineSeparator(),
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String reportFile = "src/main/resources/report.txt";
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

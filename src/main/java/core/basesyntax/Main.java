package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import service.ConvertData;
import service.ReadFromFile;
import service.WriteToFile;
import service.activity.strategy.StrategyOfActivities;
import service.activity.strategy.strategy.impl.StrategyOfActivitiesImpl;
import service.impl.ConvertDataFromList;
import service.impl.ReadFromFileImpl;
import service.impl.WriteToFileImpl;

public class Main {
    public static void main(String[] args) {
        String splitter = ",";
        String dataFile = "src/main/resources/file.txt";
        try {
            Path path = Path.of(dataFile);
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
        String reportFile = "src/main/resources/report.txt";
        ConvertData converter = new ConvertDataFromList(splitter);
        ReadFromFile reader = new ReadFromFileImpl();
        StrategyOfActivities strategy = new StrategyOfActivitiesImpl();
        reader.readFormFile(dataFile).stream()
                .map(converter::converteData)
                .forEachOrdered(s -> strategy.rightActivity(s[0]).doActivity(s[1],
                       Integer.parseInt(s[2])));
        WriteToFile writer = new WriteToFileImpl();
        writer.writeToFile(reportFile, splitter);
    }
}

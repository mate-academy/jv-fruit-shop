package core.basesyntax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;

public class CsvFileWriter {
    public void write(String filepath, Map<String,Integer> storage) {
        try {
            Files.writeString(Paths.get(filepath), "fruit,quantity" + System.lineSeparator());
            for (Map.Entry<String, Integer> entry : storage.entrySet()) {
                Files.writeString(Paths.get(filepath),
                        entry.getKey() + "," + entry.getValue() + System.lineSeparator(),
                        StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            System.out.println("Problems with writing to file");
        }
    }

}

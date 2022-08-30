package storage;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileWriterServiceImpl implements FileWriterService {

    @Override
    public void writeToFile(List<String> fruitDataToWrite) {
        List<String> toWrite = new ArrayList<>();
        toWrite.add("fruit,quantity");
        toWrite.addAll(fruitDataToWrite);
        Path path = new File("src/main/resources/output.csv").toPath();
        try {
            Files.write(path, toWrite, StandardOpenOption.WRITE);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

package core.basesyntax.dao;

import core.basesyntax.dao.processing.SortingService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class WriteToFile {
    public boolean writeToFile(String filePath) {
        Path path = Paths.get(filePath);
        try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        createFile(filePath);

        SortingService sort = new SortingService();
        List<String> stringsToFile = sort.sortDataBeforeWrite();

        try {
            Files.write(path, stringsToFile, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("Error with writing to file. "
                    + "Rerun main. ", e);
        }
        return true;
    }

    private void createFile(String filePath) {
        Path path = Paths.get(filePath);
        try {
            Files.createFile(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

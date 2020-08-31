package core.basesyntax.servise;

import au.com.bytecode.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    public List<String> getListFromInputFile(String filePath) {
        List<String> rows = new ArrayList<>();
        try {
            CSVReader reader = new CSVReader(new FileReader(filePath), ',', '\"', 1);
            String[] strings;
            while ((strings = reader.readNext()) != null) {
                rows.add(String.join(",", strings));
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }
        return rows;
    }

    public void writeOutputFile(List<String> strings, String filePath) {
        Path path = Paths.get(filePath);
        try {
            Files.deleteIfExists(path);
            Files.createFile(path);
            for (String row : strings) {
                Files.writeString(path, row + "\n", StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            throw new RuntimeException("The file can't be written!!!", e);
        }
    }
}

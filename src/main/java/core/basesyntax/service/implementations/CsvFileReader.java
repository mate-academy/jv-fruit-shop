package core.basesyntax.service.implementations;

import core.basesyntax.service.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReader implements FileReader {
    @Override
    public List<String> getAllLines(String path) {
        List<String> list = new ArrayList<>();
        try (BufferedReader bufferedReader =
                     new BufferedReader(Files.newBufferedReader(Path.of(path)))) {
            bufferedReader.readLine();
            String line = bufferedReader.readLine();
            while (line != null) {
                list.add(line);
                line = bufferedReader.readLine();
            }
            if (list.isEmpty()) {
                throw new RuntimeException("File is empty!");
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't locate file at " + path);
        }
        return list;
    }
}
